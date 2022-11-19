import java.io.*;
import java.util.*;

public class Bank {
    public static void main(String[] args) throws Exception {

      Scanner sc = new Scanner(new FileReader("Accounts.txt"));
      Scanner keyboard = new Scanner(System.in);
      final int capacity = 100;
      int[] accountNumbers = new int[capacity];
      double[] balances = new double[capacity];
      double amount = 0;
      
      int numAccounts = readAccounts(sc, accountNumbers, balances);
            
      printMenu();
      String choice = keyboard.next().toUpperCase();
      
      while(!choice.equals("Q")) {
         if(choice.equals("L")) {
            int accountNumber;
            double balance;
            
            System.out.print("Account Number? ");
            accountNumber = keyboard.nextInt();
            
            balance = getBalance(accountNumber, accountNumbers, balances, numAccounts);
            
            if(balance == -1) {
               System.out.println("Account is not in database. Try again.");
            } else {
               System.out.println(accountNumber + "'s balance is " + balance);
            }
         } else if(choice.equals("D")) {
            int accountNumber;
            double balance;
            
            System.out.print("Account number? ");
            accountNumber = keyboard.nextInt();
            System.out.print("Deposit amount? ");
            amount = keyboard.nextDouble();
            
            boolean isSuccess = deposit(accountNumber, amount, accountNumbers, balances, numAccounts);
            
            if(isSuccess) {
               System.out.println("Successfully deposited the amount to your balance");
            } else {
               System.out.println("This account number doesn't exist in the database. Try again.");
            }
         } else if(choice.equals("W")) {
            int accountNumber;
            double balance;
            
            System.out.print("Account number? ");
            accountNumber = keyboard.nextInt();
            System.out.print("Withdraw amount? ");
            amount = keyboard.nextDouble();
            
            boolean isSuccess = withdraw(accountNumber, amount, accountNumbers, balances, numAccounts);
            
            if(isSuccess) {
               System.out.println("Successfully withdrew the amount from your balance");
            } else {
               System.out.println("This account number either doesn't exist in the database or withdraw amount exceeded. Try again.");
            }
         } else if(choice.equals("A")) {
            int accountNumber;
            double balance;
            
            System.out.print("Account number? ");
            accountNumber = keyboard.nextInt();
            
            boolean isSuccess = addAccount(accountNumber, accountNumbers, balances, numAccounts, capacity);
            
            if(isSuccess) {
               System.out.println("Successfully added an account to database");
               numAccounts++;
         } else {
            if(findAccountIndex(accountNumber, accountNumbers, numAccounts) >= 0) {
               System.out.println("Unsuccessful due to account already existing in database");
            } else {
               System.out.println("Unsuccessful due to inadequate space in database");
            }
           }
         } else if(choice.equals("R")) {
            int accountNumber;
            double balance;
            
            System.out.print("Account number? ");
            accountNumber = keyboard.nextInt();
            
            boolean isSuccess = removeAccount(accountNumber, accountNumbers, balances, numAccounts);
            
            if(isSuccess) {
               System.out.println("Successfully removed an account from database");
               numAccounts--;
            } else {
               System.out.println("Account not found in database so couldn't be removed");
            }
         } else if(choice.equals("P")) {
            printAccounts(accountNumbers, balances, numAccounts);
         } else {
            System.out.println("Invalid choice; try again.");
         }
         
         printMenu();
         choice = keyboard.next().toUpperCase();
      }
      
      keyboard.close();            
    }
    
    public static int readAccounts(Scanner sc, int[] accountNumbers, double[] balances) {
      int count = 0;
      while(sc.hasNext()) {
         accountNumbers[count] = sc.nextInt();
         balances[count] = sc.nextDouble();
         count++;
      }
      return count;   
    }

    public static void printMenu() {
      System.out.println("Welcome to Bank of DW! How can I help you?");
      System.out.println("- Lookup balance (L)");
      System.out.println("- Deposit Money (D)");
      System.out.println("- Withdraw money (W)");
      System.out.println("- Add a new account (A)");
      System.out.println("- Remove an account (R)");
      System.out.println("- Print all accounts (P)");
      System.out.println("- Quit the program (Q)");
    }

    public static int findAccountIndex(int accountNumber, int[] accountNumbers, int numAccounts) {
      for(int i = 0; i < numAccounts; i++) {
         if(accountNumbers[i] == accountNumber) {
            return i;
         }
      }
      return -1;
    }

    public static double getBalance(int accountNumber, int[] accountNumbers, double[] balances, 
            int numAccounts) {
         int index = findAccountIndex(accountNumber, accountNumbers, numAccounts);
         if(index == -1) {
            return -1;
         } else {
            return balances[index];
         }
    }

    public static boolean deposit(int accountNumber, double amount, int[] accountNumbers, double[] balances,
            int numAccounts) {
      int entryLocation = findAccountIndex(accountNumber, accountNumbers, numAccounts);
         if(entryLocation == -1) {
            return false;
         } else {
            balances[entryLocation] = balances[entryLocation] + amount;
            return true;
         }
    }

    public static boolean withdraw(int accountNumber, double amount, int[] accountNumbers, double[] balances, int numAccounts) {
      int entryLocation = findAccountIndex(accountNumber, accountNumbers, numAccounts);
      if(entryLocation == -1) {
         return false;
      } else if(amount > balances[entryLocation]) {
         return false;
      } else {
         balances[entryLocation] = balances[entryLocation] - amount;
         return true;
      }
    }

    public static boolean addAccount(int accountNumber,  int[] accountNumbers, double[] balances, 
            int numAccounts, int capacity) {
      if(numAccounts == capacity) {
         return false;
      }
      if(findAccountIndex(accountNumber, accountNumbers, numAccounts) >= 0) {
         return false;
      }
      
      accountNumbers[numAccounts] = accountNumber;
      balances[numAccounts] = 0;
      
      return true;
    }

    public static void printAccounts(int[] accountNumbers, double[] balances, int numAccounts) {
      System.out.println("Account Number \tBalance");
      for(int i = 0; i < numAccounts; i++) {
         System.out.println(accountNumbers[i] + "\t\t\t\t\t" + balances[i]);
      }
    }
    
    public static boolean removeAccount(int accountNumber, int[] accountNumbers, double[] balances, int numAccounts) {
      int entryLocation = findAccountIndex(accountNumber, accountNumbers, numAccounts);
         if(entryLocation == -1) {
            return false;
         }
         
         for(int i = entryLocation; i < numAccounts - 1; i++) {
            accountNumbers[i] = accountNumbers[i + 1];
            balances[i] = balances[i + 1];
         }
         return true;  
    }
}