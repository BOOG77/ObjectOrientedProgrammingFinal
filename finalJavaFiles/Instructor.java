package finalJavaFiles;

public class Instructor extends User {
    // Instructor ID
    private static int idCounter = 1000;

    public static String generateInstructorID() {
        return "I" + (idCounter++);
    }

    // Constructor
    Instructor(String name, int age, String email) {
        super(name, age, email, "1234", "Instructor");
    }
}
