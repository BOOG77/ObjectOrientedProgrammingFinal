import java.util.ArrayList; // Import the ArrayList class

public class StudentManager {

    private static ArrayList<Student> studentList = new ArrayList<>(); // Create an array list to store student objects

    public static ArrayList<Student> getStudentList() { // Getter method for the studentList array list
        return studentList; // Return the studentList array list
    }

    public static void setStudentList(ArrayList<Student> studentList) { // Setter method for the studentList array list
        StudentManager.studentList = studentList; // Set the studentList array list
    }

    public static void displayMenu() { // Static method to display the menu options
        System.out.println(" "); // Prints space
        System.out.println("╔════════════════════════════════════╗");
        System.out.println("║      Student Management System     ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.println(" ");
        System.out.println("===================================="); // Display a separator
        System.out.println("Menu Options:"); // Display the menu options as a title
        System.out.println("1. Add Student"); // Displaying the menu options
        System.out.println("2. Remove Student"); // Displaying the menu options
        System.out.println("3. Update Student Details"); // Displaying menu options
        System.out.println("4. Display Details of All Students"); // Displaying the menu options
        System.out.println("5. Search for a Student by ID"); // Displaying the menu options
        System.out.println("6. Exit"); // Displaying the menu options
        System.out.println("===================================="); // Display a separator
        System.out.println(" ");
        System.out.println("Enter your choice:"); // Prompt the user to enter their choice
    }
    
}