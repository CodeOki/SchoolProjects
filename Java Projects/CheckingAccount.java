import java.util.*;
public class CheckingAccount extends BankAccount {
    private MonetaryValue overdraftLimit;

    public CheckingAccount() {
        super();
        overdraftLimit = new MonetaryValue();
    }

    public CheckingAccount(int accountNumber, Name name, MonetaryValue balance, MonetaryValue overdraftLimit) {
        super(accountNumber, name, balance);
        this.overdraftLimit = overdraftLimit;
    }

    public CheckingAccount(CheckingAccount old) {
        super(old);
        this.overdraftLimit = old.overdraftLimit;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof CheckingAccount) {
          CheckingAccount other = (CheckingAccount)obj;
          return super.equals(other) && this.overdraftLimit.equals(other.overdraftLimit);
        } else {
          return false;
        }
    }

    @Override 
    public String toString() {
        return "Checking account: " + "\n" +
               super.toString() + "\n" + "Overdraft Limit: " + overdraftLimit;
    }
    
    @Override
    public MonetaryValue availableAmount() {
        return new MonetaryValue(balance.doubleValue() + overdraftLimit.doubleValue());
        
    }

    public static CheckingAccount read(Scanner sc) {
        if(!sc.hasNext()) {
          return null;
        }
        int accountNumber = sc.nextInt();
        Name name = Name.read(sc);
        MonetaryValue balance = MonetaryValue.read(sc);
        MonetaryValue overdraftLimit = MonetaryValue.read(sc);
        return new CheckingAccount(accountNumber, name, balance, overdraftLimit);
    }
}