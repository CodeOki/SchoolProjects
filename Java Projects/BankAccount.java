import java.util.ArrayList;
public abstract class BankAccount implements Comparable<BankAccount> {
    private int accountNumber;
    private Name name;
    protected MonetaryValue balance;
    private ArrayList<Transaction> transactions;

    public BankAccount() {
        accountNumber = 0;
        name = new Name();
        balance = new MonetaryValue();
    }

    public BankAccount(int accountNumber, Name name, MonetaryValue balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
        transactions = new ArrayList<>();
        Transaction t = new Transaction("create account", new MonetaryValue(0), new MonetaryValue(balance), true);
        transactions.add(t);
    }

    public BankAccount(BankAccount old) {
        this.accountNumber = old.accountNumber;
        this.name = old.name;
        this.balance = old.balance;
        this.transactions = old.transactions;
    }

    @Override 
    public boolean equals(Object obj) {
        if(obj instanceof BankAccount) {
          BankAccount other = (BankAccount)obj;
          return this.accountNumber == other.accountNumber &&
                 this.name.equals(other.name) &&
                 this.balance.equals(other.balance) &&
                 this.transactions.equals(other.transactions);
        } else {
          return false;
        }
    }

    @Override
    public String toString() {
        return "Account number: " + accountNumber + "\n" +
               "Name: " + name.toString() + "\n" +
               "Balance: " + balance.toString();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public MonetaryValue getBalance() {
        return balance;
    }
    
    public ArrayList<Transaction> getTransactions() {
      return transactions;
    }

    public boolean deposit(MonetaryValue amount) {
        if(amount.isNegative()) {
            transactions.add(new Transaction("deposit", amount, new MonetaryValue(balance), false));
            return false;
        } else {
            balance.add(amount);
            transactions.add(new Transaction("deposit", amount, new MonetaryValue(balance), true));
            return true;
        }
    }

    public boolean withdraw(MonetaryValue amount) throws InsufficientFundsException {
        if(amount.isNegative()) {
            transactions.add(new Transaction("withdraw", amount, new MonetaryValue(balance), false));
            return false;
        }
        if(amount.isGreaterThan(availableAmount())) {
            transactions.add(new Transaction("withdraw", amount, new MonetaryValue(balance), false));
            throw new InsufficientFundsException(amount, availableAmount());
        } else {
            balance.subtract(amount);
            transactions.add(new Transaction("withdraw", amount, new MonetaryValue(balance), true));
            return true;
        }
    }
    
    @Override
    public int compareTo(BankAccount other) {
      if(this.accountNumber > other.accountNumber) {
         return -1;
      } else if(this.accountNumber < other.accountNumber) {
         return -1;
      } else {
         return 0;
      }
    } 
    
    public abstract MonetaryValue availableAmount();
}