public class DuplicateAccountNumberException extends Exception {
   public DuplicateAccountNumberException() {
      super("duplicate account number");
   }
   
   public DuplicateAccountNumberException(int accountNumber) {
      super("duplicate account number " + accountNumber);
   }
}