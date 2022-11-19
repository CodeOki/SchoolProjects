import java.io.File;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) throws Exception {
        // Make sure the user provided exactly one command line argument. This argument
        // will tell us the name of the file from which we need to read the intial entries.
        if (args.length != 1) {
            System.out.println("usage: java Phonebook filename");
            System.exit(1);
        }

        final int CAPACITY = 100;
        String[] firstNames = new String[CAPACITY];
        String[] lastNames = new String[CAPACITY];
        String[] numbers = new String[CAPACITY];
        File file = new File(args[0]);
        Scanner inputFile = new Scanner(file);
        // Or we can combine the two above lines into one:
        // Scanner inputFile = new Scanner(new File(args[0]));
        Scanner keyboard = new Scanner(System.in);

        int numEntries = readEntries(inputFile, firstNames, lastNames, numbers);

        printMenu();
        String choice = keyboard.next().toUpperCase();

        while (!choice.equals("Q")) {
            if (choice.equals("L")) {
                String first, last, number;

                System.out.print("First name? ");
                first = keyboard.next();
                System.out.print("Last name? ");
                last = keyboard.next();

                number = getNumber(firstNames, lastNames, numbers, first, last, numEntries);

                if (number.equals("")) {
                    System.out.print("Number is not in database. Try again.");
                } else {
                    System.out.print(first + " " + last + "'s number is: " + number);
                }
            } else if (choice.equals("C")) {
                String first, last, number;

                System.out.print("First name? ");
                first = keyboard.next();
                System.out.print("Last name? ");
                last = keyboard.next();
                System.out.println("New phone number? ");
                number = keyboard.next();

                boolean isSuccess = setNumber(first, last, number, firstNames, lastNames, numbers, numEntries);

                if (isSuccess) {
                    System.out.println("Successfully updated number");
                } else {
                    System.out.println("This name doesn't exist in the database. Try again.");
                }
            } else if (choice.equals("A")) {
                String first, last, number;

                System.out.print("First name? ");
                first = keyboard.next();
                System.out.print("Last name? ");
                last = keyboard.next();
                System.out.print("Phone number? ");
                number = keyboard.next();

                boolean isSuccess = addEntry(first, last, number, firstNames, lastNames, numbers, numEntries, CAPACITY);

                if (isSuccess) {
                    System.out.println("Entry sucessfully added to database");
                    numEntries++;
                } else {
                    if (indexOf(first, last, firstNames, lastNames, numEntries) >= 0) {
                        System.out.println("Unsuccessful due to name already existing in database");
                    } else {
                        System.out.println("Unsuccessful due to inadequte space in database");
                    }
                }
            // // OPTIONAL
            // } else if (choice.equals("D")) {
            //     String first, last;

            //     System.out.print("First name? ");
            //     first = keyboard.next();
            //     System.out.print("Last name? ");
            //     last = keyboard.next();

            //     boolean isSuccess = removeEntry(first, last, firstNames, lastNames, numbers, numEntries);

            //     if (isSuccess) {
            //         System.out.println("Entry removed from database");
            //         numEntries--;
            //     } else {
            //         System.out.println("Entry not found in database so couldn't be removed");
            //     }
            } else if (choice.equals("P")) {
                printEntries(firstNames, lastNames, numbers, numEntries);
            } else {
                System.out.println("Invalid choice; try again.");
            }

            printMenu();
            choice = keyboard.next().toUpperCase();
        }

        keyboard.close();
    }

    public static int readEntries(Scanner sc, String[] firstNames, String[] lastNames, String[] numbers) {
        int count = 0;

        while (sc.hasNext()) {
            firstNames[count] = sc.next();
            lastNames[count] = sc.next();
            numbers[count] = sc.next();
            count++;
        }

        return count;
    }

    public static void printMenu() {
        System.out.println("\n");
        System.out.println("To lookup a number: L");
        System.out.println("To change a number: C");
        System.out.println("To add an entry: A");
        // // OPTIONAL
        // System.out.println("To delete an entry: D");
        System.out.println("To print all entries: P");
        System.out.println("To quit: Q");
        System.out.println("Enter a character (uppercase or lowercase):");
    }

    public static int indexOf(String first, String last, String[] firstNames, String[] lastNames, 
            int numEntries) {
        for (int i = 0; i < numEntries; i++) {
            if (firstNames[i].equals(first) && lastNames[i].equals(last)) {
                return i;
            }
        }
        return -1;
    }

    public static String getNumber(String[] firstNames, String[] lastNames, String[] numbers, String first, String last,
            int numEntries) {
        int index = indexOf(first, last, firstNames, lastNames, numEntries);
        if (index == -1) {
            return "";
        } else {
            return numbers[index];
        }
    }

    public static boolean setNumber(String first, String last, String newNumber, String[] firstNames,
            String[] lastNames, String[] numbers, int numEntries) {
        int entryLocation = indexOf(first, last, firstNames, lastNames, numEntries);

        if (entryLocation == -1) {
            return false;
        } else {
            numbers[entryLocation] = newNumber;
            return true;
        }
    }

    public static boolean addEntry(String first, String last, String number, String[] firstNames, 
            String[] lastNames, String[] numbers, int numEntries, int capacity) {
        // Determine if we've reached the capacity of the arrays. If so, we cannot add a
        // new entry.
        if (numEntries == capacity) {
            return false;
        }

        // Determine if this name is alrady found in the database by calling the indexOf
        // method, which returns a number >= 0 if it finds the name. If the name is 
        // already in the database, we cannot add this new entry, since we are assuming 
        // that no two people have exactly the same name. Of course, this isn't an 
        // assumption we'd make in the real world, but we aren't writing this program 
        // for the real world.
        if (indexOf(first, last, firstNames, lastNames, numEntries) >= 0) {
            return false;
        }

        firstNames[numEntries] = first;
        lastNames[numEntries] = last;
        numbers[numEntries] = number;

        return true;
    }

    public static void printEntries(String[] firstNames, String[] lastNames, String[] numbers, 
            int numEntries) {
        System.out.println("First name \t Last name \t Phone number");
        for (int i = 0; i < numEntries; i++) {
            System.out.println(firstNames[i] + "\t\t" + lastNames[i] + "\t\t" + numbers[i]);
        }
    }

    // // OPTIONAL
    // public static boolean removeEntry(String first, String last, String[] firstNames, 
    //         String[] lastNames, String[] numbers, int numEntries) {
    //     int entryLocation = indexOf(first, last, firstNames, lastNames, numEntries);

    //     if (entryLocation == -1) {
    //         return false;
    //     }

    //     for (int i = entryLocation; i < numEntries - 1; i++) {
    //         firstNames[i] = firstNames[i + 1];
    //         lastNames[i] = lastNames[i + 1];
    //         numbers[i] = numbers[i + 1];
    //     }

    //     return true;
    // }
}