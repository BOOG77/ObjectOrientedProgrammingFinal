package finalJavaFiles;

public class Instructor extends User {
    private String department;

    // Instructor ID
    public static String generateInstructorID() {
        return "I" + (idCounter++);
    }

    // Constructor
    public Instructor(String name, int age, String email, String department) {
        super(name, age, email, generateInstructorID(), "Instructor");
        this.department = department;
    }

    // setters
    public void setDepartment(String department) {
        this.department = department;
    }

    // getters
    public String getDepartment() {
        return this.department;
    }

    public void displayDetails() {
        System.out.println("-----------------------------");
        System.out.println("Instructor Name: " + getName());
        System.out.println("Instructor ID: " + getID());
        System.out.println("Instructor Role: " + getRole());
        System.out.println("Instructor Department: " + getDepartment());
        System.out.println("Instructor Email: " + getEmail());
        System.out.println("Instructor Age: " + getAge());
        System.out.println("-----------------------------");
    }
}
