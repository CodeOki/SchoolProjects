import java.util.Scanner;

public class SavingsAccountTest
{
   public static void main(String [] args)
   {
      Scanner scanner = new Scanner(System.in);
      
      double userAnnualInterestRate;
      double userStartingBalance;
      int userNumberOfMonths;
      double depositAmount;
      double withdrawAmount;
      double totalDeposits = 0;
      double totalWithdrawals = 0;
      double totalInterestEarned = 0;
      
      System.out.println("Please enter the annual interest rate: ");
      userAnnualInterestRate = scanner.nextDouble();
      
      System.out.println("Please enter the starting balance: ");
      userStartingBalance = scanner.nextDouble();
      
      System.out.println("Please enter the numberOfMonths: ");
      userNumberOfMonths = scanner.nextInt();
      
      SavingsAccount account1 = new SavingsAccount(userStartingBalance);
      account1.setAnnualInterestRate(userAnnualInterestRate);
      
      for (int currentMonth = 1; currentMonth <= userNumberOfMonths; currentMonth++)
      {
         System.out.println("How much did you deposit during month " + currentMonth);
         depositAmount = scanner.nextDouble();
         totalDeposits += depositAmount;
         
         account1.deposit(depositAmount);
         
         System.out.println ("How much did you withdraw during month " + currentMonth);
         withdrawAmount = scanner.nextDouble();
         totalWithdrawals += withdrawAmount;
         
         account1.withdraw(withdrawAmount);
         
         totalInterestEarned += account1.addMonthlyInterest();
      }
        
      System.out.printf("The final balance at the end of %d months is %f\nThe total amount of deposits: %f\n"
      + "The total amount of withdrawals: %f\nThe total interest earned : %f", userNumberOfMonths, account1.getBalance(), 
      totalDeposits, totalWithdrawals, totalInterestEarned);
      
   }
}