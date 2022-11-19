/*
5. Letter Counter
Write a program that asks the user to enter a string, and then asks the user to enter a character. 
The program should count and display the number of times that the specified character appears in the string.
*/

import java.util.Scanner;

public class LetterCounter
{
   public static void main(String [] args)
   {
      Scanner keyboard = new Scanner (System.in);

      String userSentence;
      char userCharacter;
      int characterCount = 0;
            
      System.out.println ("Please enter a string.");
      userSentence = keyboard.nextLine();
      
      System.out.println ("Please enter a character to count.");
      userCharacter = keyboard.next().charAt(0);
      
      for (int index = 0; index < userSentence.length(); index++) {
         if (userSentence.charAt(index) == userCharacter) {
            characterCount = characterCount + 1;
         }
      }
      System.out.println ("\"" + userCharacter + "\" appears in \"" + userSentence + 
      "\" " + characterCount + " time(s).");
   }
}