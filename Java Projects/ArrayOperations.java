/*
11. Array Operations
Write a program with an array that is initialized with test data. Use any primitive data type
of your choice. The program should also have the following methods:
•	 getTotal. This method should accept a one-dimensional array as its argument and
return the total of the values in the array.
•	 getAverage. This method should accept a one-dimensional array as its argument and
return the average of the values in the array.
•	 getHighest. This method should accept a one-dimensional array as its argument and
return the highest value in the array.
•	 getLowest. This method should accept a one-dimensional array as its argument and
return the lowest value in the array.
Demonstrate each of the methods in the program.
*/

public class ArrayOperations
{
   public static double getTotal (double [] numbers)
   {
      double total = 0;
      
      for (int currentNumbersIndex = 0; currentNumbersIndex < numbers.length; currentNumbersIndex++)
      {
         total = total + numbers [currentNumbersIndex];
      }
      return total;
   }
   
   public static double getAverage (double [] numbers)
   {
      double numbersTotal = getTotal (numbers);
      int numberOfItemsInNumbersArray = numbers.length;
      double average = numbersTotal / numberOfItemsInNumbersArray;
      return average;
   }
   
   public static double getHighest (double [] numbers)
   {
      double highestNumber = numbers [0];
      
      for (int currentNumbersIndex = 0; currentNumbersIndex < numbers.length; currentNumbersIndex++)
      {
         if (numbers [currentNumbersIndex] > highestNumber)
         {
            highestNumber = numbers [currentNumbersIndex];
         }
      }
      return highestNumber;
   }
   
   public static double getLowest (double [] numbers)
   {
      double lowestNumber = numbers [0];
      
      for (int currentNumbersIndex = 0; currentNumbersIndex < numbers.length; currentNumbersIndex++)
      {
         if (numbers [currentNumbersIndex] < lowestNumber)
         {
            lowestNumber = numbers [currentNumbersIndex];
         }
      }
      return lowestNumber;
   }
   
   public static void main (String [] args)
   {
      double [] numbers = {6.8, 1.6, 3.9, 1.1, 69};
      
      System.out.println ("Total: " + getTotal(numbers) + "\n" +
      "Average: " + String.format ("%.2f", getAverage(numbers)) + "\n" +
      "Highest: " + getHighest(numbers) + "\n" +
      "Lowest: " + getLowest(numbers));
   }
}