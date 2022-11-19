import java.util.Scanner;

public class PayrollTest
{
   public static void assignEmployeeHoursAndPayrates (Payroll payrollObject)
   {
      Scanner keyboard = new Scanner (System.in);
      int employeeHours;
      double employeePayRate;
      
      for (int employeeIndex = 0; employeeIndex < payrollObject.getAllEmployeeIds().length; employeeIndex++)
      {
         System.out.println ("Please enter the hours for employee " + payrollObject.getAllEmployeeIds()[employeeIndex]);
         employeeHours = keyboard.nextInt();
         while (employeeHours < 0)
         {
            System.out.println ("Please enter POSITIVE hours for employee " + payrollObject.getAllEmployeeIds()[employeeIndex]);
            employeeHours = keyboard.nextInt();
         }
         payrollObject.setEmployeeHours(employeeHours, employeeIndex);
         System.out.println ("What's the payrate for employee " + payrollObject.getAllEmployeeIds()[employeeIndex]);
         employeePayRate = keyboard.nextDouble();
         while (employeePayRate < 6.00)
         {
            System.out.println ("What's the payrate for employee " + payrollObject.getAllEmployeeIds()[employeeIndex] + "($6 or above only)");
            employeePayRate = keyboard.nextDouble();
         }
         payrollObject.setEmployeePayRate(employeePayRate, employeeIndex);
      }
   }
   
   public static void displayEmployeeWages (Payroll payrollObject)
   {
      for (int employeeIndex = 0; employeeIndex < payrollObject.getAllEmployeeIds().length; employeeIndex++)
      {
         System.out.println ("The employee with id number " + payrollObject.getAllEmployeeIds()[employeeIndex] + " worked for " +
         payrollObject.getAllEmployeeHours()[employeeIndex] + " hours and earned " + 
         String.format ("$%, .2f", payrollObject.getAllEmployeeWages()[employeeIndex]));
      }
   }
   
   public static void main (String [] args)
   {
      Payroll employeeInfo = new Payroll();
      assignEmployeeHoursAndPayrates (employeeInfo);
      employeeInfo.calculateWages();
      displayEmployeeWages(employeeInfo);
   }
}