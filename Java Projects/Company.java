public class Company {
    HashMap<String, Employee> employees;
    
    public Company(String filename) {
        employees = new HashMap<>();
        Scanner sc = new Scanner(new File(filename));
        
        // read in employees from the file. Each line begins with either 
        // F (for FullTimeEmployees) or P (for PartTime Employees), followed
        // by the insformation for an employee. Assume things are in the 
        // correct order. 
        // Put each employee in the map. 
        
        while (sc.hasNext()) {
            Employee e;
            char type = sc.next().charAt(0);
            if (type == 'F') {
                // write a line
                
            } else {
                // write a line 
                
            }
            // write a line 
            
        }
    }
    
    // return the weekly salary for the employee with the given id. 
    public double weeklySalaryForEmployee(String id) {
        
    }
}
