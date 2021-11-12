/*
    Class details: 
        --Stores the grades in a 1D array of NUM_GRADES in length.
        --Can directly access or change grade information.
        --Elements of the grades array are initialized to a value of -1
        --Displays the contents of the grades array by displaying all grades or only valid grades.
        --Assigns a fixed grade of 2.0 to all array elements, previous values are overwritten.
        --Assigns random values (from 0 to 4) to the first 10 elements of the grades array.
        --When assigning grades, the previous values are overwritten.
        --Calculates and displays the average grade.
        --Determines and displays the highest grade in the grades array.
        --Determines and displays the lowest grade in the grades array.
    Limitations: 
        --Number of stored grades is liminted to 20.
        --The out of bounds grade value can not be altered by the user.
        --The range of valid grades can not be altered by the user.
        --User cannot specify the precision of output.
        --When setting a constant grade user cannot specify that value.
    Version: 1.0
        --Manager class is created
    Version: 2.0
        --Refactored the avg, highest, lowest, displayBasic, and displayAdvanced functions to 
        use numOfValid variable instead of checking for valid values while iterating through 
        the grades array.
*/

import java.util.Random;
import java.util.Scanner;

public class Manager
{
    private final int NUM_GRADES = 20;//this variable dictates the size of the grades array
    private double [] grades;//create an array reference object
    private int numOfValid = -1; //this variable stores the number of valid grades in the array

    //a no parameter constructor of the Manager class
    public Manager()
    {
        initializeGrades();//set out of bound values to all grades
    }

    //this function inialized the grades array to an out of bounds value
    private void initializeGrades()
    {
        grades = new double[NUM_GRADES];//create an array and set grades to refer to its address
        for (int i=0; i < grades.length; i++)
        {
            grades[i] = -1;//set each element to -1
        }
    }

    //this function displays all the grades in the grades array
    public void displayBasic()
    {
        System.out.println("Displaying all grades!");
        
        for (int i = 0; i < grades.length; i++)
        {
            if (i < grades.length-1)
            {
                System.out.printf("%.1f, ", grades[i] );//print grades on one line separated by a comma
            }
            else if (i == grades.length-1)//do this if we are at the last element of the grades array
            {
                System.out.printf("%.1f \n", grades[i] );//print the last element without a comma after it
                System.out.println("");//print a blank line for readibility
            }
        }
    }

    //this function displays all valid grades in the grades array
    public void displayAdvanced()
    {
        System.out.println("Displaying only valid grades!");
        setNumOfValid();//count the number of valid grades in the grades array currently

        //do the following if valid grades are present
        if (numOfValid > 0)
        {
            for (int i = 0; i < grades.length; i++)//itterate through the grades array
            {
                if (grades[i] != -1 && i < numOfValid-1)//check if current grade element is valid and not the last valid element
                {  
                    System.out.printf("%.1f, ", grades[i] );//print valid grades separated by a comma
                }
                else if (grades[i] != -1 && i == numOfValid-1)//check if current grade element is valid and it is the last valid element
                {  
                    System.out.printf("%.1f \n", grades[i] );//print the last element without a comma after it
                    System.out.println("");//print a blank line for readibility
                }
            }
        }
        //do the following if valid grades are not present
        else if (numOfValid == 0)
        {
            System.out.println("There are no valid grades to display.");
            System.out.println("");//print a blank line for readibility
        }
    }

    //this function initializes the first ten grades to random values
    public void assignRandom()
    {        
        System.out.println("Assigning random values to the first 10 grades!");
        System.out.println("");//print a blank line for readibility

        Random aGenerator = new Random();//create a Random object and set aGenerator to reference the object
        for (int i = 0; i < 10; i++)//itterate through the grades array
        {
            //set each element to a random value between 0 (inclusive) and 4 (exclusive)
            grades[i] = (float)aGenerator.nextInt(41)/10;
        }
    }

    //set all grades to a value of 2.0
    public void assignSpecific()
    { 
        System.out.println("Assigning a value of 2.0 to all grades!");
        System.out.println("");//print a blank line for readibility

        for (int i = 0; i < grades.length; i++)//itterate through the grades array
        {
            //set each element to the user specified value
            grades[i] = 2.0;
        }
    }

    //this method computes and displays the average grade
    public void dispAvgGrade()
    {
        double temp = 0;//this is a temporary variable to store a running average of valid grades
        double avg = 0;//this variable will store the calculated average grade
        setNumOfValid();//count the number of valid grades in the grades array currently

        if (numOfValid >= 1)//check if there are any valid grades present
        {
            for (int i=0; i < grades.length; i++)//add up all the valid grades
            {
                if (grades[i] != -1)
                {
                    temp = temp + grades[i];
                }
            }
            avg = temp/numOfValid;//calculate the average grade
            System.out.printf("The average grade is: %.1f\n", avg);
            System.out.println("");//print a blank line for readibility           
        }
        else if (numOfValid == 0)//print this message if there are no valid grades
        {
            System.out.println("There are no valid grades to compute an average.");
            System.out.println("");//print a blank line for readibility
        }
    }

    //this function will determine the number of currently valid grades stored in the grades array
    private void setNumOfValid()
    {
        numOfValid = 0;//start counting from zero
        for (int i = 0; i < grades.length; i++)
        {
            if (grades[i] != -1)
            {
                numOfValid++;//increment the counter when a value that is not -1 is encountered
            }
        }
    }

    //this function will determine and display the highest grade
    public void displayHighest()
    {
        setNumOfValid();//count the number of valid grades in the grades array currently
        
        if (numOfValid >= 1)//check if there are any valid grades present
        {
            double highest = grades[0];//this variable will store the currently highest value found, initialized to first element of grades array
            for (int i=1; i < grades.length; i++)//traverse through the grades array starting at the second element
            {
                //if an element larger than current max is encountered then set highest to the encountered element
                if (grades[i] > highest)
                {
                    highest = grades[i];
                }
            }
            System.out.printf("The highest grade is: %.1f\n", highest);
            System.out.println("");//print a blank line for readibility
        }
        else if (numOfValid == 0)//print this message if there are no valid grades
        {
            System.out.println("There are no valid grades to compute highest.");
            System.out.println("");//print a blank line for readibility
        }
    }

    //this function will determine and display the lowest grade
    public void displayLowest()
    {        
        setNumOfValid();//count the number of valid grades in the grades array currently
        
        if (numOfValid >= 1)//check if there are any valid grades present
        {
            double lowest = grades[0];//this variable will store the currently lowest value found
            for (int i=1; i < grades.length; i++)//traverse through the grades array starting at the second element
            {
                //if an element smaller than current smallest and it is valid then set that as the new lowest
                if (grades[i] < lowest && grades[i] != -1)
                {
                    lowest = grades[i];
                }
            }
            System.out.printf("The lowest grade is: %.1f\n", lowest);
            System.out.println("");//print a blank line for readibility
        }
        else if (numOfValid == 0)//print this message if there are no valid grades
        {
            System.out.println("There are no valid grades to compute lowest.");
            System.out.println("");//print a blank line for readibility
        }
    }
}