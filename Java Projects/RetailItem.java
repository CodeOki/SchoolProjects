/*
4. RetailItem Class
Write a class named RetailItem that holds data about an item in a retail store. The class
should have the following fields:
•	 description. The description field references a String object that holds a brief
description of the item.
•	 unitsOnHand. The unitsOnHand field is an int variable that holds the number of units
currently in inventory.
•	 price. The price field is a double that holds the item’s retail price.
Write a constructor that accepts arguments for each field, appropriate mutator methods
that store values in these fields, and accessor methods that return the values in these fields.
Once you have written the class, write a separate program that creates three RetailItem
objects and stores the following data in them:

         Description    Units on Hand     Price
Item #1  Jacket            12             59.95
Item #2  Designer Jeans    40             34.95
Item #3  Shirt             20             24.95
*/

public class RetailItem
{
   private String description;
   private int unitsOnHand;
   private double price;
   
   public void setDescription(String userDescription)
   {
      description = userDescription;
   }
   
   public void setUnitsOnHand(int userUnitsOnHand)
   {
      unitsOnHand = userUnitsOnHand;
   }
   
   public void setPrice(double userPrice)
   {
      price = userPrice;
   }
   
   public String getDescription()
   {
      return description;
   }
   
   public int getUnitsOnHand()
   {
      return unitsOnHand;
   }
   
   public double getPrice()
   {
      return price;
   }
   
   public RetailItem(String descriptionGiven, int unitsOnHandGiven, double priceGiven)
   {
      description = descriptionGiven;
      unitsOnHand = unitsOnHandGiven;
      price = priceGiven;
   }
}