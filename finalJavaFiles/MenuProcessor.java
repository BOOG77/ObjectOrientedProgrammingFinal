package finalJavaFiles;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuProcessor {
    static Scanner scanner = new Scanner(System.in);

    public ArrayList<Student> studentsstudentAdd(ArrayList<Student> students) {// takes in arraylist of students and
                                                                               // returns an updated array list of
                                                                               // students
        Student tempStudent;
        String studentName, studentMajor, studentAddress;
        int studentAge;
        // takes student data
        System.out.print("\nEnter Student's name: ");
        studentName = scanner.nextLine();
        System.out.print("Enter Student's major: ");
        studentMajor = scanner.nextLine();
        System.out.print("Enter Student's address: ");
        studentAddress = scanner.nextLine();
        System.out.print("Enter Student's age: ");
        studentAge = scanner.nextInt();
        scanner.nextLine();

        // makes the student object
        students.add(new Student(studentName, studentAge, studentAddress, studentMajor, studentAge));
        tempStudent = students.get(students.size() - 1);
        System.out.println("\nThe student " + tempStudent.getName() + " has sucessfully been added");

        // allows for new hashmap keys
        clearScreen();
        return students;

        // used to see last id when changing student data
    }

    public static final void clearScreen() {
        System.out.println("Press any key to continue..");
        scanner.nextLine();
        System.out.println("\u001B[2J");
    }
}
