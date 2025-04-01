package finalJavaFiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // 3 types of arraylists
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Instructor> instructors = new ArrayList<Instructor>();
        // reads
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("employeeList.dat"));
            employees = (ArrayList<Employee>) input.readObject();
            students = (ArrayList<Student>) input.readObject();
            instructors = (ArrayList<Instructor>) input.readObject();
            input.close();
        } catch (IOException ioe) {
            System.err.println("Error opening file");
        } catch (ClassNotFoundException cnfe) {// if object read is not an employee object
            System.err.println("Object read is not Employee");
        }

        // test objects
        Employee e1 = new Employee("Judah", 18, "judah@csanyi.ca", "Janitor");
        Employee e2 = new Employee("Josh", 22, "Josh@email.com", "It consultant");

        System.out.println(" "); // Prints space
        System.out.println("Student & Employee Management System");
        System.out.println(" ");
        System.out.println("====================================");
        System.out.println("Menu Options:");
        System.out.println("1. Add Student or Employee");
        System.out.println("2. Display Details of Students or Employees");
        System.out.println("3. Search for a Student or Employee by ID");
        System.out.println("4. Exit");
        System.out.println("====================================");
        System.out.println(" ");
        System.out.println("Enter your choice:");

        System.out.println("User write an object to the employees arrayList");
        employees.add(e2);

        for (Employee i : employees) {
            i.displayDetails();
        }

        // writes
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("employeeList.dat"));// opens the
            // file
            output.writeObject(employees);// writes the object e1 to the .dat file
            output.writeObject(students);
            output.writeObject(instructors);

            output.close();
        } catch (IOException ioe) {
            System.err.println("Error saving to file");
        }

    }

}
