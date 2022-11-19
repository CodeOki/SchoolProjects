public class Transaction {
   private String transactionType;
   private MonetaryValue amount;
   private MonetaryValue balance;
   private boolean wasSuccessful;
   
   public Transaction(String transactionType, MonetaryValue amount, MonetaryValue balance, boolean wasSuccessul) {
      this.transactionType = transactionType;
      this.amount = amount;
      this.balance = balance;
      this.wasSuccessful = wasSuccessful;
   }
   
   public boolean equals(Object o) {
      if(o instanceof Transaction) {
         Transaction other = (Transaction)o;
         return this.transactionType.equals(other.transactionType) &&
                this.amount.equals(other.amount) &&
                this.balance.equals(other.balance) &&
                this.wasSuccessful == other.wasSuccessful;
      } else {
         return false;
      }
   }
   
   @Override
   public String toString() {
      return "Transaction: type: " + transactionType +
             ", amount: " + amount +
             ", new balance: " + balance +
             ", was successful: " + wasSuccessful;
   }          
}    