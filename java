// Constrained code starts here
import java.util.Scanner;
// Constrained code ends here



// Base Class: Person
class Person {
    int id;
    String name;

    // Constructor
    Person(int id, String name) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be greater than 0");
        }
        this.id = id;
        this.name = name;
    }
}

// Derived Class: Student (inherits from Person)
class Student extends Person {
    int marks;
    String status;

    // Constructor
    Student(int id, String name, int marks) {
        super(id, name); // Call Person constructor
        if (marks < 0 || marks > 100) {
            throw new IllegalArgumentException("Marks must be between 0 and 100");
        }
        this.marks = marks;
        // Status depends on marks
        this.status = (marks >= 40) ? "Pass" : "Fail";
    }
}

// Derived Class: Result (inherits from Student)
class Result extends Student {

    // Constructor
    Result(int id, String name, int marks) {
        super(id, name, marks); // Call Student constructor
    }

    // Method to display result
    void displayResult() {
        System.out.println("Result(" + id + ", " + name + ", " + marks + ", " + status + ")");
    }
}

// Main class to run the program
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        String name = sc.nextLine();
        int marks = sc.nextInt();

        Result r = new Result(id, name, marks);
        r.displayResult();

        sc.close();
    }
}
