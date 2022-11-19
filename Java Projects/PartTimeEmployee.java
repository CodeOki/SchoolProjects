public class PartTimeEmployee extends Employee {
    private int hoursPerWeek;
    private MonetaryValue payPerHour;
    
    public PartTimeEmployee(String id, String name, int hoursPerWeek, int payPerHour) {
      super(id, name);
      this.hoursPerWeek = hoursPerWeek;
      this.payPerHour = payPerHour;
    }
    
    public PartTimeEmployee(PartTimeEmployee old) {
      super(old.id, old.name);
      this.hoursPerWeek = old.hoursPerWeek;
      this.payPerHour = oldpayPerHour;
    }
    
    public boolean equals(Object o) {
      if(o instanceof PartTimeEmployee) {
         PartTimeEmployee other = (PartTimeEmployee)o;
         return this.hoursPerWeek == old.hoursPerWeek, 
                this.payPerHour == old.payPerHour,
                super(old.id, old.name);
      } else {
         return false;
      }
    }
    
    public double getWeeklySalary() {
      return hoursPerWeek * payPerHour.doubleValue();
      
    }
    
    public static PartTimeEmployee read(Scanner sc) {
      if(sc.hasNext()) {
         return null;
      }
      PartTimeEmployee id = PartTimeEmployee.read(sc);
       else if(id.length() != id.length 
      
    
    // constructor with 4 parameters: 
    // id (String), name (Name), hoursPerWeek (int), payPerHour (MonetaryValue)
    
    // copy constructor
    
    // equals method 
    
    // getWeeklySalary
    // Hint: the doubleValue method of the MonetaryValue class might be helpful. 
    
    // read method
    // Read in String, Name, int, and MonetaryValue. 
    // If length of id isn't exactly 6, throw an InvalidIDException (custom exception class)
}
