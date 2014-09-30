//NEW ORIGINALS 
// **** LAB6POINT1E  DRIVER  *************************************
// IntegerListTest.java
//
// Provide a menu-driven tester for the IntegerList class.
//          
// ****************************************************************
public class IntegerListTest {

    static IntegerList list = new IntegerList(10);
    static String detail_Line = new String();
    static String[] Choices = new String[10];

    //-------------------------------------------------------
    // Create a list, then repeatedly print the menu and do what the
    // user asks until they quit
    //-------------------------------------------------------
    public static void main(String[] args)
    {
        createMenu();

        int choice = GetInfo.getList("Enter your choice", Choices);

        while (choice != 0)
        {
            dispatch(choice);
            choice = GetInfo.getList("Enter your choice", Choices);

        }
    }

    //-------------------------------------------------------
    // Do what the menu item calls for
    //-------------------------------------------------------
    public static void dispatch(int choice)
    {
        int loc;
        switch (choice)
        {
            case 0:
                GetInfo.showMessage("Bye!");
                break;
            case 1:
                int size = GetInfo.getSlider("How big should the list be?", 1, 25);
                list = new IntegerList(size);
                list.randomize();
                break;
            case 2:
                list.selectionSort();
                break;
            case 3:
                loc = list.search(GetInfo.getSlider("Enter the value to look for: ", 1, 100));
                if (loc != -1)
                {
                    GetInfo.showMessage("Found at location " + loc);
                } else
                {
                    GetInfo.showMessage("Not in list");
                }
                break;
            case 4:
//			GetInfo.showMessage(" \n");
                list.print();
                break;
            case 5:
                list.addElement(GetInfo.getInt("Enter the value to add to the list"));
                break;
            case 6:
                list.removeAll(GetInfo.getInt("Which number would you like to remove?"));
                break;
            case 7:
                list.removeFirst(GetInfo.getInt("Which number would you like to remove?"));
                break;
            case 8:
                list.addInOrder(GetInfo.getInt("What number would you like to add in order?"));
                break;
            default:
                GetInfo.showMessage("Sorry, invalid choice");
        }
    }

    //-------------------------------------------------------
    // Print the user's choices
    //-------------------------------------------------------
    public static void createMenu()
    {

        Choices[0] = "0: Quit";
        Choices[1] = "1: Create a new list (** do this first!! **)";
        Choices[2] = "2: Sort the list using selection sort";
        Choices[3] = "3: Find an element in the list using sequential search";
        Choices[4] = "4: Print the list";
        Choices[5] = "5: Add element";
        Choices[6] = "6: Remove All";
        Choices[7] = "7: Remove First";
        Choices[8] = "8: Add in order(Sort first)";

    }

}
