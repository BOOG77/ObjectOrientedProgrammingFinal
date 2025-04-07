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
            String idCounterFix;

            if (students.size() != 0) {// checks if array is empty
                System.out.println(Student.idCounter);

                idCounterFix = students.get(students.size() - 1).getID();// gets id ie. S1000
                idCounterFix = idCounterFix.substring(1, idCounterFix.length()); // removes letter ie. 1000
                Student.idCounter = Integer.parseInt(idCounterFix);// updates idCounter from file ie. 1001
                System.out.println(Student.idCounter);
            } else {
                Student.idCounter = 1000;
            }

            if (instructors.size() != 0) {
                idCounterFix = instructors.get(instructors.size() - 1).getID();
                idCounterFix = idCounterFix.substring(1, idCounterFix.length());
                Instructor.idCounter = Integer.parseInt(idCounterFix);
            } else {
                Instructor.idCounter = 1000;
            }
            if (employees.size() != 0) {
                idCounterFix = employees.get(employees.size() - 1).getID();
                idCounterFix = idCounterFix.substring(1, idCounterFix.length());
                Employee.idCounter = Integer.parseInt(idCounterFix);
            } else {
                Employee.idCounter = 1000;
            }
            input.close();
        } catch (IOException ioe) {
            System.err.println("Error opening file");
        } catch (ClassNotFoundException cnfe) {// if object read is not an employee object
            System.err.println("Object read is not Employee");
        }
        // System.out.println(Student.idCounter);
        // Student s1 = new Student("a", 1, "a", "a");
        // s1.displayDetails();
        MenuManagement menu = new MenuManagement(employees, students, instructors);// an object holding all the menus

        menu.mainMenu();
        save(employees, students, instructors);
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
