package finalJavaFiles;

public class Student extends User {
    private String major, enrollmentStatus;
    private double GPA;
    static int idCounter = 1000;

    // Student ID
    public static String generateStudentID() {
        return "S" + (++idCounter);
    }

    // Constructor
    public Student(String name, int age, String email, String major) {
        super(name, age, email, generateStudentID(), "Student");
        this.major = major;
        this.GPA = 0.0;
        this.enrollmentStatus = "Active";
    }

    // getters
    public String getEnrollmentStatus() {
        return this.enrollmentStatus;
    }

    public String getMajor() {
        return this.major;
    }

    public double getGPA() {
        return this.GPA;
    }

    public int getIDCounter() {
        return this.idCounter;
    }

    // setters
    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void setIDCounter(int idCounter) {
        this.idCounter = idCounter;
    }

    public void displayDetails() {
        System.out.println("-----------------------------");
        System.out.println("Student Name: " + getName());
        System.out.println("Student ID: " + getID());
        System.out.println("Student Role: " + getRole());
        System.out.println("Student Major: " + getMajor());
        System.out.println("Student Enrollment Status: " + getEnrollmentStatus());
        System.out.println("Student GPA: " + getGPA());
        System.out.println("Student Email: " + getEmail());
        System.out.println("Student Age: " + getAge());
        System.out.println("-----------------------------");
    }

}