/*
14. Population Data
If you have downloaded this book’s source code (the companion Web site is available at
www.pearsonhighered.com/gaddis), you will find a file named USPopulation.txt in the
Chapter 07 folder. The file contains the midyear population of the United States, in thousands, 
during the years 1950 through 1990. The first line in the file contains the population
for 1950, the second line contains the population for 1951, and so forth.

Write a program that reads the file’s contents into an array. The program should display
the following data:

•	 The average annual change in population during the time period
•	 The year with the greatest increase in population during the time period
•	 The year with the smallest increase in population during the time period
*/

import javax.swing.JOptionPane;

public class Population
{
   public static void main (String [] args)
   {
      String userInputString;
      int startingNumberOfOrganisms;
      double userPercentageIncrease;
      int numberOfDays;
      double dailyPopulation;
      double percentageIncrease;
      String output = "Day   \tDaily Population\n-----    ---------------------\n";
      
      userInputString = JOptionPane.showInputDialog ("Please enter the starting number of organisms: ");
      startingNumberOfOrganisms = Integer.parseInt (userInputString);
      
      while (startingNumberOfOrganisms < 2)
      {
         userInputString = JOptionPane.showInputDialog ("Error: Please enter a number, 2 and above\n\n" +
         "Please enter the starting number of organisms (2 and above): ");
         startingNumberOfOrganisms = Integer.parseInt (userInputString);
      }
      
      userInputString = JOptionPane.showInputDialog ("Please enter the average daily population increase as a percentage: ");
      userPercentageIncrease = Double.parseDouble (userInputString);
      
      while (userPercentageIncrease < 0)
      {
         userInputString = JOptionPane.showInputDialog ("Error: Please enter a positive number\n\n" +
         "Please enter the average daily population increase as a percentage (Posiitive numbers): ");
         userPercentageIncrease = Double.parseDouble (userInputString);
      }
      
      userInputString = JOptionPane.showInputDialog ("Please enter the number of days they'll multiply: ");
      numberOfDays = Integer.parseInt (userInputString);
      
      while (numberOfDays < 1)
      {
         userInputString = JOptionPane.showInputDialog ("Error: Please enter a number, 1 and above\n\n" +
         "Please enter the number of days they'll multiply (greater than 1)");
         numberOfDays = Integer.parseInt (userInputString);
      }
      
      dailyPopulation = startingNumberOfOrganisms;
      percentageIncrease = userPercentageIncrease / 100;
      
      for (int day = 1; day <= numberOfDays; day++)
      {
         output += String.format (day + "        %f\n", dailyPopulation);
         dailyPopulation = dailyPopulation + (percentageIncrease * dailyPopulation);
      }
      JOptionPane.showMessageDialog (null, output);
      System.exit(0);
   }
}