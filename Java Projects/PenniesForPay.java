/*
4. Pennies for Pay
Write a program that calculates the amount a person would earn over a period of time if his
or her salary is one penny the first day, two pennies the second day, and continues to double
each day. The program should display a table showing the salary for each day, and then
show the total pay at the end of the period. The output should be displayed in a dollar
amount, not the number of pennies.
Input Validation: Do not accept a number less than 1 for the number of days worked
*/

import java.util.Scanner;

public class PenniesForPay
{
   public static void main(String [] args)
   {
      Scanner keyboard = new Scanner (System.in);
      
      int daysWorked;
      int penniesFortheDay;
      int totalPennies = 0;
      final int PENNIES_IN_A_DOLLAR = 100;
      double totalSalary = 0;
      
      System.out.println ("Enter the number of days you have worked.");
      daysWorked = keyboard.nextInt();
      
      System.out.println ("Day\tPennies for the day\n----\t----------------\n");
      for (int day = 1; day <= daysWorked; day++) {
         penniesFortheDay = (int)(Math.pow(2 , day - 1));
         System.out.println(day + "\t" + penniesFortheDay);
         totalPennies = totalPennies + penniesFortheDay;
      }
      totalSalary = (double)totalPennies / PENNIES_IN_A_DOLLAR;
      System.out.println("Total Salary: $" + totalSalary);
   }
}         