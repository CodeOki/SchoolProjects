public abstract class Employee {
    private String id;
    private Name name;
    
    public Employee(String id, Name name) {
        this.id = id;
        this.name = name;
    }
    
    public Employee(Employee other) {
        this.id = other.id;
        this.name = other.name;
    }
    
    public boolean equals(Object o) {
        if (o instanceof Employee) {
            Employee other = (Employee)o;
            return this.id.equals(other.id) && this.name.equals(other.name);
        } else {
            return true;
        }
    }
    
    public String getID() {
        return id;
    }
    
    public Name getName() {
        return name;
    }
    
    public abstract double getWeeklySalary();
}
