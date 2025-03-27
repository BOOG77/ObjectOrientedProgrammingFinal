/*
 * Author: Dawson Brown
 * LMD: March 19 2025
 * School: NSCC
 * Course: Object Oriented Programming
 * Assignment: Student Management System
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // scanner
    public static Scanner scanner = new Scanner(System.in);

    // arraylist of student objects
    public static ArrayList<Student> studentList = new ArrayList<Student>();

    public static void main(String[] args){
        // making students created variable so display details of all students will display only 2 students if the 3rd isn't created
        int studentsCreated = 2;

        // default students created
        Student student = new Student("IT", 3.8, "Dawson Brown", 23, "22 eCampus Rd");
        Student student2 = new Student("IT", 3.8, "Jacob Brown", 29, "28 eCampus Rd");

        // adding them to the array
        studentList.add(student);
        studentList.add(student2);

        // menu selection variable for later use
        int menuSelection;

        // do startMenu makes it so the menu re-opens after the user does a menu function
        do{
            menuSelection = startMenu();
            // Start menu prints out the menu, and scans the user input then returns that value
            // menuSelection value is returned, and that determines what case to activate (menu functionality)
            switch(menuSelection){
                case 1: // add a new student
                    System.out.println("1- Add a new student.");

                    // user inputs students name
                    System.out.println("Enter student's name: ");
                    String stuName = scanner.nextLine();

                    // user inputs students age
                    System.out.println("Enter student's age: ");
                    String placeholderAge = scanner.nextLine();
                    int stuAge = Integer.parseInt(placeholderAge);


                    // user inputs students address
                    System.out.println("Enter student's address: ");
                    String stuAddress = scanner.nextLine();

                    // user inputs students gpa
                    System.out.println("Enter student's GPA: ");
                    String placeholderGPA = (scanner.nextLine());
                    double stuGPA = Double.parseDouble(placeholderGPA);

                    // user inputs students major
                    System.out.println("Enter student's major: ");
                    String stuMajor = scanner.nextLine();

                    // add to array
                    studentList.add(new Student(stuMajor, stuGPA, stuName, stuAge, stuAddress));

                    // ID is created in the constructor

                    // students created goes to 3 for display details case functionality
                    studentsCreated++;
                    break;

                case 2: // display details of all students
                    // https://www.quora.com/How-can-I-access-methods-of-objects-that-are-in-ArrayList-in-Java
                    // using the ArrayList to iterate through all students created
                    for(int i = 0; i < studentList.size(); i++){
                        Student placeholder = studentList.get(i);
                        System.out.println(placeholder.displayDetails());
                    }
                    break;

                case 3: // search student by id

                    // built using this reference
                    // https://www.quora.com/How-can-I-access-methods-of-objects-that-are-in-ArrayList-in-Java

                    System.out.println("3- Search for a student by ID.");

                    // get the user id input
                    System.out.print("Enter ID: ");
                    String idSelection = scanner.nextLine();

                    // lookup loop
                    for (int iterator = 0; iterator < studentList.size(); iterator++){
                        // iterate through objects, getting id for all objects.
                        Student objectNum = studentList.get(iterator);
                        String objectId = objectNum.getStudentId();

                        // if id inside the object matches user input id, display details for them
                        if(objectId.equals(idSelection)){
                            System.out.println(objectNum.displayDetails());
                        }
                    }
                    break;

                case 4: // exit case
                    // selection is set to 6 to stop the do-while keeping the menu alive
                    menuSelection = 6;
                    break;


                default:
                    System.out.println("default");
            }
        }
        while(menuSelection < 5);
        scanner.close();
        }


    public static int startMenu(){
        // variable to store user's menu selection
        int menuSelection;

                System.out.println("Select your option:");
                System.out.println("====================");
                System.out.println("1- Add a new student.");
                System.out.println("2- Display details of all students.");
                System.out.println("3- Search for a student by ID.");
                System.out.println("4- Exit.");
                String menuSelectionPlaceholder = scanner.nextLine();
                menuSelection = Integer.parseInt(menuSelectionPlaceholder);
        return menuSelection;
    }
}

