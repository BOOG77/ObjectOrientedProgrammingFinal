package finalJavaFiles;

import java.time.LocalDate;

public class Employee extends User {
    LocalDate date = LocalDate.now();
    private String job;
    private LocalDate startDate;
    private LocalDate endDate;
    private float salary;

    // Generates ID
    private static int idCounter = 1000;

    public static String generateEmployeeID() {
        return "E" + (idCounter++);
    }

    // Constructor
    Employee(String name, int age, String email, String job) {
        super(name, age, email, generateEmployeeID(), "Employee");
        this.job = job;
        this.salary = 50000.00f;
        this.startDate = LocalDate.now();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
