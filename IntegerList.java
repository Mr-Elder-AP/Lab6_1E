// ***** LAB6POINT1E *********************************************
// IntegerList.java
//
// Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//          
// ****************************************************************

import java.util.*;
public class IntegerList {

	int[] list; // values in the list
	int arraySize = 0;

	// -------------------------------------------------------
	// CONSTRUCTOR - create a list of the given size
	// -------------------------------------------------------
	public IntegerList(int size) {
		list = new int[size];
		arraySize = size;
	}

	// -------------------------------------------------------
	// fill array with integers between 1 and 100, inclusive
	// -------------------------------------------------------
	public void randomize() {
		for (int i = 0; i < list.length; i++) {
			list[i] = (int) (Math.random() * 100) + 1;
		}
	}

	// -------------------------------------------------------
	// print array elements with indices
	// -------------------------------------------------------
	public void print() {
		String myString = new String("");
		String myDetail;

		int currentVal = 0;
		for (int i = 0; i < this.list.length; i++) {
			if (this.list[i] != 0) {				
				myDetail = new String(currentVal + ":\t" + list[i] + "\n");
				myString = myString + myDetail;
				currentVal++;
			}
		}

		myString = myString + ("\n");

		GetInfo.showMessage(myString);
	}

	// -------------------------------------------------------
	// return the index of the first occurrence of target in the list.
	// return -1 if target does not appear in the list
	// -------------------------------------------------------
	public int search(int target) {
		int location = -1;
		for (int i = 0; i < list.length && location == -1; i++) {
			if (list[i] == target) {
				location = i;
			}
		}
		return location;
	}

	// -------------------------------------------------------
	// sort the list into ascending order using the selection sort algorithm
	// -------------------------------------------------------
	public void selectionSort() {
		int minIndex;
		for (int i = 0; i < list.length - 1; i++) {
			// find smallest element in list starting at location i
			minIndex = i;
			for (int j = i + 1; j < list.length; j++) {
				if (list[j] < list[minIndex]) {
					minIndex = j;
				}
			}

			// swap list[i] with smallest element
			int temp = list[i];
			list[i] = list[minIndex];
			list[minIndex] = temp;
		}
	}

	public void increaseSize() {
		if (arrayFull()) {
			int[] temp = new int[this.list.length];

			for (int i = 0; i < this.list.length; i++) {
				temp[i] = this.list[i];
			}

			this.list = new int[this.list.length * 2];

			for (int i = 0; i < temp.length; i++) {
				this.list[i] = temp[i];
			}
		}
	}

	public boolean arrayFull() {
		boolean full = true;

		for (int i = 0; i < this.list.length; i++) {
			if (this.list[i] == 0) {
				full = false;
			}
		}

		return full;
	}

	public void addElement(int val) {
		if (arrayFull()) {
			System.out.println("Array is full");
			increaseSize();
		}

		for(int i = 0; i < this.list.length; i++)
		{
			if(this.list[i] == 0)
			{
				this.list[i] = val;
				i = this.list.length;
			}
		}

		arraySize++;
	}

	public void removeFirst(int val) {
		int[] temp = new int[this.list.length];

		int indexFound = search(val);
		System.out.println("Index Found : " + indexFound);

		if (indexFound == -1) {
			// It wasn't found
		} else {
			for (int i = 0; i < this.list.length; i++) {
				temp[i] = this.list[i];
			}

			this.list = new int[temp.length - 1];

			int tempIndex = 0;
			for (int i = 0; i < temp.length; i++) {
				if (i != indexFound) {
					this.list[tempIndex] = temp[i];
					tempIndex++;
				}
			}

			arraySize--;
		}
	}

	public void removeAll(int val) {
		int newLength = 0;

		int totalFound = 0;
		for (int i = 0; i < this.list.length; i++) {
			if (this.list[i] == val) {
				totalFound++;
			}
		}

		newLength = this.list.length - totalFound;

		int[] arrayWithoutVal = new int[newLength];

		int arrayWithoutNext = 0;
		for (int i = 0; i < this.list.length; i++) {
			if (this.list[i] != val) {
				arrayWithoutVal[arrayWithoutNext] = this.list[i];
				arrayWithoutNext++;
			}
		}

		this.list = new int[arrayWithoutVal.length];

		for (int i = 0; i < this.list.length; i++) {
			this.list[i] = arrayWithoutVal[i];
		}

		arraySize -= totalFound;

	}
	
	public void clearAll()
	{
		for(int i = 0; i < this.list.length; i++)
		{
			this.list[i] = 0;
		}
	}

	public void addAtIndex(int index, int val) {	
		
		if (arrayFull()) {
			increaseSize();
		}
		
		int temp[] = new int[this.list.length];

		for (int i = 0; i < this.list.length; i++) {
			temp[i] = this.list[i];
		}

		this.list = new int[this.list.length];

		int listIndex = 0;
		int tempIndex = 0;
		while (listIndex < this.list.length) {
			if (listIndex != index) {
				this.list[listIndex] = temp[tempIndex];
				listIndex++;
				tempIndex++;
			} else {
				this.list[listIndex] = val;
				listIndex++;
			}
		}

		arraySize++;
	}

	public void addInOrder(int val) {				
		for (int i = 0; i < this.list.length; i++) 
		{
			if (val == this.list[i]) 
			{
				addAtIndex(i, val);
				i = this.list.length;
			} else if (i == 0 && val < this.list[0]) 
			{
				addAtIndex(0, val);
				i = this.list.length;
			} else if (i == this.list.length - 1 && val > this.list[this.list.length - 1]) 
			{
				addAtIndex(this.list.length, val);
				i = this.list.length;
			} else if (i > 0 && i < this.list.length - 1) 
			{
				if (val > this.list[i] && val < this.list[i + 1]) 
				{
					addAtIndex(i + 1, val);
					i = this.list.length;
				}
			}
		}

	}
	
	public void appendRandomNums(int count)
	{
		for(int i = 0; i < count; i++)
		{
			addElement(new Random().nextInt(100));
		}
	}
}
