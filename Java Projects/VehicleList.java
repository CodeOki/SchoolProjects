import java.io.File;
import java.util.Scanner;

interface PrintableList {
    void printElements();
}

class Name {
    private String first, last;
    
    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Name) {
            Name other = (Name)o;
            return this.first.equals(other.first) && this.last.equals(other.last);
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return first + " " + last;
    }
    
    public static Name read(Scanner sc) {
        if (!sc.hasNext()) {
            return null;
        } else {
            return new Name(sc.next(), sc.next());
        }
    }
}

class Person {
    private Name name;
    private int age;
    
    public Person(Name name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public boolean equals(Object o) {
        if (o instanceof Person) {
            Person other = (Person)o;
            return this.name.equals(other.name) && this.age == other.age;
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return name + " (age " + age + ")";
    }
    
    public static Person read(Scanner sc) {
        if (!sc.hasNext()) {
            return null;
        } else {
            return new Person(Name.read(sc), sc.nextInt());
        }
    }
}

abstract class Vehicle {
    private Person owner;
    private String color;
    
    public Vehicle(Person owner, String color) {
        this.owner = owner;
        this.color = color;
    }
    
    public Vehicle(Vehicle old) {
        this.owner = old.owner;
        this.color = old.color;
    }
    
    @Override 
    public boolean equals(Object o) {
        if (o instanceof Vehicle) {
            Vehicle other = (Vehicle)o;
            return this.owner.equals(other.owner) && this.color.equals(other.color);
        } else {
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "Owner: " + owner + "\n" +
               "Color: " + color;
    }
    
    public abstract void makeSound();
}

class Truck extends Vehicle {
    public Truck(Person owner, String color) {
        super(owner, color);
    }

    @Override
    public void makeSound() {
        System.out.println("vroooom, honk!");
    }

    @Override
    public String toString() {
        return "Truck information: \n" + super.toString();
    }

    public static Truck read(Scanner sc) {
        if (!sc.hasNext()) {
            return null;
        } else {
            return new Truck(Person.read(sc), sc.next());
        }
    }
}

class Car extends Vehicle {
    private int numDoors;

    public Car(Person owner, String color, int numDoors) {
         super(owner, color);
         this.numDoors = numDoors;
    }

    public Car(Car old) {
         super(old);
         this.numDoors = old.numDoors;
    }

    @Override
    public boolean equals(Object obj) {
      if(obj instanceof Car) {
         Car other = (Car)obj;
         return super.equals(other) && this.numDoors == other.numDoors;
      } else {
         return false;
      }
    }

    @Override
    public String toString() {
        return "Car information: \n" + super.toString();
    }

    @Override
    public void makeSound() {
        System.out.println("vroom, toot!");
    }

    public int getNumDoors() {
        return numDoors;
    }

    public static Car read(Scanner sc) {
      if(sc.hasNext()) {
         int accountNumber = sc.nextInt();
         Name name = Name.read(sc);
         MonetaryValue balanceValue = MonetaryValue.read(sc);
         MonetaryValue overdraftValue = MonetaryValue.read(sc);
         return new Car(owner, color, numDoors);
      }
      return null;
    }
}


   public VehicleList(String s) throws Exception {
        this.numVehicles = 0;
        Vehicle[] vehicles = new Vehicle[CAPACITY];
        Scanner sc = new Scanner(s);
          while(sc.hasNextLine())
          {
            char type = sc.next().charAt(0);
            if(type == 'C') {
              vehicles[numVehicles] = Car.read(sc);
            } else {
              vehicles[numVehicles] = Truck.read(sc);
            }
            numVehicles++;
      }
   }
 
}