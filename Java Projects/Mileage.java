import java.util.Scanner;

/*
   This program calculates gas mileage in miles per gallon.
*/

public class Mileage
{
   public static void main(String[] args)
   {
      //Add your declaration and code here.
      double miles; //Miles driven
      double gallons; //Gallons used
      double mph; //Miles per gallon
      
      Scanner keyboard = new Scanner(System.in);
   
   System.out.print("This program will calculate mileage.\n");
   //I am adding while(true) so I can enter the miles and gallons 3 times for task#5
   while(true) {
   System.out.print("How many miles driven?\n");
   miles = keyboard.nextDouble();
   System.out.print("How many gallons used?\n");
   gallons = keyboard.nextDouble();
   
   mph = miles / gallons;
   
   System.out.println("You drove " + mph + " miles per gallon\n");
   }
}