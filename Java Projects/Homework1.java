import java.util.*;
import java.io.File;

public class Main {

public static void main(String[] args) {
double[] second = new double[10];
double[] arr = new double[10];

arr = readData(10,arr);

System.out.println("here is the original array");

printArray(3,arr);

double avg = findAverage(5,arr);
System.out.println("The avearage value is" + avg);


System.out.println("here is the new array");

second = howFarAway(9,avg,arr,second);

printArray(3,narr);

avg = findAverage(5,narr);
System.out.println("The avearage value is" + avg);


}



public static double[] readData(int n,double[] numbers)

   {

       File file = new File("number.txt");
Scanner fileScanner = new Scanner(file);

       for(int i=0; i<n; i++)
           numbers[i]=fileScanner.nextDouble();

   return numbers;

   }


public static void printArray(int q, double[] numb)

   {

       for(int i=0;i<numb.length;i++)

       {

           System.out.print(numb[i]);
           System.out.print(" ");

           if((i+1)%q==0)
               System.out.println("");

       }

   }


public static double findAverage(int k ,double[] p)

   {

   double s=0;

   for(int i=0;i<k;i++)

   s = s+p[i];

   return s/k;

   }

public static double[] howFarAway(int m,double avg,double[] arr,double[] narr)

   {

       for(int i=0;i<arr.length;i++)
   narr[i]=arr[i]-avg;

       return narr;

   }

}