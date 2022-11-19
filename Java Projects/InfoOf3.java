import java.util.*;
public class InfoOf3
{
   public static void main(String[] args)
   {
      Scanner keyboard = new Scanner(System.in);
      
      System.out.print("first number? ");
      int a = keyboard.nextInt();
      System.out.print("second number? ");
      int b = keyboard.nextInt();
      System.out.print("third number? ");
      int c = keyboard.nextInt();
      
      System.out.println("allAreEqual: " + allAreEqual(a, b, c));
      System.out.println("twoAreEqual: " + twoAreEqual(a, b, c));
      System.out.println("noneAreEqual: " + noneAreEqual(a, b, c));
      System.out.println("areAscending: " + areAscending(a, b, c));
      System.out.println("areDescending: " + areDescending(a, b, c));
      System.out.println("strictlyAscending: " + strictlyAscending(a, b, c));
      System.out.println("strictlyDescending: " + strictlyDescending(a, b, c));
   }
   
      public static boolean allAreEqual(int a, int b, int c)
      {
         return a == b && b == c;
      }
      
      public static boolean twoAreEqual(int a, int b, int c) // false if all three are equal
      {
         return a == b && a != c || b == c && b != a || c == a && c != b;
      }
      
      public static boolean noneAreEqual(int a, int b, int c)
      {
         return a != b && b != c && c != a;
      }
      
      public static boolean areAscending(int a, int b, int c)
      {
         return a <= b && b <= c;
      }
      
      public static boolean areDescending(int a, int b, int c)
      {
         return a >= b && b >= c;
      }
      
      public static boolean strictlyAscending(int a, int b, int c)
      {
         return a < b && b < c;
      }
      
      public static boolean strictlyDescending(int a, int b, int c)
      {
         return a > b && b > c;
      }
}