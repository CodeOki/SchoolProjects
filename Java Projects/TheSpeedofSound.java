import java.util.Scanner;

public class TheSpeedofSound
{
   public static void main (String [] args)
   {
      Scanner keyboard = new Scanner (System.in);
      
      String inputMedium;
      double distance = 0;
      double time = 0;
      
      System.out.println ("Enter the medium that the sound " +
      "wave will travel in.\n" + "Enter only \"air\", " + 
      "\"water\", or \"steel\".");
      inputMedium = keyboard.nextLine();
      
      System.out.println ("Enter the distance that the sound wave will travel in.\n" +
      "NOTE: Enter only the number, units will be in feet.");
      distance = keyboard.nextDouble();
      
      if (inputMedium.equalsIgnoreCase("air") || inputMedium.equalsIgnoreCase("water") || inputMedium.equalsIgnoreCase("steel")) {
         if (inputMedium.equalsIgnoreCase ("air")) {
            time = distance / 1100;
         } else if (inputMedium.equalsIgnoreCase ("water")) {
            time = distance / 4900;
         } else if (inputMedium.equalsIgnoreCase ("steel")) {
            time = distance / 16400;
         }
      }      
         System.out.println ("It will take " + time + " seconds to travel " + distance + " feet in " +
         inputMedium + ".");        
   }
}