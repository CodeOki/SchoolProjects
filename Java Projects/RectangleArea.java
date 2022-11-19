/*
3. Rectangle Area—Complete the Program
If you have downloaded the book’s source code from www.pearsonhighered.com/gaddis,
you will find a partially written program named AreaRectangle.java in this chapter’s
source code folder. Your job is to complete the program. When it is complete, the program
will ask the user to enter the width and length of a rectangle, and then display the rectangle’s area.
The program calls the following methods, which have not been written:
•	 getLength—This method should ask the user to enter the rectangle’s length, and then
return that value as a double.
•	 getWidth—This method should ask the user to enter the rectangle’s width, and then
return that value as a double.
•	 getArea—This method should accept the rectangle’s length and width as arguments, and
return the rectangle’s area. The area is calculated by multiplying the length by the width.
•	 displayData—This method should accept the rectangle’s length, width, and area as
arguments, and display them in an appropriate message on the screen.
*/

// NOTE: The units will be automatically in centimeters. You only need to enter the number!

import javax.swing.JOptionPane;

public class RectangleArea
{
   public static double getLength()
   {
      return Double.parseDouble (JOptionPane.showInputDialog ("Please enter the length of the rectangle."));
   }
   public static double getWidth()
   {
      return Double.parseDouble (JOptionPane.showInputDialog ("Please enter the width of the rectangle."));
   }
   public static double getArea (double lengthGiven, double widthGiven)
   {
      return (lengthGiven * widthGiven);
   }
   
   public static void displayArea (double lengthGiven, double widthGiven, double areaGiven)
   {
      JOptionPane.showMessageDialog (null, "A rectangle with length " + lengthGiven + "cm" + " and width " + widthGiven +
      "cm" + " has an area of " + areaGiven + "cm.");
   }
   
   public static void main (String [] args)
   {
      double userLength = getLength();
      double userWidth = getWidth();
      displayArea(userLength, userWidth, getArea(userLength, userWidth));
   }
}