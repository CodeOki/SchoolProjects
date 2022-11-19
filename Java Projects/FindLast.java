import java.util.*;
import java.io.*;
public class FindLast
{
   public static void main(String[] args)
   {
      try {
          Scanner keyboard = new Scanner(System.in);
          Scanner read = new Scanner(new FileReader("numbers.text"));
          System.out.print("Enter a number: ");
          while(keyboard.hasNextInt())
          {
          int userNumber = 0;
          userNumber = keyboard.nextInt();
          
          int currPosition = 1;
          int latestPosition = 1;
          boolean numExists = false;
            while(read.hasNextInt())
            {
               int number = read.nextInt();
               if(number == userNumber) 
               {
                numExists = true;
                latestPosition = currPosition;
               }
               currPosition++;
            }
            if(numExists) 
            {
            System.out.print(userNumber + " last appears in the file at position ");
            System.out.println(latestPosition);
            }
            else System.out.println(userNumber + " does not appear in the file");
            System.out.print("Enter a number: ");
            read.close();
            read = new Scanner(new File("numbers.text"));
          }
       } catch (FileNotFoundException e) {
            e.printStackTrace();
       }
   }
}