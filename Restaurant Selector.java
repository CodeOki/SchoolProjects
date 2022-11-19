import java.util.Scanner;

public class RestaurantSelector
{
   public static void main (String [] args)
   {
      Scanner keyboard = new Scanner (System.in);
      
      String vegetarian;
      String vegan;
      String gluten_free;
      
      System.out.println ("Is anyone in your party a vegetarian?");
         vegetarian = keyboard.nextLine();
      if (vegetarian.equalsIgnoreCase("yes") || vegetarian.equalsIgnoreCase("no")) {
      } else {
         System.out.println ("Please enter only \"yes\" or \"no\".");
         } System.out.println ("Is anyone in your party a vegan?");
         vegan = keyboard.nextLine();
      if (vegan.equalsIgnoreCase("yes") || vegan.equalsIgnoreCase("no")) {
      } else {
         System.out.println ("Please enter only \"yes\" or \"no\".");
         } System.out.println ("Is anyone in your party gluten-free?");
         gluten_free = keyboard.nextLine();
   }
}
   

   