public class InsufficientFundsException extends Exception {
   public InsufficientFundsException() {
      super("insufficient funds");
   }
   
   public InsufficientFundsException(MonetaryValue amountToWithdraw, MonetaryValue available) {
      super("insufficient funds: tried to withdraw " + amountToWithdraw + "and amount available is " + available);
   }
}