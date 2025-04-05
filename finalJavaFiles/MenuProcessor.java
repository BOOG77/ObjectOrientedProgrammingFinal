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
        String studentName, studentMajor, studentEmail;
        int studentAge;

        // takes student data
        System.out.print("\nEnter Student's name: ");
        studentName = scanner.nextLine();
        System.out.print("Enter Student's major: ");
        studentMajor = scanner.nextLine();
        System.out.print("Enter Student's Email: ");
        studentEmail = scanner.nextLine();
        System.out.print("Enter Student's age: ");
        studentAge = scanner.nextInt();
        scanner.nextLine();

        // makes the student object
        students.add(new Student(studentName, studentAge, studentEmail, studentMajor));
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
    public static void studentSearchID(ArrayList<Student> students) {
        System.out.print("Enter student ID: ");
        stringInput = scanner.nextLine();

        int numStudentsFound = 0;

        boolean studentFound = false;

        for (Student student : students) {
            tempStudent = student;// keeps looping even after it is found the student id but saves the one that is
                                  // correct incase there are multiple with the same id
            if (student.getID().equals(stringInput)) {
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
    }

    // 1.3.1
    static void studentAttributesMenu(Student student) {
        System.out.println("\u001B[2J");
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║             Student Attribute Menu            ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        student.displayDetails();
        System.out.println("====================================");
        System.out.println("1. Name\t\t2. Role");
        System.out.println("3. Major   \t4. Enrollment Status");
        System.out.println("5. GPA \t\t6. Email");
        System.out.println("4. Age \t\t8. Exit");
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
                System.out.println("The student " + tempStudent.getName() + " has been deleted\n");
            } else {
                System.out.println("Deletion Aborted");
            }
        } else {
            System.out.println("Error - Student not found");
        }
        pause();
    }

    // 2.1
    public ArrayList<Instructor> instructorAdd(ArrayList<Instructor> instructors) {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║               Enroll Instructor               ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println("====================================");
        String instructorName, instructorDepartment, instructorAddress;
        int instructorAge;

        // takes student data
        System.out.print("\nEnter Instructor's name: ");
        instructorName = scanner.nextLine();
        System.out.print("Enter Instructor's Department: ");
        instructorDepartment = scanner.nextLine();
        System.out.print("Enter Instructor's address: ");
        instructorAddress = scanner.nextLine();
        System.out.print("Enter Instructor's age: ");
        instructorAge = scanner.nextInt();
        scanner.nextLine();

        // makes the student object
        instructors.add(new Instructor(instructorName, instructorAge, instructorAddress, instructorDepartment));
        System.out.println("\nThe instructor " + instructorName + " has sucessfully been added");
        pause();
        return instructors;
    }

    // 2.2
    public void instructorDetails(ArrayList<Instructor> instructors) {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║           Instructor Attribute Menu           ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println("====================================");
        for (Instructor instructor : instructors) {
            instructor.displayDetails();
        }
        pause();
    }

    // 2.3
    public static void instructorSearchID(ArrayList<Instructor> instructors) {
        System.out.print("Enter instructor ID: ");
        stringInput = scanner.nextLine();

        int numInstructorFound = 0;

        boolean instructorFound = false;

        for (Instructor instructor : instructors) {
            tempInstructor = instructor;// keeps looping even after it is found the instructor id but saves the one that
                                        // is
            // correct incase there are multiple with the same id
            if (instructor.getID().equals(stringInput)) {
                System.out.println("\nSuccess");
                instructor.displayDetails();
                instructorFound = true;
                numInstructorFound++;
            } else {
                System.out.println("Searching...");
                // if last position in arraylist and instructor not found
                if (instructors.get(instructors.size() - 1) == instructor && !instructorFound) {
                    System.out.println("\nFailure - Instructure not found");
                }
            }
        }
        System.out.println("\nSearch has concluded, " + numInstructorFound + " instructor's found\n");

        if (instructorFound) {
            System.out.print("Do you want to change the instructor's data [Y/n]? ");
            stringInput = scanner.nextLine();

            if (stringInput.toLowerCase().contains("y")) {
                instructorAttributesMenu(tempInstructor);
            }
        }
    }

    // 2.3.1
    static void instructorAttributesMenu(Instructor instructor) {
        System.out.println("\u001B[2J");
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║           Instructor Attribute Menu           ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        instructor.displayDetails();
        System.out.println("====================================");
        System.out.println("1. Name\t\t2. Role");
        System.out.println("3. Department  4. Email");
        System.out.println("5. Age \t\t6. Exit");
        System.out.println("====================================");
        System.out.print("\nEnter your choice: ");
        intInput = scanner.nextInt();
        scanner.nextLine();

        switch (intInput) {
            case 1:
                System.out.print("Enter a new Name: ");
                stringInput = scanner.nextLine();
                instructor.setName(stringInput);
                instructorAttributesMenu(instructor);
                break;
            case 2:
                System.out.print("Enter a new Role: ");
                stringInput = scanner.nextLine();
                instructor.setRole(stringInput);
                instructorAttributesMenu(instructor);
                break;
            case 3:
                System.out.print("Enter a new Department: ");
                stringInput = scanner.nextLine();
                instructor.setDepartment(stringInput);
                instructorAttributesMenu(instructor);
                break;
            case 4:
                System.out.print("Enter a new Email: ");
                stringInput = scanner.nextLine();
                instructor.setEmail(stringInput);
                instructorAttributesMenu(instructor);
                break;
            case 5:
                System.out.print("Enter a new Age: ");
                intInput = scanner.nextInt();
                instructor.setAge(intInput);
                instructorAttributesMenu(instructor);
                break;
            case 6:
                break;
            default:
                System.out.println("Error - enter a number between 1 and 6");
        }
    }

    // 2.4
    public void instructorSearchName(ArrayList<Instructor> instructors) {
        int numInstructorsFound = 0;
        boolean instructorFound = false;

        System.out.print("Enter a name: ");
        stringInput = scanner.nextLine();

        for (Instructor instructor : instructors) {
            tempInstructor = instructor;
            if (tempInstructor.getName().equals(stringInput)) {
                System.out.println("\nSuccess");
                instructor.displayDetails();
                numInstructorsFound++;
                instructorFound = true;
            } else {
                System.out.println("Searching...");
                if (instructors.get(instructors.size() - 1) == instructor && !instructorFound) {
                    System.out.println("\nFailure - Instructor not found");
                }
            }
        }
        System.out.println("\nSearch has concluded, " + numInstructorsFound + " instructor's found");
        pause();
    }

    // 2.5
    public void instructorDelete(ArrayList<Instructor> instructors) {
        System.out.print("Enter instructor ID: ");
        stringInput = scanner.nextLine();

        int numInstructorsFound = 0;

        boolean instructorFound = false;

        for (Instructor instructor : instructors) {
            if (instructor.getID().equals(stringInput)) {
                tempInstructor = instructor;
                System.out.println("\nSuccess");
                instructor.displayDetails();
                instructorFound = true;
                numInstructorsFound++;
            } else {
                System.out.println("Searching...");
                // if last position in arraylist and instructor not found
                if (instructors.get(instructors.size() - 1) == instructor && !instructorFound) {
                    System.out.println("\nFailure - Instructor not found");
                }
            }
        }
        System.out.println("\nSearch has concluded, " + numInstructorsFound + " instructor's found\n");

        if (instructorFound) {
            System.out.print("Are you sure you want to permently delete the instructor's data [Y/n]? ");
            stringInput = scanner.nextLine();

            if (stringInput.toLowerCase().contains("y")) {
                instructors.remove(tempInstructor);
                System.out.println("The instructor " + tempInstructor.getName() + " has been deleted\n");
            } else {
                System.out.println("Deletion Aborted");
            }
        } else {
            System.out.println("Error - Student not found");
        }
        pause();
    }

    // 3.1
    public ArrayList<Employee> employeeAdd(ArrayList<Employee> employees) {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║                Enroll Employee                ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println("====================================");
        String employeeName, employeeDepartment, employeeAddress;
        int employeeAge;

        // takes student data
        System.out.print("\nEnter Employee's name: ");
        employeeName = scanner.nextLine();
        System.out.print("Enter Employee's Department: ");
        employeeDepartment = scanner.nextLine();
        System.out.print("Enter Employee's address: ");
        employeeAddress = scanner.nextLine();
        System.out.print("Enter Employee's age: ");
        employeeAge = scanner.nextInt();
        scanner.nextLine();

        // makes the student object
        employees.add(new Employee(employeeName, employeeAge, employeeAddress, employeeDepartment));
        System.out.println("\nThe employee " + employeeName + " has sucessfully been added");
        pause();
        return employees;
    }

    // 3.2
    public void employeeDetails(ArrayList<Employee> employees) {
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║            Employee Attribute Menu            ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        System.out.println("====================================");
        for (Employee employee : employees) {
            employee.displayDetails();
        }
        pause();
    }

    // 3.3
    public static void employeeSearchID(ArrayList<Employee> employees) {
        System.out.print("Enter employee ID: ");
        stringInput = scanner.nextLine();

        int numEmployeeFound = 0;

        boolean employeeFound = false;

        for (Employee employee : employees) {
            tempEmployee = employee;// keeps looping even after it is found the employee id but saves the one that
                                    // is
            // correct incase there are multiple with the same id
            if (employee.getID().equals(stringInput)) {
                System.out.println("\nSuccess");
                employee.displayDetails();
                employeeFound = true;
                numEmployeeFound++;
            } else {
                System.out.println("Searching...");
                // if last position in arraylist and employee not found
                if (employees.get(employees.size() - 1) == employee && !employeeFound) {
                    System.out.println("\nFailure - Instructure not found");
                }
            }
        }
        System.out.println("\nSearch has concluded, " + numEmployeeFound + " employee's found\n");

        if (employeeFound) {
            System.out.print("Do you want to change the employee's data [Y/n]? ");
            stringInput = scanner.nextLine();

            if (stringInput.toLowerCase().contains("y")) {
                employeeAttributesMenu(tempEmployee);
            }
        }
    }

    // 3.3.1
    static void employeeAttributesMenu(Employee employee) {
        System.out.println("\u001B[2J");
        System.out.println("\n╔═══════════════════════════════════════════════╗");
        System.out.println("║             Employee Attribute Menu           ║");
        System.out.println("╚═══════════════════════════════════════════════╝");
        employee.displayDetails();
        System.out.println("====================================");
        System.out.println("1. Name\t\t2. Role");
        System.out.println("3. Job \t4. Salary");
        System.out.println("5. Email\t\t6. Age");
        System.out.println("\t\t8. Exit");
        System.out.println("====================================");
        System.out.print("\nEnter your choice: ");
        intInput = scanner.nextInt();
        scanner.nextLine();

        switch (intInput) {
            case 1:
                System.out.print("Enter a new Name: ");
                stringInput = scanner.nextLine();
                employee.setName(stringInput);
                employeeAttributesMenu(employee);
                break;
            case 2:
                System.out.print("Enter a new Role: ");
                stringInput = scanner.nextLine();
                employee.setRole(stringInput);
                employeeAttributesMenu(employee);
                break;
            case 3:
                System.out.print("Enter a new Job: ");
                stringInput = scanner.nextLine();
                employee.setJob(stringInput);
                employeeAttributesMenu(employee);
                break;
            case 4:
                System.out.print("Enter a new Salary: ");
                doubleInput = scanner.nextDouble();
                employee.setSalary((float) doubleInput);
                employeeAttributesMenu(employee);
                break;
            case 5:
                System.out.print("Enter a new Email: ");
                stringInput = scanner.nextLine();
                employee.setEmail(stringInput);
                employeeAttributesMenu(employee);
                break;
            case 6:
                System.out.print("Enter a new Age: ");
                intInput = scanner.nextInt();
                employee.setAge(intInput);
                employeeAttributesMenu(employee);
                break;
            case 7:
                break;
            default:
                System.out.println("Error - enter a number between 1 and 9");
        }
    }

    // 3.4
    public void employeeSearchName(ArrayList<Employee> employees) {
        int numEmployeesFound = 0;
        boolean employeeFound = false;

        System.out.print("Enter a name: ");
        stringInput = scanner.nextLine();

        for (Employee employee : employees) {
            tempEmployee = employee;
            if (tempEmployee.getName().equals(stringInput)) {
                System.out.println("\nSuccess");
                employee.displayDetails();
                numEmployeesFound++;
                employeeFound = true;
            } else {
                System.out.println("Searching...");
                if (employees.get(employees.size() - 1) == employee && !employeeFound) {
                    System.out.println("\nFailure - Employee not found");
                }
            }
        }
        System.out.println("\nSearch has concluded, " + numEmployeesFound + " employee's found");
        pause();
    }

    // 3.5
    public void employeeDelete(ArrayList<Employee> employees) {
        System.out.print("Enter employee ID: ");
        stringInput = scanner.nextLine();

        int numEmployeesFound = 0;

        boolean employeeFound = false;

        for (Employee employee : employees) {
            if (employee.getID().equals(stringInput)) {
                tempEmployee = employee;
                System.out.println("\nSuccess");
                employee.displayDetails();
                employeeFound = true;
                numEmployeesFound++;
            } else {
                System.out.println("Searching...");
                // if last position in arraylist and employee not found
                if (employees.get(employees.size() - 1) == employee && !employeeFound) {
                    System.out.println("\nFailure - Employee not found");
                }
            }
        }
        System.out.println("\nSearch has concluded, " + numEmployeesFound + " employee's found\n");

        if (employeeFound) {
            System.out.print("Are you sure you want to permently delete the employee's data [Y/n]? ");
            stringInput = scanner.nextLine();

            if (stringInput.toLowerCase().contains("y")) {
                employees.remove(tempEmployee);
                System.out.println("The employee " + tempEmployee.getName() + " has been deleted\n");
            } else {
                System.out.println("Deletion Aborted");
            }
        } else {
            System.out.println("Error - Student not found");
        }
        pause();
    }

    // 4
    public void fullIDSearch(ArrayList<Student> students, ArrayList<Instructor> instructors,
            ArrayList<Employee> employees) {
        System.out.print("Enter ID: ");
        stringInput = scanner.nextLine();

        if (stringInput.substring(0, 1).equals("S")) {
            int numStudentsFound = 0;
            boolean studentFound = false;

            for (Student student : students) {
                tempStudent = student;// keeps looping even after it is found the student id but saves the one that is
                                      // correct incase there are multiple with the same id
                if (student.getID().equals(stringInput)) {
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
        } else if (stringInput.substring(0, 1).equals("I")) {
            int numInstructorFound = 0;
            boolean instructorFound = false;

            for (Instructor instructor : instructors) {
                tempInstructor = instructor;// keeps looping even after it is found the instructor id but saves the one
                                            // that
                                            // is
                // correct incase there are multiple with the same id
                if (instructor.getID().equals(stringInput)) {
                    System.out.println("\nSuccess");
                    instructor.displayDetails();
                    instructorFound = true;
                    numInstructorFound++;
                } else {
                    System.out.println("Searching...");
                    // if last position in arraylist and instructor not found
                    if (instructors.get(instructors.size() - 1) == instructor && !instructorFound) {
                        System.out.println("\nFailure - Instructure not found");
                    }
                }
            }
            System.out.println("\nSearch has concluded, " + numInstructorFound + " instructor's found\n");

            if (instructorFound) {
                System.out.print("Do you want to change the instructor's data [Y/n]? ");
                stringInput = scanner.nextLine();

                if (stringInput.toLowerCase().contains("y")) {
                    instructorAttributesMenu(tempInstructor);
                }
            }
        } else if (stringInput.substring(0, 1).equals("E")) {
            int numEmployeeFound = 0;
            boolean employeeFound = false;

            for (Employee employee : employees) {
                tempEmployee = employee;// keeps looping even after it is found the employee id but saves the one that
                                        // is
                // correct incase there are multiple with the same id
                if (employee.getID().equals(stringInput)) {
                    System.out.println("\nSuccess");
                    employee.displayDetails();
                    employeeFound = true;
                    numEmployeeFound++;
                } else {
                    System.out.println("Searching...");
                    // if last position in arraylist and employee not found
                    if (employees.get(employees.size() - 1) == employee && !employeeFound) {
                        System.out.println("\nFailure - Instructure not found");
                    }
                }
            }
            System.out.println("\nSearch has concluded, " + numEmployeeFound + " employee's found\n");

            if (employeeFound) {
                System.out.print("Do you want to change the employee's data [Y/n]? ");
                stringInput = scanner.nextLine();

                if (stringInput.toLowerCase().contains("y")) {
                    employeeAttributesMenu(tempEmployee);
                }
            }

        } else {
            System.out.println("Error - ID not found");
        }
        pause();
    }

    static final void pause() {
        System.out.println("Press any key to continue..");
        scanner.nextLine();
    }
}