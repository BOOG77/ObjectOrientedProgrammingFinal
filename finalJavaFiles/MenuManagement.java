package finalJavaFiles;

import java.util.Scanner;
import java.util.ArrayList;

public class MenuManagement {
    static MenuProcessor processor = new MenuProcessor();
    static Scanner scanner = new Scanner(System.in);
    static int userInput;
    ArrayList<Employee> employees;
    ArrayList<Student> students;
    ArrayList<Instructor> instructors;

    public MenuManagement(ArrayList<Employee> employees, ArrayList<Student> students,
            ArrayList<Instructor> instructors) {
        this.employees = employees;
        this.students = students;
        this.instructors = instructors;
    }

    public void mainMenu() { // Made method for menu - Josh
        clearScreen();
        System.out.println("\n╔═════════════════════════════════════════════╗");
        System.out.println("║              Management System              ║");
        System.out.println("╚═════════════════════════════════════════════╝");
        System.out.println(" ");
        System.out.println("====================================");
        System.out.println("Menu Options:");
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Employees");
        System.out.println("3. Manage Instructors");
        System.out.println("4. Search By ID");
        System.out.println("5. Save and Exit");
        System.out.println("====================================");
        System.out.print("\nEnter your choice: ");

        userInput = scanner.nextInt();
        scanner.nextLine();

        switch (userInput) {
            case 1:
                studentMenu();
                break;
            case 2:
                employeeMenu();
                break;
            case 3:
                instructorMenu();
                break;
            case 4:
                // fullIDSearch();
                break;
            case 5:
                break;
            default:
                System.out.println("Error - enter a valid input");
                break;
        }
    }

    public void studentMenu() {
        clearScreen();
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║               Student Management              ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println("====================================");
        System.out.println("1) Add a new Student.");
        System.out.println("2) Display details of all Student.");
        System.out.println("3) Search for a Student by ID.");
        System.out.println("4) Search for a Student by name.");
        System.out.println("5) Exit to Main Menu.");
        System.out.println("====================================");
        System.out.print("\nEnter your choice: ");

        userInput = scanner.nextInt();
        scanner.nextLine();

        switch (userInput) {
            case 1:
                clearScreen();
                students = processor.studentAdd(students);
                studentMenu();
                break;
            case 2:
                clearScreen();
                processor.studentDetails(students);
                studentMenu();
                break;
            case 3:
                clearScreen();
                processor.studentSearchID(students);
                studentMenu();
                break;
            case 4:
                clearScreen();
                processor.studentSearchName(students);
                studentMenu();
                break;
            case 5:
                mainMenu();
                break;

            default:
                break;
        }

    }

    public void instructorMenu() {
        clearScreen();
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║             Instructor Management             ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println("====================================");
        System.out.println("1) Add a new Instructor.");
        System.out.println("2) Display details of all Instructor.");
        System.out.println("3) Search for an Instructor by ID.");
        System.out.println("4) Search for an Instructor by name.");
        System.out.println("5) Exit to Main Menu.");
        System.out.println("====================================");
        System.out.print("\nEnter your choice: ");
        userInput = scanner.nextInt();
        scanner.nextLine();

        switch (userInput) {
            case 1:
                // processor.instructorAdd();
                break;
            case 2:
                // processor.instructorDetails();
                break;
            case 3:
                // processor.instructorSearchID();
                break;
            case 4:
                // processor.instructorSearchName();
                break;
            case 5:
                mainMenu();
                break;

            default:
                break;
        }

    }

    public void employeeMenu() {
        clearScreen();
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║              Employee Management              ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println("====================================");
        System.out.println("1) Add a new Employee.");
        System.out.println("2) Display details of all Employee.");
        System.out.println("3) Search for an Employee by ID.");
        System.out.println("4) Search for an Employee by name.");
        System.out.println("5) Exit to Main Menu.");
        System.out.println("====================================");
        System.out.print("\nEnter your choice: ");
        userInput = scanner.nextInt();
        scanner.nextLine();

        switch (userInput) {
            case 1:
                // processor.employeeAdd();
                break;
            case 2:
                // processor.employeeDetails();
                break;
            case 3:
                // processor.employeeSearchID();
                break;
            case 4:
                // processor.employeeSearchName();
                break;
            case 5:
                mainMenu();
                break;

            default:
                break;
        }

    }

    static final void clearScreen() {
        // System.out.println("Press any key to continue..");
        // scanner.nextLine();
        System.out.println("\u001B[2J");
    }
}
