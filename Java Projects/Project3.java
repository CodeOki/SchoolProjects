import java.util.Scanner;

public class Project3 {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java Project2 <filename>");
            System.exit(1);
        }

        SavingsAccount.setAnnualInterestRate(1.5);

        Bank bank = new Bank(args[0]);
        Scanner keyboard = new Scanner(System.in);

        char choice = printMenuAndGetChoice(keyboard);

        while (choice != 'Q') {
            if (choice == 'L') {
                System.out.print("Account number? ");
                int accountNumber = keyboard.nextInt();
                if (!bank.contains(accountNumber)) {
                    System.out.println("Error: account number " + accountNumber + " doesn't exist.");
                } else {
                    MonetaryValue balance = bank.getBalance(accountNumber);
                    System.out.println("Balance for account number " + accountNumber + " is " + balance.toString());
                }
            } 
            
            else if (choice == 'P') {
                System.out.print("Account number? ");
                int accountNumber = keyboard.nextInt();
                if (!bank.contains(accountNumber)) {
                    System.out.println("Error: account number " + accountNumber + " doesn't exist.");
                } else {
                    System.out.println(bank.getAccountInfo(accountNumber));
                }
            }
            
            else if(choice == 'T') {
               System.out.print("Account number? ");
               int accountNumber = keyboard.nextInt();
               if(!bank.contains(accountNumber)) {
                  System.out.println("Error: account number " + accountNumber + " doesn't exist.");
               } else {
                  bank.printTransactions(accountNumber);
               }
            } 
            
            else if (choice == 'D') {
                System.out.print("Account number? ");
                int accountNumber = keyboard.nextInt();
                if (!bank.contains(accountNumber)) {
                    System.out.println("Error: account number " + accountNumber + " doesn't exist.");
                } else {
                    System.out.print("Amount to deposit? $");
                    double amount = keyboard.nextDouble();
                    if (amount < 0) {
                        System.out.println("Error: cannot deposit negative amount of money.");
                    } else {
                        bank.deposit(accountNumber, new MonetaryValue(amount));
                        System.out.println("Deposit was successful. Balance for account number " + accountNumber + 
                                           " is now " + bank.getBalance(accountNumber));
                    }
                }
            }

            else if (choice == 'W') {
                System.out.print("Account number? ");
                int accountNumber = keyboard.nextInt();
                if (!bank.contains(accountNumber)) {
                    System.out.println("Error: account number " + accountNumber + " doesn't exist.");
                } else {
                    System.out.print("Amount to withdraw? $");
                    double amount = keyboard.nextDouble();
                    if (amount < 0) {
                        System.out.println("Error: cannot withdraw negative amount of money.");
                    } else {
                        try {
                            bank.withdraw(accountNumber, new MonetaryValue(amount));
                            System.out.println("Withdrawal was successful. Balance for account number " + accountNumber + 
                                               " is now " + bank.getBalance(accountNumber));
                        } catch(InsufficientFundsException ex) {
                           System.out.println(ex);
                        }
                       
                    }
                }
            }

            else if (choice == 'A') {
                try {
                    System.out.print("Account number? ");
                    int accountNumber = keyboard.nextInt();

                    if (bank.contains(accountNumber)) {
                        System.out.println("Error: this account number already exists.");
                    } else {
                        String first, last;
                        System.out.print("First name? ");
                        first = keyboard.next();
                        System.out.print("Last name? ");
                        last = keyboard.next();
                        Name name = new Name(first, last);

                        MonetaryValue balance = new MonetaryValue(0);

                        BankAccount account;

                        System.out.print("Account type (C for checking, S for savings)? ");
                        char type = keyboard.next().charAt(0);
                        if (type == 'C' || type == 'S') {
                            if (type == 'C') {
                                System.out.print("Overdraft limit? $");
                                MonetaryValue overdraftLimit = new MonetaryValue(keyboard.nextDouble());
                                account = new CheckingAccount(accountNumber, name, balance, overdraftLimit);
                            } else {
                                account = new SavingsAccount(accountNumber, name, balance);
                            }
                            bank.add(account);
                            System.out.println("Account successfully added.");
                        } else {
                            System.out.println("Error: invalid account type.");
                        }
                    }
                } catch(DuplicateAccountNumberException ex) {
                     System.out.println(ex.getMessage());
                  }
            }

            else if (choice == 'R') {
                System.out.print("Account number? ");
                int accountNumber = keyboard.nextInt();

                if (!bank.contains(accountNumber)) {
                    System.out.println("Error: this account number doesn't exist.");
                } else {
                    bank.remove(accountNumber);
                    System.out.println("Account successfully removed.");
                }
            }

            else {
                System.out.println("Error: Invalid choice.");
            }

            System.out.println();
            choice = printMenuAndGetChoice(keyboard);
        }

        System.out.println();
        keyboard.close();
    }
    
    public static char printMenuAndGetChoice(Scanner sc) {
        System.out.println();
        System.out.println("To lookup a balance: L");
        System.out.println("To print information about an account: P");
        System.out.println("To print transactions for an account: T");
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