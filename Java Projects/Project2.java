import java.util.*;
public class Project2 {
    public static void main(String[] args) throws Exception {

        Bank bank = new Bank(args[0]);
        SavingsAccount.setAnnualInterestRate(1.5);
        Scanner sc = new Scanner(System.in);
        char choice = '1'; // arbitrary char
        while(choice != 'Q')
        {
            choice = printMenuAndGetChoice(sc);
            if(choice == 'Q') break;
            else if(choice != 'L' && choice != 'P' && choice != 'D' && choice != 'W' && choice != 'A' && choice != 'R')
            {
                System.out.println("Error: Invalid choice.");
                continue;
            }
            else if(choice == 'A' && bank.isFull())
            {
                System.out.println("Error: bank is full.");
                continue;
            }
            System.out.print("Account number? ");
            int accountNumber = sc.nextInt();
            boolean accountExists = !Objects.isNull(bank.getAccountInfo(accountNumber));
            if(!accountExists && choice != 'A')
            {
                System.out.println("\nError: account number " + accountNumber + " doesn't exist.");
                continue;
            }
            else if(accountExists && choice == 'A')
            {
                System.out.println("\nError: this account number already exists.");
                continue;
            }
            if(choice == 'L')
            {
                MonetaryValue balance = bank.getBalance(accountNumber);
                System.out.println("Balance for account number " + accountNumber + " is " + balance);
            }
            else if(choice == 'P')
            {
                String accInfo = bank.getAccountInfo(accountNumber);
                System.out.println(accInfo);
            }
            else if(choice == 'D')
            {
                System.out.print("Amount to deposit? $");
                MonetaryValue amount = new MonetaryValue(sc.nextDouble());
                boolean failToDeposit = !bank.deposit(accountNumber, amount);
                if(failToDeposit) System.out.println("Error: cannot deposit negative amount of money.");
                else System.out.println("Deposit was successful. Balance for account number " + accountNumber + " is now " + bank.getBalance(accountNumber));
            }
            else if(choice == 'W')
            {
                System.out.print("Amount to withdraw? $");
                MonetaryValue amount = new MonetaryValue(sc.nextDouble());
                boolean insufficientFunds = !bank.withdraw(accountNumber, amount);
                if(amount.isNegative()) System.out.println("Error: cannot withdraw negative amount of money.");
                else if(insufficientFunds) System.out.println("Error: insufficient funds.");
                else System.out.println("Withdrawal was successful. Balance for account number " + accountNumber + " is now " + bank.getBalance(accountNumber));
            }
            else if(choice == 'A')
            {
                System.out.print("First name? ");
                String firstName = sc.next();
                System.out.print("Last name? ");
                String lastName = sc.next();
                Name name = new Name(firstName, lastName);
                System.out.print("Account type (C for checking, S for savings)? ");
                String accountType = sc.next().toUpperCase();
                if(!accountType.equals("C") && !accountType.equals("S")) {
                    System.out.println("Error: invalid account type.");
                    continue;
                }
                MonetaryValue balance = new MonetaryValue();
                if(accountType.equals("C"))
                {
                    System.out.print("Overdraft limit? $");
                    MonetaryValue overdraftLimit = new MonetaryValue(sc.nextDouble());
                    bank.add(new CheckingAccount(accountNumber, name, balance, overdraftLimit));
                }
                else bank.add(new SavingsAccount(accountNumber, name, balance));
                System.out.println("Account successfully added.");
            }
            else if(choice == 'R')
            {
                bank.remove(accountNumber);
                System.out.println("Account successfully removed.");
            }
        }
        sc.close();
    }

    public static char printMenuAndGetChoice(Scanner sc) {
        System.out.println();
        System.out.println("To lookup a balance: L");
        System.out.println("To print information about an account: P");
        System.out.println("To deposit money: D");
        System.out.println("To withdraw money: W");
        System.out.println("To add an account: A");
        System.out.println("To remove an account: R");
        System.out.println("To quit: Q");
        System.out.print("Enter a character (uppercase or lowercase): ");

        char choice = sc.next().toUpperCase().charAt(0);

        System.out.println();

        return choice;
    }
}