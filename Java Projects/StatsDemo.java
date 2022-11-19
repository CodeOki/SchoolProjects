import java.util.Scanner;
// TASK #3 Add the file I/O import statement here
import java.text.DecimalFormat;
import java.io.*;

/**
   This class reads numbers from a file, calculates the
   mean and standard deviation, and writes the results
   to a file.
*/

public class StatsDemo
{
   // TASK #3 Add the throws clause
   public static void main(String[] args) throws IOException
   {
      double sum = 0;      // The sum of the numbers
      int count = 0;       // The number of numbers added
      double mean = 0;     // The average of the numbers
      double stdDev = 0;   // The standard deviation
      String line;         // To hold a line from the file
      double difference;   // The value and mean difference
      
      DecimalFormat threeDecimals = new DecimalFormat("0.000");

      // Create an object of type Scanner
      Scanner keyboard = new Scanner (System.in);
      String filename;     // The user input file name

      // Prompt the user and read in the file name
      System.out.println("This program calculates " +
                         "statistics on a file " +
                         "containing a series of numbers");
      System.out.print("Enter the file name:  ");
      filename = keyboard.nextLine();

      // ADD LINES FOR TASK #4 HERE
      // Create a FileReader object passing it the filename
      FileReader File = new FileReader(filename);
      // Create a BufferedReader object passing FileReader
      // object
      BufferedReader input = new BufferedReader(File);
      // Perform a priming read to read the first line of
      // the file
      line = input.readLine();
      // Loop until you are at the end of the file
      // Convert the line to a double value and add the
      // value to sum
      while (line != null) {
         sum += Double.parseDouble(line);
      // Increment the counter
         count++;
      // Read a new line from the file
         line = input.readLine();
      }
      // Close the input file
         input.close();
         File.close();
      // Store the calculated mean
         mean = sum / count;
      
      // ADD LINES FOR TASK #5 HERE
      // Reconnect FileReader object passing it the
      // filename
      FileReader file2 = new FileReader(filename);
      // Reconnect BufferedReader object passing
      // FileReader object
      BufferedReader input2 = new BufferedReader(file2);
      // Reinitialize the sum of the numbers
      sum = 0;
      // Reinitialize the number of numbers added
      count = 0;
      // Perform a priming read to read the first line of
      // the file
      line = input2.readLine();
      // Loop until you are at the end of the file
      // Convert the line into a double value and
      // subtract the mean
      // Add the square of the difference to the sum
      // Increment the counter
      // Read a new line from the file
      while (line != null) {
         difference = Double.parseDouble(line) - mean;
         sum += Math.pow(difference, 2);
         count++;
         line = input2.readLine();
      }
      // Close the input file
      input2.close();
      // Store the calculated standard deviation
      stdDev = Math.sqrt((sum / count));

      // ADD LINES FOR TASK #3 HERE
      // Create a FileWriter object using "Results.txt"
      FileWriter fWriter = new FileWriter("Result.txt");
      // Create a PrintWriter object passing the
      // FileWriter object
      PrintWriter output = new PrintWriter(fWriter);
      // Print the results to the output file
      output.println("The mean is " + threeDecimals.format(mean) + " and the standard " +
      "deviation is " + threeDecimals.format(stdDev) + ".");
      // Close the output file
      output.close();
   }
}