/*
2. Payroll Class
Write a Payroll class that uses the following arrays as fields:

•	 employeeId. An array of seven integers to hold employee identification numbers. The
array should be initialized with the following numbers:

 5658845 4520125 7895122 8777541
 8451277 1302850 7580489
 
•	 hours. An array of seven integers to hold the number of hours worked by each
employee
•	 payRate. An array of seven doubles to hold each employee’s hourly pay rate
•	 wages. An array of seven doubles to hold each employee’s gross wages

The class should relate the data in each array through the subscripts. For example, the
number in element 0 of the hours array should be the number of hours worked by the
employee whose identification number is stored in element 0 of the employeeId array. That
same employee’s pay rate should be stored in element 0 of the payRate array.

In addition to the appropriate accessor and mutator methods, the class should have a
method that accepts an employee’s identification number as an argument and returns the
gross pay for that employee.

Demonstrate the class in a complete program that displays each employee number and asks
the user to enter that employee’s hours and pay rate. It should then display each employee’s
identification number and gross wages.
Input Validation: Do not accept negative values for hours or numbers less than 6.00 for
pay rate.
*/

public class Payroll
{
   private int [] employeeId = { 5658845, 4520125, 7895122, 8777541, 8451277, 1302850, 7580489 };
   private final int NUMBER_OF_EMPLOYEES = employeeId.length;
   private int [] hours;
   private double [] payRate;
   private double [] wages;
   
   public void calculateWages()
   {
      for (int employeeIndex = 0; employeeIndex < NUMBER_OF_EMPLOYEES; employeeIndex++)
      {
         wages[employeeIndex] = hours[employeeIndex] * payRate[employeeIndex];
      }
   }
   
   public double getEmployeeWagesById(int employeeIdGiven)
   {
      for (int employeeIndex = 0; employeeIndex < NUMBER_OF_EMPLOYEES; employeeIndex++)
      {
         if (employeeId[employeeIndex] == employeeIdGiven)
         {
            return wages [employeeIndex];
         }
      }
      return -1;
   }
   
   public int [] getAllEmployeeIds()
   {
      return employeeId;
   }
   
   public int [] getAllEmployeeHours()
   {
      return hours;
   }
   
   public double [] getAllEmployeePayRates()
   {
      return payRate;
   }
   
   public double [] getAllEmployeeWages()
   {
      return wages;
   }
   
   public void setEmployeeHours (int employeeHoursGiven, int employeeIndexGiven)
   {
      hours [employeeIndexGiven] = employeeHoursGiven;
   }
   
   public void setEmployeePayRate (double employeePayRateGiven, int employeeIndexGiven)
   {
      payRate [employeeIndexGiven] = employeePayRateGiven;
   }
   
   public Payroll()
   {
      hours = new int [ NUMBER_OF_EMPLOYEES ];
      payRate = new double [ NUMBER_OF_EMPLOYEES ];
      wages = new double [ NUMBER_OF_EMPLOYEES ];
   }
   
}