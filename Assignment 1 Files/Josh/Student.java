
public class Student extends Person { // Student class extending Person class

    private static int idCounter = 1000; // Static variable to generate student IDs
    private final String studentId; // Final variable for student ID
    private String major; // Instance variable for major
    private double gpa; // Instance variable for GPA
    
    public String getStudentId() { // Getter method for student ID
        return studentId; // Return the student ID
    }

    public String getMajor() { // Getter method for major
        return major; // Return the major
    }

    public double getGpa() { // Getter method for GPA
        return gpa; // Return the GPA
    }

    public void setMajor(String major) { // Setter method for major
        this.major = major; // Set the major
    }

    public void setGpa(double gpa) { // Setter method for GPA
        this.gpa = gpa; // Set the GPA
    }

    public Student(String name, int age, String address, String major, double gpa) { // Constructor with parameters
        super(name, age, address); // Call the superclass constructor
        this.studentId = "S" + (++idCounter); // Generate the student ID
        this.major = major; // Initialize the major
        this.gpa = gpa; // Initialize the GPA
    }

    @Override // Override the displayDetails() method from the Person class
    public void displayDetails() { // Method to display the details of the student
        super.displayDetails(); // Call the superclass method to display the person details
        System.out.println("Student ID: " + studentId); // Display the student ID
        System.out.println("Major: " + major); // Display the major
        System.out.println("GPA: " + gpa); // Display the GPA
    }

}