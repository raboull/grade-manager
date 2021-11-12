/*
    Program summary: Stores grades and performs actions on those grades.
    Program details: 
        --Starting execution point of the program.
        --Program runs until the user selects the option to quit the program.
    Limitations:
        --Requires correct user inputs to perform actions.
        --Does not allow for input of grades.
        --A limited number of grades can be stored and processed.
    Version: 1.0
        --Manager class is created
    Version: 2.0
        --call to the start method is added
*/

public class Driver
{
    public static void main(String [] args)
    {
        UserInterface anInterface = new UserInterface();//create a UserInterface object
        anInterface.start();//this will display instructions for the user and wait for input
    }
}