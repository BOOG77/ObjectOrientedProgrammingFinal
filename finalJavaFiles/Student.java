package finalJavaFiles;

public class Student extends User {
    private String major;
    private double GPA;
    private Boolean alumni;

    private static int idCounter = 1000;

    public static String generateStudentID() {
        return "S" + (idCounter++);
    }

    // Constructor
    Student(String name, int age, String email) {
        super(name, age, email, generateStudentID(), "Student");

    }
}