// TASK #2 Add an import statement for the Scanner class
// TASK #2(Alternate)
// Add an import statement for the JOptionPane class

/**
   This program demonstrates how numeric types and
   operators behave in Java.
*/
import java.util.Scanner;

public class NumericTypes
{
   public static void main (String [] args)
   {
      // TASK #2 Create a Scanner object here
      // (not used for alternate)
      Scanner keyboard = new Scanner (System.in);
      // Identifier declarations
      final int NUMBER = 2 ;        // Number of scores
      final int SCORE1 = 100;       // First test score
      final int SCORE2 = 95;        // Second test score
      final int BOILING_IN_F = 212; // Boiling temperature
      int fToC;                     // Temperature Celsius
      double average;               // Arithmetic average
      String output;                // Line of output
      
      // TASK #2 declare variables used here
      String firstName;
      String lastName;
      String fullName;
      
         System.out.print ("Enter your first name.\n");
         firstName = keyboard.nextLine();
         System.out.print ("Enter your last name.\n");
         lastName = keyboard.nextLine();
         
         fullName = firstName + " " + lastName;
         
         System.out.println (fullName + "\n");
         
         
      // TASK #3 declare variables used here
      char firstInitial;
      char lastInitial;
      // TASK #4 declare variables used here
      double diameter;
      double radius;
      double volume;
      
      // Find an arithmetic average.
      average = (SCORE1 + SCORE2) /(double) NUMBER;
      output = SCORE1 + " and " + SCORE2 +
               " have an average of " + average;
      System.out.println(output);

      // Convert Fahrenheit temperature to Celsius.
      fToC = 5 * (BOILING_IN_F - 32) / 9;
      output = BOILING_IN_F + " in Fahrenheit is " +
               fToC + " in Celsius.";
      System.out.println(output);
      System.out.println();      // To leave a blank line

      // ADD LINES FOR TASK #2 HERE
      // Prompt the user for first name
      // Read the user's first name
      // Prompt the user for last name
      // Read the user's last name
      // Concatenate the user's first and last names
      // Print out the user's full name

      System.out.println();      // To leave a blank line

      // ADD LINES FOR TASK #3 HERE
      // Get the first character from the user's first name
      firstInitial = firstName.charAt(0);
      lastInitial = lastName.charAt(0);
      // Print out the user's first initial
      System.out.print (firstInitial);
      System.out.println (lastInitial);
      // Convert the user's full name to uppercase
      fullName = fullName.toUpperCase ();
      // Print out the user's full name in uppercase
      System.out.println(fullName + " has " + fullName.length() + " characters");

      System.out.println();      // To leave a blank line

      // ADD LINES FOR TASK #4 HERE
      // Prompt the user for a diameter of a sphere
      // I am using while(true) so I can enter my diameter 3 times for my task #4
      while(true) {
      System.out.println ("Enter the diameter of the sphere.");
      // Read the diameter
      diameter = keyboard.nextDouble();
      // Calculate the radius
      radius = diameter / 2;
      // Calculate the volume
      volume = 4 * Math.PI * Math.pow(radius, 3) / 3;
      // Print out the volume
      System.out.println ("The volume of the sphere is " + volume + "\n");
      }
   }
}