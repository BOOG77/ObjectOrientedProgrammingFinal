import java.util.Scanner; // Import the Scanner class

public class Main {

    public static Scanner input = new Scanner(System.in); // Create a Scanner object

    public static void main(String[] args) {


        boolean exit = false; // Variable to control the loop

        while (!exit) { // Infinite loop to display the menu until the user exits the program   
            StudentManager.displayMenu(); // Call the displayMenu() method which displays the menu options
            int choice = input.nextInt(); // Read the user's choice

            switch (choice) { // Switch case based on the user's choice
                case 1 -> { // If the user chooses option 1
                    System.out.println(" "); // Print a space
                    System.out.println("Enter Student Name:"); // Prompt the user to enter the student's name
                    input.nextLine(); // Consume the newline character
                    String name = input.nextLine(); // Read the student's name
                    System.out.println("Enter Student Age:"); // Prompt the user to enter the student's age
                    int age = input.nextInt(); // Read the student's age
                    System.out.println("Enter Student Address:"); // Prompt the user to enter the student's address
                    input.nextLine(); // Consume the newline character
                    String address = input.nextLine(); // Read the student's address
                    System.out.println("Enter Student Major:"); // Prompt the user to enter the student's major
                    String major = input.nextLine(); // Read the student's major
                    System.out.println("Enter Student GPA:"); // Prompt the user to enter the student's GPA
                    double gpa = input.nextDouble(); // Read the student's GPA

                    Student student = new Student(name, age, address, major, gpa); // Create a new Student object

                    StudentManager.getStudentList().add(student); // Add the student to the studentList array list
                    System.out.println(" ");
                    System.out.println("====================================");
                    System.out.println("Uploading student details to program...."); // Print message about uploading student details
                    System.out.println("Student added successfully!"); // Display a success message
                    System.out.println("===================================="); // Display a separator
                    System.out.println("Press enter to continue...");
                    try {
                        System.in.read();
                    } catch(Exception e) {
                        System.out.println("Press enter to continue...");
                    }
                }
                case 2 -> { // If the user chooses option 2
                    System.out.println(" "); // Print space
                    System.out.println("===================================="); // Display a separator
                    System.out.println(" ");
                    System.out.println("Enter the student ID of the student you wish to remove: ");
                    input.nextLine();
                    String studentIDToRemove = input.nextLine();
                    System.out.println(" ");

                    boolean removed = StudentManager.getStudentList().removeIf(student -> student.getStudentId().equals(studentIDToRemove));

                    if (removed) {
                        System.out.println("===================================="); // Display a separator
                        System.out.println("Attempting to remove student from program....");
                        System.out.println("Student with ID " + studentIDToRemove + " has been removed.");
                        System.out.println("===================================="); // Display a separator
                    } else {
                        System.out.println("===================================="); // Display a separator
                        System.out.println("Attempting to remove student from program....");
                        System.out.println("Student with ID " + studentIDToRemove + " not found. Unable to remove.");
                        System.out.println("===================================="); // Display a separator
                    }

                    System.out.println(" ");
                    System.out.println("===================================="); // Display a separator
                    System.out.println("List of students after removal:");
                    System.out.println("===================================="); // Display a separator
                    for (Student student : StudentManager.getStudentList()) {
                        student.displayDetails();
                        System.out.println("===================================="); // Display a separator
                    }
                    try {
                        System.in.read();
                    } catch(Exception e) {
                        System.out.println("Press enter to continue...");
                    }
                }
                case 3 -> { // If the user chooses option 3
                    System.out.println(" "); // Print space
                    System.out.println("Enter the student ID of the student you wish to update:");
                    input.nextLine();
                    String studentIDToUpdate = input.nextLine();
                    boolean studentFound = false;
                    for (Student student : StudentManager.getStudentList()) {
                        if (student.getStudentId().equals(studentIDToUpdate)) {
                            System.out.println(" "); // Print space
                            System.out.println("===================================="); // Display a separator
                            System.out.println("Update options:");
                            System.out.println("1. Name");
                            System.out.println("2. Address");
                            System.out.println("3. Age");
                            System.out.println("4. Major");
                            System.out.println("5. GPA");
                            System.out.println("===================================="); // Display a separator
                            System.out.println(" "); // Print space
                            System.out.println("Enter your choice:");
                            int updateChoice = input.nextInt();
                            input.nextLine();

                            switch (updateChoice) {
                                case 1 -> {
                                    System.out.println("Enter the updated name:");
                                    String newName = input.nextLine();
                                    student.setName(newName);
                                    System.out.println(" "); // Print space
                                    System.out.println("Name updated successfully.");
                                    System.out.println("===================================="); // Display a separator
                                }
                                case 2 -> {
                                    System.out.println("Enter the updated address:");
                                    String newAddress = input.nextLine();
                                    student.setAddress(newAddress);
                                    System.out.println(" "); // Print space
                                    System.out.println("Address updated successfully.");
                                    System.out.println("===================================="); // Display a separator
                                }
                                case 3 -> {
                                    System.out.println("Enter the updated age:");
                                    int newAge = input.nextInt();
                                    student.setAge(newAge);
                                    System.out.println(" "); // Print space
                                    System.out.println("Age updated successfully.");
                                    System.out.println("===================================="); // Display a separator
                                }
                                case 4 -> {
                                    System.out.println("Enter the updated major:");
                                    String newMajor = input.nextLine();
                                    student.setMajor(newMajor);
                                    System.out.println(" "); // Print space
                                    System.out.println("Major updated successfully.");
                                    System.out.println("===================================="); // Display a separator
                                }
                                case 5 -> {
                                    System.out.println("Enter the updated GPA:");
                                    double newGPA = input.nextDouble();
                                    student.setGpa(newGPA);
                                    System.out.println(" "); // Print space
                                    System.out.println("GPA updated successfully.");
                                    System.out.println("===================================="); // Display a separator
                                }
                                default -> System.out.println("Invalid choice. Please try again.");
                            }
                            studentFound = true;
                            break;
                        }
                    }
                    if (!studentFound) { // If the student is not found
                        System.out.println(" "); // Print space
                        System.out.println("Student with ID " + studentIDToUpdate + " not found."); // Display a message stating the student was not found
                        System.out.println("===================================="); // Display a separator
                    }
                }
                case 4 -> { // If the user chooses option 4
                    System.out.println(" "); // Print space
                    System.out.println("Displaying details of all students:"); // Display a message stating the action
                    System.out.println("===================================="); // Display a separator
                    if (StudentManager.getStudentList().isEmpty()) {
                        System.out.println("No students to display.");
                        System.out.println("===================================="); // Display a separator
                        try {
                            System.in.read();
                        } catch(Exception e) {
                            System.out.println("Press enter to continue...");
                        }
                    } else {
                        for (Student student : StudentManager.getStudentList()) { // Iterate over the studentList array list
                            student.displayDetails(); // Call the displayDetails() method for each student
                            System.out.println("===================================="); // Display a separator
                        }
                    }
                }
                case 5 -> { // If the user chooses option 5
                    System.out.println("Enter Student ID: (Ex: S1001)"); // Prompt the user to enter the student's ID
                    input.nextLine(); // Consume the newline character
                    String searchId = input.nextLine(); // Read the student's ID
                    boolean studentFound = false; // Variable to track if the student is found

                    for (Student student : StudentManager.getStudentList()) { // Iterate over the studentList array list
                        if (student.getStudentId().equals(searchId)) { // Check if the student ID matches the search ID
                            System.out.println(" "); // Print space
                            System.out.println("===================================="); // Display a separator
                            student.displayDetails(); // Call the displayDetails() method for the student
                            studentFound = true; // Set the found variable to true
                            break; // Exit the loop once the student is found
                        }
                    }
                    if (!studentFound) { // If the student is not found
                        System.out.println("Student with ID " + searchId + " not found."); // Display a message stating the student was not found
                    }
                    System.out.println("===================================="); // Display a separator
                }
                case 6 -> { // If the user chooses option 6
                    System.out.println(" ");
                    System.out.println("Exiting the program..."); // Display a message stating the action of exiting the program
                    exit = true; // Set the exit variable to true to exit the loop
                }
                default -> {
                        System.out.println(" "); // Print space
                        System.out.println("=========================================================");
                        System.out.println("Invalid input detected.\nPlease try again, entering one of the options available."); // If the user enters an invalid choice
                        System.out.println("=========================================================");
                        System.out.println(" "); // Print space
                }
            }
        }
        input.close(); // Close the Scanner object
        System.out.println("Thank you for using the Student Management System!"); // Display a "thank you" message for using the program
        System.out.println("Programmed by: Josh Leslie"); // Display the programmer's name
        System.out.println("LMD: 03/03/2025"); // Display the last modified date
    }

}