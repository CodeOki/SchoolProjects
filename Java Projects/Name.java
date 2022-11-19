import java.util.*;
public class Name {
   private String first;
   private String last;

    public Name() {
        first = "";
        last = "";
    }

    public Name(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public Name(Name old) {
        first = old.first;
        last = old.last;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Name) {
          Name other = (Name)obj;
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
        while(sc.hasNext()) {
        String s = sc.next();
        if(s == null) {
         return null;
        } else {
         return new Name(s, sc.next());
        }
        }
        return null;
    }
}