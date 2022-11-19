import java.util.Scanner;

public class WifiDiagnosticTree
{
   public static void main (String [] args)
   {
      Scanner keyboard = new Scanner (System.in);
      
      String inputAnswer;
      
      System.out.println ("Is the wifi working properly? yes/no");
      inputAnswer = keyboard.nextLine();
      if (inputAnswer.equalsIgnoreCase("no")) {
      System.out.println ("Reboot the computer and try to connect.\n" +
      "Did that fix the problem? yes/no");
      inputAnswer = keyboard.nextLine();
      } if (inputAnswer.equalsIgnoreCase("no")) {
      System.out.println ("Reboot the router and try to connect.\n" +
      "Did that fix the problem? yes/no");
      inputAnswer = keyboard.nextLine();
      } if (inputAnswer.equalsIgnoreCase("no")) {
      System.out.println ("Make sure the cables between the router & " +
      "modem are plugged in firmly.\n" +
      "Did that fix the problem? yes/no");
      inputAnswer = keyboard.nextLine();
      } if (inputAnswer.equalsIgnoreCase("no")) {
      System.out.println ("Move the router to a new location " +
      "and try to connect.\n" + 
      "Did that fix the problem? yes/no");
      inputAnswer = keyboard.nextLine();
      } if (inputAnswer.equalsIgnoreCase("no")) {
      System.out.println ("Get a new router.");
      } else if (inputAnswer.equalsIgnoreCase("yes")) {
      System.out.println ("Good, if the wifi is not working properly, " +
      "run the diagnostic and answer the given questions again.");
      }
   }
}