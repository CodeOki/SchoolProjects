/*
12. SavingsAccount Class
Design a SavingsAccount class that stores a savings account’s annual interest rate and balance.
The class constructor should accept the amount of the savings account’s starting
balance. The class should also have methods for subtracting the amount of a withdrawal,
adding the amount of a deposit, and adding the amount of monthly interest to the balance.
The monthly interest rate is the annual interest rate divided by twelve. To add the monthly
interest to the balance, multiply the monthly interest rate by the balance, and add the result
to the balance.
Test the class in a program that calculates the balance of a savings account at the end of a
period of time. It should ask the user for the annual interest rate, the starting balance, and 
the number of months that have passed since the account was established. A loop should
then iterate once for every month, performing the following:
a.	 Ask the user for the amount deposited into the account during the month. Use the
class method to add this amount to the account balance.
b.	 Ask the user for the amount withdrawn from the account during the month. Use the
class method to subtract this amount from the account balance.
c. Use the class method to calculate the monthly interest.
*/

public class SavingsAccount
{
   private double annualInterestRate;
   private double balance;
   
   public void withdraw(double userAmount)
   {
      balance += userAmount;
   }
   
   public void deposit(double userAmount)
   {
      balance += userAmount;
   }
   
   public double getBalance()
   {
      return balance;
   }
   
   public double addMonthlyInterest()
   {
      double monthlyInterest = ((annualInterestRate / 12) * balance);
      balance += monthlyInterest;
      return monthlyInterest;
   }
   
   public void setAnnualInterestRate(double newRate)
   {
      annualInterestRate = newRate / 100;
      annualInterestRate = newRate;
   }
   
   public SavingsAccount(double startingBalance)
   {
      balance = startingBalance;
      annualInterestRate = 0;
   }
}