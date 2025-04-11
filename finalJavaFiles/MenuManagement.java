package finalJavaFiles;

import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class MenuManagement {
    static MenuProcessor processor = new MenuProcessor();
    static Scanner scanner = new Scanner(System.in);
    static int userInput;
    ArrayList<Student> students;
    ArrayList<Instructor> instructors;
    ArrayList<Employee> employees;

    public MenuManagement(ArrayList<Employee> employees, ArrayList<Student> students,
            ArrayList<Instructor> instructors) {
        this.students = students;
        this.instructors = instructors;
        this.employees = employees;

    }

    public void mainMenu() { // Made method for menu - Josh
        int notInt = 0;
        do {
            clearScreen();
            Scanner mainMenuScanner = new Scanner(System.in);
            System.out.println("\n╔═════════════════════════════════════════════╗");
            System.out.println("║              Management System              ║");
            System.out.println("╚═════════════════════════════════════════════╝");
            System.out.println(" ");
            System.out.println("====================================");
            System.out.println("Menu Options:");
            System.out.println("1. Manage Students");
            System.out.println("2. Manage Instructors");
            System.out.println("3. Manage Employees");
            System.out.println("4. Search by ID");
            System.out.println("5. Save and Exit");
            System.out.println("====================================\n");
            if (notInt == 1) {
                System.out.println("Enter a valid input (1-5)");
            }
            System.out.print("Enter your choice: ");

            try {
                userInput = mainMenuScanner.nextInt();
                mainMenuScanner.nextLine();
                notInt = 0;
            } catch (InputMismatchException e) {
                notInt = 1;
            }
        } while (notInt == 1);

        switch (userInput) {
            case 1:
                studentMenu();
                break;
            case 2:
                instructorMenu();
                break;
            case 3:
                employeeMenu();
                break;
            case 4:
                clearScreen();
                processor.fullIDSearch(students, instructors, employees);
                mainMenu();
                break;
            case 5:
                break;
            default:
                mainMenu();
                break;
        }
    }

    public void studentMenu() {
        int notInt = 0;
        do {
            clearScreen();
            Scanner studentMenuScanner = new Scanner(System.in);
            System.out.println("\n╔═══════════════════════════════════════════════╗");
            System.out.println("║               Student Management              ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
            System.out.println("====================================");
            System.out.println("1) Add a new Student.");
            System.out.println("2) Display details of all Student.");
            System.out.println("3) Search for a Student by ID.");
            System.out.println("4) Search for a Student by name.");
            System.out.println("5) Delete Student");
            System.out.println("6) Exit to Main Menu.");
            System.out.println("====================================\n");
            if (notInt == 1) {
                System.out.println("Enter a valid input (1-6)");
            }
            System.out.print("Enter your choice: ");

            try {
                userInput = studentMenuScanner.nextInt();
                studentMenuScanner.nextLine();
                notInt = 0;
            } catch (InputMismatchException e) {
                notInt = 1;
            }
        } while (notInt == 1);

        switch (userInput) {
            case 1:
                clearScreen();
                students = processor.studentAdd(students);
                save(employees, students, instructors);
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
                clearScreen();
                processor.studentDelete(students);
                save(employees, students, instructors);
                studentMenu();
                break;
            case 6:
                mainMenu();
                break;
            default:
                break;
        }

    }

    public void instructorMenu() {
        int notInt = 0;
        do {
            clearScreen();
            Scanner instructorMenuScanner = new Scanner(System.in);
            System.out.println("\n╔═══════════════════════════════════════════════╗");
            System.out.println("║             Instructor Management             ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
            System.out.println("====================================");
            System.out.println("1) Add a new Instructor.");
            System.out.println("2) Display details of all Instructor.");
            System.out.println("3) Search for an Instructor by ID.");
            System.out.println("4) Search for an Instructor by name.");
            System.out.println("5) Delete Instructor");
            System.out.println("6) Exit to Main Menu.");
            System.out.println("====================================\n");
            if (notInt == 1) {
                System.out.println("Enter a valid input (1-6)");
            }
            System.out.print("Enter your choice: ");

            try {
                userInput = instructorMenuScanner.nextInt();
                instructorMenuScanner.nextLine();
                notInt = 0;
            } catch (InputMismatchException e) {
                notInt = 1;
            }
        } while (notInt == 1);

        switch (userInput) {
            case 1:
                clearScreen();
                instructors = processor.instructorAdd(instructors);
                save(employees, students, instructors);
                instructorMenu();
                break;
            case 2:
                clearScreen();
                processor.instructorDetails(instructors);
                instructorMenu();
                break;
            case 3:
                clearScreen();
                processor.instructorSearchID(instructors);
                instructorMenu();
                break;
            case 4:
                clearScreen();
                processor.instructorSearchName(instructors);
                instructorMenu();
                break;
            case 5:
                clearScreen();
                processor.instructorDelete(instructors);
                save(employees, students, instructors);
                instructorMenu();
                break;
            case 6:
                clearScreen();
                mainMenu();
                break;
            default:
                break;
        }

    }

    public void employeeMenu() {
        int notInt = 0;
        do {
            clearScreen();
            Scanner employeeMenuScanner = new Scanner(System.in);
            System.out.println("\n╔═══════════════════════════════════════════════╗");
            System.out.println("║              Employee Management              ║");
            System.out.println("╚═══════════════════════════════════════════════╝");
            System.out.println("====================================");
            System.out.println("1) Add a new Employee.");
            System.out.println("2) Display details of all Employee.");
            System.out.println("3) Search for an Employee by ID.");
            System.out.println("4) Search for an Employee by name.");
            System.out.println("5) Delete Employee");
            System.out.println("6) Exit to Main Menu.");
            System.out.println("====================================\n");
            if (notInt == 1) {
                System.out.println("Enter a valid input (1-6)");
            }
            System.out.print("Enter your choice: ");

            try {
                userInput = employeeMenuScanner.nextInt();
                employeeMenuScanner.nextLine();
                notInt = 0;
            } catch (InputMismatchException e) {
                notInt = 1;
            }
        } while (notInt == 1);

        switch (userInput) {
            case 1:
                clearScreen();
                employees = processor.employeeAdd(employees);
                save(employees, students, instructors);
                employeeMenu();
                break;
            case 2:
                clearScreen();
                processor.employeeDetails(employees);
                employeeMenu();
                break;
            case 3:
                clearScreen();
                processor.employeeSearchID(employees);
                employeeMenu();
                break;
            case 4:
                clearScreen();
                processor.employeeSearchName(employees);
                employeeMenu();
                break;
            case 5:
                clearScreen();
                processor.employeeDelete(employees);
                save(employees, students, instructors);
                employeeMenu();
                break;
            case 6:
                clearScreen();
                mainMenu();
                break;
            default:
                break;
        }

    }

    static final void clearScreen() {
        System.out.println("\u001B[2J");
    }

    static void save(ArrayList<Employee> employees, ArrayList<Student> students, ArrayList<Instructor> instructors) {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Database/employeeList.dat"));
            // Writes the 3 arrayLists to the file
            output.writeObject(employees);
            output.writeObject(students);
            output.writeObject(instructors);
            output.close();
        } catch (IOException ioe) {
            System.err.println("Error saving to file");
        }
    }
}
