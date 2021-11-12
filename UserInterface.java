/*
    Class summary: UserInterface class
    Class details: 
        --This class is responsible for displaying all menus.
        --Gets user input and starts the appropriate response action.
        --Continuously runs until the user requests to quit the program.
    Limitations: 
        --User input must match the expected input exactly.
        --Only one user command can be processed at a time, does not take a chain of commands as input.
        --Input is not verified and no exception handling is performed on input
    Version: 1.0
        --UserInterface class is created
    Version: 2.0
        --Refactored the switch statement to exclude messages to the user, these messages are now embedded
        in their functions.
*/
import java.util.Scanner;

public class UserInterface
{
    private Scanner in;//create an object that will be readint user input
    private boolean done;//this boolean variable will hold a flag to indicate if the program should stop
    private Manager aManager;//create a Manager object reference variable

    public UserInterface ()
    {
        in = new Scanner(System.in);//create a new scanner object
	    done = false;//initialize the done flag to false
        aManager = new Manager(); //create a manager object and set aManager to its address
    }
    
    //this function provides options for the user
    private void displayMenu ()
    {
        System.out.println("Enter a number that corresponds to the desired action.");
        System.out.println("1: randomly assign the first ten grades.");
        System.out.println("2: assign a grade of 2.0 to all grades.");
        System.out.println("3: display all grades.");
        System.out.println("4: display only valid grades.");
        System.out.println("5: display the average grade.");
        System.out.println("6: display the highest grade.");
        System.out.println("7: display the lowest grade.");
        System.out.println("8: quit the program");
	    System.out.print("Your selection: ");
    }

    //this function starts the appropriate process based on user input
    private void processMenu (char selection)
    {
        System.out.println();
        switch(selection)
        {
            case '1': aManager.assignRandom();
            break;
            case '2': aManager.assignSpecific();
            break;
            case '3': aManager.displayBasic();
            break;
            case '4': aManager.displayAdvanced();
            break;
            case '5': aManager.dispAvgGrade();
            break;
            case '6': aManager.displayHighest();
            break;
            case '7': aManager.displayLowest();
            break;
            case '8': quitProgram();
            break;

            default: System.out.println("Invalid entry. Please try again.");
        }
    }
    
    public void start ()
    {
        final int FIRST = 0;//create a constant that will represent the first element in a string
        String line = null;//this variable will hold the user input, intialize to null
        char selection = ' ';//this variable will hold the first character extracted from user input
                
        while (done == false)//run this loop until the user chooses to quit (enters 'q')
        {
            displayMenu();//call this method to display the program options to the user
            line = in.nextLine();//store the user input as a string
            selection = line.charAt(FIRST);//extract the first char from the user input string
            processMenu(selection);//pass the user input to the processMenu function
        }
    }

    //this function is called when the user selects to quit the program
    private void quitProgram()
    {
        System.out.println("Quitting the program. Have a nice day!");
        done = true;
    }
}