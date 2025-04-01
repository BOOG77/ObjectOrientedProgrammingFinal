package finalJavaFiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main {

    public static void main(String[] args) {
        Employee e1 = new Employee("Judah", 18, "judah@csanyi.ca", "Janitor");
        Student s1 = new Student("Bob", 20, "asdf@email.com", "IT", 4.0);
        Instructor i1 = new Instructor("Billy", 46, "Billy@gmil.com", "Math");
        e1.displayDetails();
        s1.displayDetails();
        i1.displayDetails();

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

        // write the object to the file
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("employeeList.dat"));// opens the
                                                                                                         // file
            output.writeObject(e1);// writes the object e1 to the .dat file
            output.close();
        } catch (IOException ioe) {
            System.err.println("Error saving to file");
        }

        // read the file back in
        Employee e2 = null;// container to hold the data
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("employeeList.dat"));
            e2 = (Employee) input.readObject();
            input.close();
        } catch (IOException ioe) {
            System.err.println("Error opening file");
        } catch (ClassNotFoundException cnfe) {// if object read is not an employee object
            System.err.println("Object read is not Employee");
        }
        e2.displayDetails();

    }

}
