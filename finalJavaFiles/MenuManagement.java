package finalJavaFiles;

import java.util.ArrayList;

public class MenuManagement {
   // private static ArrayList<Employee> employees = new ArrayList<Employee>();
   // private static ArrayList<Student> students = new ArrayList<Student>();
   // private static ArrayList<Instructor> instructors = new ArrayList<Instructor>();
    /*
    public static ArrayList<Employee> getEmployees() {
        return employees;
    }
    public static ArrayList<Student> getStudents() {
        return students;
    }
    public static ArrayList<Instructor> getInstructors() {
        return instructors;
    }
    */
    public static void displayMenu() {
        System.out.println(" "); // Prints space
        System.out.println("╔═════════════════════════════════════════════╗");
        System.out.println("║      Student/Employee Management System     ║");
        System.out.println("╚═════════════════════════════════════════════╝");
        System.out.println(" ");
        System.out.println("====================================");
        System.out.println("Menu Options:");
        System.out.println("1. Add Student or Employee");
        System.out.println("2. Display Details of Students or Employees");
        System.out.println("3. Search for a Student or Employee by ID");
        System.out.println("4. Save and Exit");
        System.out.println("====================================");
        System.out.println(" ");
        System.out.println("Enter your choice:");
    }
}
