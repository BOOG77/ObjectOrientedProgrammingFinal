package finalJavaFiles;

import java.io.FileOutputStream;//Writes data to a file in bytes
import java.io.IOException;//Manage errors with input and output
import java.io.ObjectOutputStream;//Converts objects to a stream of bytes
import java.io.FileInputStream;//Reads data from a file as as a stream of bytes
import java.io.ObjectInputStream;//Converts a stream of bytes into objects
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // 3 types of arraylists
        ArrayList<Employee> employees = new ArrayList<Employee>();
        ArrayList<Student> students = new ArrayList<Student>();
        ArrayList<Instructor> instructors = new ArrayList<Instructor>();
        
        //Reads and assigns data to the 3 arrayLists from the file
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

        MenuManagement.displayMenu();

        System.out.println("User write an object to the employees arrayList");
     

        for (Employee i : employees) {
            i.displayDetails();
        }

        //Writes the 3 arrayLists to the file
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("employeeList.dat"));
            output.writeObject(employees);// writes the object e1 to the .dat file
            output.writeObject(students);
            output.writeObject(instructors);
            output.close();
        } catch (IOException ioe) {
            System.err.println("Error saving to file");
        }
    }

}
