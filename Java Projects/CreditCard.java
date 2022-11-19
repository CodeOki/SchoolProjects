// For task #3 - Creating a Credit Card
public class CreditCard
{
   private Money balance;
   private Money creditLimit;
   private Person owner;
   
   public CreditCard (Person newCardholder, Money limit)
   {
      balance = new Money(0);
      owner = newCardholder;
      creditLimit = new Money (limit);
   }
   
   public Money getBalance()
   {
      return new Money(balance);
   }
   
   public Money getCreditLimit()
   {
      return new Money (creditLimit);
   }
   
   public String getPersonals()
   {
      return owner.toString();
   }
   
   public void charge (Money amount)
   {
      Money tempVar = new Money(balance.add(amount));
      if (tempVar.compareTo(creditLimit) > 0)
      {
         System.out.println ("Exceeds credit limit");
      }
      else
      {
         balance = tempVar;
         System.out.println ("Charge: " + amount);
      }
   }
   
   public void payment (Money amount)
   {
      Money temp = new Money (balance.subtract(amount));
   }
}