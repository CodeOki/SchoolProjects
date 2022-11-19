import java.io.*;
import java.util.*;

public class Triangle {
   public static void main(String[] args) {
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Please enter side 1 of the triangle: ");
      double n1 = keyboard.nextDouble();
      
      System.out.println("Please enter side 2 of the triangle: ");
      double n2 = keyboard.nextDouble();
      
      System.out.println("Please enter side 3 of the triangle: ");
      double n3 = keyboard.nextDouble();
      
      Triangle t1 = new Triangle(n1, n2, n3);
      
      System.out.println("side 1: " + n1);
      System.out.println("side 2: " + n2);
      System.out.println("side 3: " + n3);
      System.out.println("Triangle: " + t1.toString());
      System.out.println("area: " + t1.getArea());
      System.out.println("perimeter: " + t1.getPerimeter);
      System.out.println("is equilateral?  " + t1.isEquilateral());
      
      Triangle t2 = new Triangle (1.5,8.5,9.5);
      
      System.out.println("t1 equals t2? " + t1.equals(t2));
      
   }
}