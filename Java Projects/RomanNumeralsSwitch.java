import java.util.Scanner;

public class RomanNumeralsSwitch
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
            switch (enteredNumber) {
               case 1:
                  System.out.println ("The Roman numeral for " + enteredNumber + " is I.");
                  break;
               case 2:
                  System.out.println ("The Roman numeral for " + enteredNumber + " is II.");
                  break;
               case 3:
                  System.out.println ("The Roman numeral for " + enteredNumber + " is III.");
                  break;
               case 4:
                  System.out.println ("The Roman numeral for " + enteredNumber + " is IV.");
                  break;
               case 5:
                  System.out.println ("The Roman numeral for " + enteredNumber + " is V.");
                  break;
               case 6:
                  System.out.println ("The Roman numeral for " + enteredNumber + " is VI.");
                  break;
               case 7:
                  System.out.println ("The Roman numeral for " + enteredNumber + " is VII.");
                  break;
               case 8:
                  System.out.println ("The Roman numeral for " + enteredNumber + " is VIII.");
                  break;
               case 9:
                  System.out.println ("The Roman numeral for " + enteredNumber + " is IX.");
                  break;
               case 10:
                  System.out.println ("The Roman numeral for " + enteredNumber + " is X.");
                  break;
               }
   }
}