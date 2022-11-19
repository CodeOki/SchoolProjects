import java.util.Scanner; // Scanner class
import java.io.*; // FileReader and IOException class

class TestData { // Driver class named TestData
// readData method takes two double arrays and returns integer
public static int readData (double arr1[],double arr2[])throws IOException
{
   int k=0;
   // Opens file and creates input stream using Scanner object
   Scanner read = new Scanner(new FileReader("input.txt"));
   
   while(read.hasNext()) // Reads until file has data tokens
   { 
      double arrOne = read.nextDouble(); // Reads double value
      double arrTwo = read.nextDouble(); // Reads double value
      // Stores into arrays
      arr1[k] = arrOne;
      arr2[k] = arrTwo;
      k += 1; // Increments k value
   }
   return k; // Returns k
}
   // changeArray method
public static void changeArray (double alpha[],double beta[],int k)
{
// Tranverses through arrays and evaluates
   for(int i=0;i<k;i++)
   {
      beta[i] = beta[i]*alpha[i];
   }
}
// sortArray method applies bubble sort on array
public static void sortArray(double arrToOrder[],int k)
{
   for(int i=0;i<k-1;i++)
   {
      for(int j=0;j<k-i-1;j++)
      {
         if(arrToOrder[j]>arrToOrder[j+1])
         {
            double temp = arrToOrder[j];
            arrToOrder[j] = arrToOrder[j+1];
            arrToOrder[j+1] = temp;
         }
      }
   }
}
// Main method
public static void main(String[] args)
{
// Creates two double arrays of size.
   double arr1[] = new double[100];
   double arr2[] = new double[100];
  
   try // try block as readData method may arise FileNotFoundException
   { 
      int k = readData(arr1,arr2); // Calls readData method
      changeArray(arr1,arr2,k); // Calls changeArray method
      sortArray(arr1,k); // Calls sortArray method for arr1
      sortArray(arr2,k); // Calls sortArray method for arr2
      // Prints the arr values to console
      System.out.println (" arr1 arr2");
      
      for(int i=0;i<k;i++)
      {
         System.out.printf("%5.2f %5.2f\n",arr1[i],arr2[i]);
      }
   }
      catch(Exception e) // If exception arises then   
      {          
         System.out.println("Exception arised: input file not found"); // Prints Message
      }
   }
}