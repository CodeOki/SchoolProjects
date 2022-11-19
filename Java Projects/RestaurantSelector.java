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
      } System.out.println ("Is anyone in your party a vegan?");
         vegan = keyboard.nextLine();
      if (vegan.equalsIgnoreCase("yes") || vegan.equalsIgnoreCase("no")) {
      } System.out.println ("Is anyone in your party gluten-free?");
         gluten_free = keyboard.nextLine();
      if (gluten_free.equalsIgnoreCase("yes") || gluten_free.equalsIgnoreCase("no")) {
      } 
         System.out.println ("Here are your restaurant choices:");
         
      if (vegetarian.equals ("yes") && vegan.equals ("yes") && gluten_free.equals ("yes")) {
      System.out.println ("\tCorner Cafe\n" + "\tThe Chef's Kitchen");
      } else if (vegetarian.equals ("yes") && vegan.equals ("no") && gluten_free.equals ("no")) {
      System.out.println ("\tMain Street Pizza Company\n" + "\tCorner Cafe\n" +
      "\tMama's Fine Italian\n" + "\tThe Chef's Kitchen");
      } else if (vegetarian.equals ("yes") && vegan.equals ("yes") && gluten_free.equals ("no")) {
      System.out.println ("\tCorner Cafe\n" + "\tThe Chef's Kitchen");
      } else if (vegetarian.equals ("yes") && vegan.equals ("no") && gluten_free.equals ("yes")) {
      System.out.println ("\tMain Street Pizza Company\n" + "\tCorner Cafe\n" + "\tThe Chef's Kitchen");
      } else if (vegetarian.equals ("no") && vegan.equals ("no") && gluten_free.equals ("no")) {
      System.out.println ("\tJoe's Gourmet Burgers\n" + "\tMain Street Pizza Company\n" +
      "\tCorner Cafe\n" + "\tMama's Fine Italian\n" + "\tThe Chef's Kitchen");
      } else if (vegetarian.equals ("no") && vegan.equals ("yes") && gluten_free.equals ("yes")) {
      System.out.println ("\tCorner Cafe\n" + "\tThe Chef's Kitchen");
      } else if (vegetarian.equals ("no") && vegan.equals ("no") && gluten_free.equals ("yes")) {
      System.out.println ("\tMain Street Pizza Company\n" + "\tCorner Cafe\n" + "\tThe Chef's Kitchen");
      } else if (vegetarian.equals ("no") && vegan.equals ("yes") && gluten_free.equals ("no")) {
      System.out.println ("\tCorner Cafe\n" + "\tThe Chef's Kitchen");
      }
   }
}