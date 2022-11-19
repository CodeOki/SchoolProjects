import java.util.*;
public class SavingsAccount extends BankAccount {
    private static double annualInterest = 0.0;

    public SavingsAccount() {
        super();
    }

    public SavingsAccount(int accountNumber, Name name, MonetaryValue balance) {
        super(accountNumber, name, balance);
    }

    public SavingsAccount(SavingsAccount old) {
        super(old);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof SavingsAccount) {
          SavingsAccount other = (SavingsAccount)obj;
          return super.equals(other) && this.annualInterest == other.annualInterest;
        } else {
          return false;
        }
    }

    @Override
    public String toString() {
        return "Saving account: " + "\n" +
               super.toString() + "\n" + "Annual interest Rate: " + annualInterest + "%";
    }

    public static void setAnnualInterestRate(double annualInterestRate) {
        annualInterest = annualInterestRate;
    }
    
    public MonetaryValue getMonthlyInterest() {
        double monthlyInterestRate = annualInterest / 12;
        double monthlyInterest = super.balance.doubleValue() * (monthlyInterestRate / 100);
        return new MonetaryValue(monthlyInterest);
    }

    public static SavingsAccount read(Scanner sc) throws NegativeBalanceException {
        if(!sc.hasNext()) {
          return null;
        }
        int accountNumber = sc.nextInt();
        Name name = Name.read(sc);
        MonetaryValue balance = MonetaryValue.read(sc);
        if(balance.isNegative()) {
         throw new NegativeBalanceException(balance);
        }
        return new SavingsAccount(accountNumber, name, balance);
    }
    
    @Override
    public MonetaryValue availableAmount() {
      return balance;
    }
}