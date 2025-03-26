/***************************
 Name: Jeremy Paruch       *
 Student Number: W0222971  *
 Date: February 24, 2025   *
 Course: Intro to OOP      *
 Instructor: Nadia Gouda   *
 ***************************/
// Assistance provided by colleagues, their shoutouts have been appropriately given.
/*  the idea for press enter to continue is here
 https://stackoverflow.com/questions/19870467/how-do-i-get-press-any-key-to-continue-to-work-in-my-java-code
*/
// Importing array utility
import java.util.ArrayList;
// Importing scanner object
import java.util.Scanner;

public class Main {
    // new scanner
    public static Scanner scanner = new Scanner(System.in);
    // new array to hold student info from user
    public static ArrayList<Student> Students = new ArrayList<Student>();
    public static void main(String[] args) throws Exception {
        // basically default untill the loop starts
        int userExit = 0;
        System.out.println("\t*****************************************************************\n");
        System.out.println("\t\tWelcome to the Student Grades System V1.1 :D\n\n");
        System.out.println("\t*****************************************************************\n\n");
        System.out.println("\t\t\tPress Enter to Continue\n");
        System.out.println("\t*****************************************************************\n\n");
        // waiting for the user to press enter before continueing
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
        System.out.println("\t*****************************************************************\n");
        System.out.println("\t\tPlease choose from one of the following FOUR options!\n");
        System.out.println("\t*****************************************************************\n");


        do {
            // option 1 for adding student
            System.out.println("\nPress 1 to add new student");
            System.out.println("\n****************************************");

            // option 2 for displaying details
            System.out.println("\nPress 2 to display details of students");
            System.out.println("\n****************************************");

            // option 3 for displaying details
            System.out.println("\nPress 3 to Search for Student by ID");
            System.out.println("\n****************************************");

            // option 4 to quit
            System.out.println("\nPress 4 to exit");
            System.out.println("\n****************************************\n");

            // int chosen will be put in this variable
            int userInput = scanner.nextInt();
            // refreshes the scanner so it doesnt break
            scanner.nextLine();
            // Process User Input
            /*
             * Testing to make sure it works
             * Student test = new Student("IT", "Jeremy", 33, "123 This Street");
             */
            switch (userInput) {
                // add new student
                case 1:
                    System.out.println("\t*****************************************************************\n");
                    System.out.print("\t\t\tRegistering NEW Student! \n\n");
                    System.out.println("\t*****************************************************************\n");
                    // Input for name of Major
                    System.out.print("\nPlease Enter the Major: \n\n");
                    String studentMajor = scanner.nextLine();
                    // Input for GPA
                    System.out.print("\nPlease Enter their GPA: \n\n");
                    double studentGPA = scanner.nextDouble();
                    scanner.nextLine();
                    // Input for name of Name
                    System.out.print("\nPlease Enter the name: \n\n");
                    String studentName = scanner.nextLine();
                    // Input for name of Age
                    System.out.print("\nPlease Enter the age: \n\n");
                    int studentAge = scanner.nextInt();
                    // HAVE to add this in because theres some kind issue where after a next int is added, the next line doesnt get registered
                    scanner.nextLine();
                    // Input for name of Address
                    System.out.print("\nPlease Enter the Address: \n\n");
                    String studentAddress = scanner.nextLine();
                    // Same as line 15, causes scanner to skip
                   
                    // storing data in the array list
                    Students.add(new Student(studentMajor,studentGPA, studentName, studentAge, studentAddress));
                    System.out.println("\n*****************************************************************\n");
                    System.out.println("\t\tRegistration Successful!\n\n");
                    System.out.println("*****************************************************************\n\n");
                    System.out.println("\nPress Enter to Continue\n");
                    try
                    {
                        System.in.read();
                    }
                    catch(Exception e)
                    {}

                    break;
                // display student details
                case 2:
                    // for student i in students
                    // deleting for later

                    for (Student i : Students) {
                        i.displayDetails();
                    }
                    break;
                // Search By ID
                case 3:
                    System.out.println("\n*****************************************************************\n");
                    System.out.print("\n\nPlease enter the ID of the student: \n\n");
                    System.out.println("*****************************************************************\n\n");

                    String idLookup = scanner.nextLine();

                    for (Student i : Students) {
                        // Need this to compare strings ALWAYS use .equals when dealing with strings
                        if (i.getStudentID().equals(idLookup)) {
                            // Successfully finds the unique ID in the array list
                            System.out.println("\n*****************************************************************\n");
                            System.out.println("\n\nID Located\n\n");
                            System.out.println("*****************************************************************\n\n");
                            i.displayDetails();
                            break;
                        } else {
                            // if the current student in the arraylist and they are the last one
                            // .size is a number and starts at 1, array list starts at 0. putting in -1
                            // starts it at 0
                            // shout out to judah for helping me
                            if (i == Students.get(Students.size() - 1)) {
                                System.out.println("\n*****************************************************************\n");
                                System.out.println("\n\t\tID not found please try again\n\n");
                                System.out.println("*****************************************************************\n\n");
                                System.out.println("\nPress Enter to Continue\n\n");
                                try
                                {
                                    System.in.read();
                                }
                                catch(Exception e)
                                {}
                            }

                        }
                    }
                    break;
                // Exit
                case 4:
                    // this is the kill switch
                    userExit = 4;
                    System.out.println("\t*****************************************************************\n");
                    System.out.println("\t\tThank you for using the  Student Grades System V1.1 :D\n\n");
                    System.out.println("\t*****************************************************************\n\n");
                    break;
                    default:
                    System.out.println("Please enter a number between 1-4");   
            }
            // This keeps working until user hits 4 to end it
        } while (userExit != 4);
        // As Doug Says be a good programmer and close your scanner when you're done!
        scanner.close();
        /*
         * Testing
         * Person p1 = new Person("Jeremy",33,"123 this street");
         * 
         * p1.displayDetails();
         * 
         * Student s1 = new Student("IT","Jeremy",33,"123 this street");
         * s1.displayDetails();
         */

    }
}
