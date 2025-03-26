
public class Student extends Person {
    private String major;
    private double GPA;
    private String studentID = generateStudentID();

    // Creates student id starting a 1001
    private static int idCounter = 1000;

    public static String generateStudentID() {
        return "S" + (idCounter++);
    }

    // Constructor
    public Student(String major, String name, String address, int age) {
        super(name, age, address);
        this.GPA = 0.0;
        this.major = major;
    }

    // setters
    public void setMajor(String major) {
        this.major = major;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    // getters
    public String getMajor() {
        return major;
    }

    public double getGPA() {
        return GPA;
    }

    public String getStudentID() {
        return studentID;
    }

    // Display Details
    // to call name, age, and address I had to reuse code to call the getter methods
    @Override
    public void displayDetails() {
        System.out.println("--------------------------");
        System.out.println("Student name: " + getName());
        System.out.println("Student ID: " + studentID);
        System.out.println("Student major: " + major);
        System.out.println("Student GPA: " + GPA);
        System.out.println("Student age: " + getAge());
        System.out.println("Student address: " + getAddress());
        System.out.println("--------------------------");
    }

}
