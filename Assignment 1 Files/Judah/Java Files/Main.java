import java.util.Scanner;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Student> students = new HashMap<>();// Store objects of students linked with a key instead of a

        int studentNumberOfInstances = 1;// used to create hashmap keys ex. S1, S2, S3...
        int userInput;

        System.out.println("\u001B[2J");// clears the screen

        do {// loops the menu
            // ****User Menu****
            System.out.println("------------------------------");
            System.out.println("1) Add a new student.");
            System.out.println("2) Display details of all students.");
            System.out.println("3) Search for a student by ID.");
            System.out.println("4) Search for a student by name.");
            System.out.println("5) Exit the program.");
            System.out.println("------------------------------\n");

            userInput = scanner.nextInt();// takes input of what user wants
            scanner.nextLine();

            students = menu(userInput, studentNumberOfInstances, students, scanner);// calles the menu method to process
                                                                                    // user input
            if (userInput == 1) {// user input 1 is the only time the number of students will change
                studentNumberOfInstances++;// add 1 to the number os student instances, hashmaps will get unique keys
            }

        } while (userInput != 5);// loop ends when user hits 5
        scanner.close();
    }

    // processes the user input
    public static HashMap<String, Student> menu(int userInput, int studentNumberOfInstances,
            HashMap<String, Student> students, Scanner scanner) {
        String studentName;
        String studentMajor;
        int studentAge;
        String studentAddress;
        Student temp;
        String iDSearch;
        String nameSearch;
        String studentHashMapID;
        double studentGPA;

        // processes user input
        switch (userInput) {
            case 1:
                // creates hashmap key
                studentHashMapID = "S" + (studentNumberOfInstances);

                // takes student data
                System.out.println(" \n");
                System.out.print("Enter Student's name: ");
                studentName = scanner.nextLine();
                System.out.print("Enter Student's major: ");
                studentMajor = scanner.nextLine();
                System.out.print("Enter Student's address: ");
                studentAddress = scanner.nextLine();
                System.out.print("Enter Student's age: ");
                studentAge = scanner.nextInt();
                scanner.nextLine();

                // makes the student object
                students.put(studentHashMapID, new Student(studentMajor, studentName, studentAddress, studentAge));
                temp = students.get(studentHashMapID);
                System.out.println("\nThe student " + temp.getName() + " has sucessfully been added");

                // allows for new hashmap keys
                clearScreen(scanner);
                // used to see last id when changing student data
                break;
            case 2:
                for (String i : students.keySet()) {
                    temp = students.get(i);
                    temp.displayDetails();
                }
                clearScreen(scanner);
                break;
            case 3:
                System.out.print("Enter student ID: ");

                iDSearch = scanner.nextLine();
                int numStudentsFound = 0;
                String keyOfStudentFound = null;
                int hashmapPosition = students.size();
                boolean studentFound = false;

                for (String i : students.keySet()) {
                    temp = students.get(i);
                    if (temp.getStudentID().equals(iDSearch)) {
                        System.out.println("\nSuccess");
                        temp.displayDetails();
                        studentFound = true;
                        keyOfStudentFound = i;
                        numStudentsFound++;
                        hashmapPosition--;
                    } else {
                        System.out.println("Searching...");
                        // if last position in hashmap and student not found
                        if (hashmapPosition == 1 && !studentFound) {
                            System.out.println("Failure");
                            System.out.println("Student not found");
                        }
                        hashmapPosition--;
                    }
                }
                System.out.println("\nSearch has concluded, " + numStudentsFound + " student's found\n");

                if (studentFound) {
                    System.out.print("Do you want to change the student's data [Y/n]? ");
                    String userInput2 = scanner.nextLine();

                    if (userInput2.toLowerCase().contains("y")) {
                        // create a temp copy of the student the want to change
                        temp = students.get(keyOfStudentFound);
                        int editStudentDetails = 1;

                        do {
                            System.out.println("\u001B[2J");

                            temp.displayDetails();
                            System.out.println("\nEnter a number between 1 - 6");
                            System.out.println("\t1) Name\t\t4) Age");
                            System.out.println("\t2) Major   \t5) Address");
                            System.out.println("\t3) GPA \t\t6) Exit\n");
                            userInput = scanner.nextInt();
                            scanner.nextLine();
                            switch (userInput) {
                                case 1:
                                    System.out.print("Enter a new Name: ");
                                    studentName = scanner.nextLine();
                                    temp.setName(studentName);
                                    break;
                                case 2:
                                    System.out.print("Enter a new Major: ");
                                    studentMajor = scanner.nextLine();
                                    temp.setMajor(studentMajor);
                                    break;
                                case 3:
                                    System.out.print("Enter a new GPA: ");
                                    studentGPA = scanner.nextDouble();
                                    temp.setGPA(studentGPA);
                                    break;
                                case 4:
                                    System.out.print("Enter a new Age: ");
                                    studentAge = scanner.nextInt();
                                    temp.setAge(studentAge);
                                    break;
                                case 5:
                                    System.out.print("Enter a new Address: ");
                                    studentAddress = scanner.nextLine();
                                    temp.setAddress(studentAddress);
                                    break;
                                case 6:
                                    editStudentDetails = 0;
                                    break;
                                default:
                                    System.out.println("error - enter a number between 1 and 6");
                            }
                        } while (editStudentDetails != 0);
                    }
                }
                clearScreen(scanner);
                break;
            case 4:
                System.out.print("Enter a name: ");
                nameSearch = scanner.nextLine();
                numStudentsFound = 0;
                hashmapPosition = students.size();
                studentFound = false;

                for (String i : students.keySet()) {
                    temp = students.get(i);
                    if (temp.getName().equals(nameSearch)) {
                        System.out.println("\nSuccess");
                        temp.displayDetails();
                        numStudentsFound++;
                        studentFound = true;
                        hashmapPosition--;
                    } else {
                        System.out.println("Searching...");
                        if (hashmapPosition == 1 && !studentFound) {
                            System.out.println("Failure");
                            System.out.println("Student not found");
                        }
                        hashmapPosition--;
                    }
                }
                System.out.println("\nSearch has concluded, " + numStudentsFound + " student's found");
                clearScreen(scanner);
                break;
            case 5:
                break;
            default:
                System.out.println("\u001B[2J");// clears screen
                System.out.println("Error in input, plese enter a number between 1-5");
        }

        // Displays keys of students
        System.out.println(students.keySet());
        return students;
    }

    public static final void clearScreen(Scanner scanner) {
        System.out.println("Press any key to continue..");
        scanner.nextLine();
        System.out.println("\u001B[2J");
    }

}
