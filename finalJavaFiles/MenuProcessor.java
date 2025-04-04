package finalJavaFiles;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuProcessor {
    static Scanner scanner = new Scanner(System.in);

    static Student tempStudent;
    static Instructor tempInstructor;
    static Employee tempEmployee;
    static String stringInput;
    static int intInput;
    static double doubleInput;

    // takes in arraylist of students and returns an updated array list of students
    // 1.1
    public ArrayList<Student> studentAdd(ArrayList<Student> students) {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║                 Enroll Student                ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println("====================================");
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
        System.out.println("\nThe student " + studentName + " has sucessfully been added");
        pause();
        return students;
    }

    // 1.2
    public void studentDetails(ArrayList<Student> students) {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║                 Student Details               ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println("====================================");
        for (Student student : students) {
            student.displayDetails();
        }
        pause();
    }

    // 1.3
    public void studentSearchID(ArrayList<Student> students) {
        String iDSearch;

        System.out.print("Enter student ID: ");
        iDSearch = scanner.nextLine();

        int numStudentsFound = 0;

        boolean studentFound = false;

        for (Student student : students) {
            tempStudent = student;// keeps looping even after it is found the student id but saves the one that is
                                  // correct incase there are multiple with the same id
            if (student.getID().equals(iDSearch)) {
                System.out.println("\nSuccess");
                student.displayDetails();
                studentFound = true;
                numStudentsFound++;
            } else {
                System.out.println("Searching...");
                // if last position in arraylist and student not found
                if (students.get(students.size() - 1) == student && !studentFound) {
                    System.out.println("\nFailure - Student not found");
                }
            }
        }
        System.out.println("\nSearch has concluded, " + numStudentsFound + " student's found\n");

        if (studentFound) {
            System.out.print("Do you want to change the student's data [Y/n]? ");
            stringInput = scanner.nextLine();

            if (stringInput.toLowerCase().contains("y")) {
                studentAttributesMenu(tempStudent);
            }
        }
        pause();
    }

    // 1.3.1
    static void studentAttributesMenu(Student student) {
        System.out.println("\u001B[2J");
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║             Student Attribute Menu            ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        student.displayDetails();
        System.out.println("====================================");
        System.out.println("1. Name\t\t2) Role");
        System.out.println("3. Major   \t4) Enrollment Status");
        System.out.println("5. GPA \t\t6) Email");
        System.out.println("4. Age \t\t8) Exit");
        System.out.println("====================================");
        System.out.print("\nEnter your choice: ");
        intInput = scanner.nextInt();
        scanner.nextLine();

        switch (intInput) {
            case 1:
                System.out.print("Enter a new Name: ");
                stringInput = scanner.nextLine();
                student.setName(stringInput);
                studentAttributesMenu(student);
                break;
            case 2:
                System.out.print("Enter a new Role: ");
                stringInput = scanner.nextLine();
                student.setRole(stringInput);
                studentAttributesMenu(student);
                break;
            case 3:
                System.out.print("Enter a new Major: ");
                stringInput = scanner.nextLine();
                student.setMajor(stringInput);
                studentAttributesMenu(student);
                break;
            case 4:
                System.out.print("Enter a new Enrollment Status: ");
                stringInput = scanner.nextLine();
                student.setEnrollmentStatus(stringInput);
                studentAttributesMenu(student);
                break;
            case 5:
                System.out.print("Enter a new GPA: ");
                doubleInput = scanner.nextDouble();
                student.setGPA(doubleInput);
                studentAttributesMenu(student);
                break;

            case 6:
                System.out.print("Enter a new Email: ");
                stringInput = scanner.nextLine();
                student.setEmail(stringInput);
                studentAttributesMenu(student);
                break;
            case 7:
                System.out.print("Enter a new Age: ");
                intInput = scanner.nextInt();
                student.setAge(intInput);
                studentAttributesMenu(student);
                break;
            case 8:
                break;
            default:
                System.out.println("Error - enter a number between 1 and 9");
        }
    }

    // 1.4
    public void studentSearchName(ArrayList<Student> students) {
        int numStudentsFound = 0;
        boolean studentFound = false;

        System.out.print("Enter a name: ");
        stringInput = scanner.nextLine();

        for (Student student : students) {
            tempStudent = student;
            if (tempStudent.getName().equals(stringInput)) {
                System.out.println("\nSuccess");
                student.displayDetails();
                numStudentsFound++;
                studentFound = true;
            } else {
                System.out.println("Searching...");
                if (students.get(students.size() - 1) == student && !studentFound) {
                    System.out.println("\nFailure - Student not found");
                }
            }
        }
        System.out.println("\nSearch has concluded, " + numStudentsFound + " student's found");
        pause();
    }

    // 1.5
    public void studentDelete(ArrayList<Student> students) {
        System.out.print("Enter student ID: ");
        stringInput = scanner.nextLine();

        int numStudentsFound = 0;

        boolean studentFound = false;

        for (Student student : students) {
            if (student.getID().equals(stringInput)) {
                tempStudent = student;
                System.out.println("\nSuccess");
                student.displayDetails();
                studentFound = true;
                numStudentsFound++;
            } else {
                System.out.println("Searching...");
                // if last position in arraylist and student not found
                if (students.get(students.size() - 1) == student && !studentFound) {
                    System.out.println("\nFailure - Student not found");
                }
            }
        }
        System.out.println("\nSearch has concluded, " + numStudentsFound + " student's found\n");

        if (studentFound) {
            System.out.print("Are you sure you want to permently delete the student's data [Y/n]? ");
            stringInput = scanner.nextLine();

            if (stringInput.toLowerCase().contains("y")) {
                students.remove(tempStudent);
                System.out.println("The student " + tempStudent.getName() + " has been deleted");
            }
        }
        pause();
    }

    static final void pause() {
        System.out.println("Press any key to continue..");
        scanner.nextLine();
    }
}
