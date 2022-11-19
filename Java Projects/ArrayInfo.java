import java.util.*;
import java.io.*;
public class ArrayInfo
{
   public static void main(String[] args)
   {
      try {
          Scanner read = new Scanner(new FileReader("numbers.text"));
          while(read.hasNext())
          {
            int header = read.nextInt();
            System.out.print("The array: {");
            double[] arr = new double[header];
            int size = arr.length - 1;
            int mid = header / 2;
            int midPosition = mid;
            for(int i = 0; i < header; i++)
            {
               double array = read.nextDouble();
               arr[i] = array;
               if(i != header - 1) {
               System.out.print(array + ", ");
               } else {
               System.out.print(array);
               }
            }
               double large = 0;
               double small = 1000;
               int largePosition = 0;
               int smallPosition = 0;
               for(int i = 0; i < arr.length; i++)
               {
                  if(arr[i] > large) {
                  large = arr[i];
                  largePosition = i;
                  }
                  if(small > arr[i]) {
                  small = arr[i];
                  smallPosition = i;
                  }
               }
            if(header % 2 == 0) {
            mid--;
            midPosition--;
            }
            System.out.println("} contains " + header + " elements");
            System.out.println("The first element of the array is " + arr[0]);
            System.out.println("The last element of the array is " + arr[header - 1] +
            " and is at position " + size);
            System.out.println("The middle element of the array is " + arr[mid] +
            " and is at position " + midPosition);
            System.out.println("The largest element of the array is " + large +
            " and is at position " + largePosition);
            System.out.println("The smallest element of the array is " + small +
            " and is at position " + smallPosition);
          }              
      } catch(FileNotFoundException e) {
          e.printStackTrace();
      }
   }
}