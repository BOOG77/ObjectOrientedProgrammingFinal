package finalJavaFiles;

import java.time.LocalDate;

public class Employee extends User {
    LocalDate date = LocalDate.now();

    private String job;
    private LocalDate startDate, endDate;
    private float salary;

    // Generates ID
    public static String generateEmployeeID() {
        return "E" + (idCounter++);
    }

    // Constructor
    public Employee(String name, int age, String email, String job) {
        super(name, age, email, generateEmployeeID(), "Employee");
        this.job = job;
        this.salary = 50000.00f;
        this.startDate = LocalDate.now();
    }

    // getters
    public LocalDate getStartDate() {
        return this.startDate;
    }

    public LocalDate getEndDate() {
        return this.endDate;
    }

    public float getSalary() {
        return this.salary;
    }

    public String getJob() {
        return this.job;
    }

    // setters
    // start date cannot be set because it would remove validity
    public void setEndDate(LocalDate date) {// fired
        this.endDate = date;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void displayDetails() {
        System.out.println("-----------------------------");
        System.out.println("Employee Name: " + getName());
        System.out.println("Employee ID: " + getID());
        System.out.println("Employee Role: " + getRole());
        System.out.println("Employee Job: " + getJob());
        System.out.println("Employee Salary: $" + getSalary());
        System.out.println("Employee Email: " + getEmail());
        System.out.println("Employee Age: " + getAge());
        System.out.println("Employee Start Date: " + getStartDate());
        System.out.println("Employee End Date: " + getEndDate());
        System.out.println("-----------------------------");
    }

}
