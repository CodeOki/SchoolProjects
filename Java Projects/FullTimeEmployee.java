public class FullTimeEmployee extends Employee {
    private MonetaryValue payPerWeek;
    
    public FullTimeEmployee(String id, Name name, MonetaryValue payPerWeek) {
        super(id, name);
        this.payPerWeek = payPerWeek;
    }
    
    public double getWeeklySalary() {
        return payPerWeek.doubleValue();
    }
    
    public static FullTimeEmployee read(Scanner sc) {
        if (!sc.hasNext()) {
            return null;
        } else {
            return new FullTimeEmployee(sc.next(), Name.read(sc), MonetaryValue.read(sc));
        }
    }
}
