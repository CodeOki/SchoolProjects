public class ChangeParam
{
 public static void main(String[] args)
 {
 int x = 1;
 double y = 3.4;
 System.out.println(x + " " + y);
 changeUs(x, y);
 System.out.println(x + " " + y);
 }
 public static void changeUs(int a, double b)
 {
 a = 0;
 b = 0.0;
 System.out.println(a + " " + b);
 }
}