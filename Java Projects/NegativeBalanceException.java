public class NegativeBalanceException extends Exception {
   public NegativeBalanceException() {
      super("negative balance");
   }
   
   public NegativeBalanceException(MonetaryValue balance) {
      super("negative balance " + balance.toString());
   }
}