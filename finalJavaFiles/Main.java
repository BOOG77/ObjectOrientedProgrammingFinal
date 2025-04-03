package finalJavaFiles;

import java.io.FileOutputStream;//Writes data to a file in bytes
import java.io.IOException;//Manage errors with input and output
import java.io.ObjectOutputStream;//Converts objects to a stream of bytes
import java.io.FileInputStream;//Reads data from a file as as a stream of bytes
import java.io.ObjectInputStream;//Converts a stream of bytes into objects
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    @SuppressWarnings("unchecked")

    public static void main(String[] args) {
        MenuManagement menu = new MenuManagement();// an object holding all the menus

        // 3 types of arraylists
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Instructor> instructors = new ArrayList<Instructor>();

        // Reads and assigns data to the 3 arrayLists from the file

        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("Database/employeeList.dat"));
            employees = (ArrayList<Employee>) input.readObject();
            students = (ArrayList<Student>) input.readObject();
            instructors = (ArrayList<Instructor>) input.readObject();
            input.close();
        } catch (IOException ioe) {
            System.err.println("Error opening file");
        } catch (ClassNotFoundException cnfe) {// if object read is not an employee object
            System.err.println("Object read is not Employee");
        }

        menu.mainMenu();

        // for (Employee i : employees) {
        // i.displayDetails();
        // }

        save(employees, students, instructors);
    }

    private static void save(ArrayList<Employee> employees, ArrayList<Student> students,
            ArrayList<Instructor> instructors) {
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
