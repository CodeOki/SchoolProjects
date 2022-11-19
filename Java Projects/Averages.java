import java.util.*;
import java.io.*;
public class Averages
{
   public static void main(String[] args)
   {
      try {
          Scanner read = new Scanner(new FileReader("numbers.text"));
          int set = 0;
          while(read.hasNext())
          {
            int size = read.nextInt();
            System.out.print("The average of the " + size + " integers ");
            int sum = 0;
            for(int i = 0; i < size; i++)
            {
               int num = read.nextInt();
               System.out.print(num + " ");
               sum+=num;
            }
            double average = (double)sum/size;
            System.out.println("is " + average);
            set++;
          }
          System.out.println(set + " sets of numbers processed");
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
   }
}         