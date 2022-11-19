/*
10.   Largest and Smallest
Write a program with a loop that lets the user enter a series of integers. 
The user should enter -99 to signal the end of the series.
After all the numbers have been entered, the program should display the largest and smallest numbers entered.
*/

import java.util.Scanner;

public class LargestAndSmallest
{
   public static void main(String [] args)
   {
      Scanner keyboard = new Scanner (System.in);
      
      int userInteger;
      int sentinel = -99;
      int smallestNumber;
      int largestNumber;
      
      System.out.println ("Please enter your first number: ");
      userInteger = keyboard.nextInt();
      
      smallestNumber = userInteger;
      largestNumber = userInteger;
      
      while (userInteger != sentinel) {
         if (userInteger < smallestNumber) {
            smallestNumber = userInteger;
         } else if (userInteger > largestNumber) {
            largestNumber = userInteger;
         }
         System.out.println ("Type in your next number or type [-99] to end: ");
         userInteger = keyboard.nextInt();
      }
      System.out.println ("Among all your numbers, " + smallestNumber + " is the smallest number " +
      "and " + largestNumber + " is the largest number.");
   }
}