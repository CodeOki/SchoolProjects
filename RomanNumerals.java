import java.util.Scanner;

public class RomanNumerals
{
   public static void main (String [] args)
   {  
      Scanner keyboard = new Scanner (System.in);
      
      int enteredNumber;
      
         System.out.print ("Enter a number within the range of " +
         "1 through 10.\n");
         enteredNumber = keyboard.nextInt();
         
         if (enteredNumber < 1 || enteredNumber > 10)
         {
            System.out.println ("ERROR!");
         }
            else
            {
               if (enteredNumber == 1) {
               System.out.println ("The Roman numeral for " + enteredNumber + " is I.");
               } else if (enteredNumber == 2) {
               System.out.println ("The Roman numeral for " + enteredNumber + " is II.");
               } else if (enteredNumber == 3) {
               System.out.println ("The Roman numeral for " + enteredNumber + " is III.");
               } else if (enteredNumber == 4) {
               System.out.println ("The Roman numeral for " + enteredNumber + " is IV.");
               } else if (enteredNumber == 5) {
               System.out.println ("The Roman numeral for " + enteredNumber + " is V.");
               } else if (enteredNumber == 6) {
               System.out.println ("The Roman numeral for " + enteredNumber + " is VI.");
               } else if (enteredNumber == 7) {
               System.out.println ("The Roman numeral for " + enteredNumber + " is VII.");
               } else if (enteredNumber == 8) {
               System.out.println ("The Roman numeral for " + enteredNumber + " is VIII.");
               } else if (enteredNumber == 9) {
               System.out.println ("The Roman numeral for " + enteredNumber + " is IX.");
               } else if (enteredNumber == 10) {
               System.out.println ("The Roman numeral for " + enteredNumber + " is X.");
               }               
            }   
   }
}