import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
   public static void main(String[] args) {
      double[] second = new double[12];
      double[] arr = new double[12];
      readData(12,arr);

   System.out.println("here is the original array");

   printArray(12,arr);

      double avg = findAverage(12,arr);
   System.out.println("The average value is " + avg);

   System.out.println("here is the new array");

      second = howFarAway(12,avg,arr,second);

   printArray(12,second);

      avg = findAverage(12,second);
   System.out.println("The average value is " + avg);

   }

   public static void readData(int n,double[] numbers) {
      try {
         File myObj = new File("numbers.txt");
         Scanner myReader = new Scanner(myObj);

      for(int i=0; i<n; i++) {
         numbers[i] = myReader.nextDouble();
      }
      
      } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
   }


   public static void printArray(int q, double[] numb) {
       for(int i=0; i<q; i++) {
           System.out.print(numb[i]);
           System.out.print(" ");

           if((i + 1) % q == 0) {
               System.out.println("");
           }
       }
   }

   public static double findAverage(int k ,double[] p) {
       double s=0;
       for(int i=0; i<k; i++)
         s = s+p[i];
         
         return s/k;
   }

   public static double[] howFarAway(int m,double avg,double[] arr,double[] narr) {
       for(int i=0; i<arr.length; i++)
       narr[i]=arr[i]-avg;

       return narr;
   }

}