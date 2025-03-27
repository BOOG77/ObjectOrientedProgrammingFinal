/*
 * Author: Dawson Brown
 * LMD: March 19 2025
 * School: NSCC
 * Course: Object Oriented Programming
 * Assignment: Student Management System
 */
public class Student extends Person {

    // https://stackoverflow.com/questions/52613765/create-unique-id-with-constructor
    private static int idCounter = 1000;
    private String studentId;

    private String major = "";
    private double GPA;

    // default constructor
    public Student(){
        major = "default-major";
        GPA =  0.00;
        studentId = generateStudentId();
    }

    // paramaterized constructor generated with a static variable
    public Student(String major, double GPA, String name, int age, String address){
        super(name, age, address);
        this.major = major;
        this.GPA = GPA;
        studentId = generateStudentId();
    }

    // getters
    public String getMajor(){

        return major;
    }

    public String getStudentId(){

        return studentId;
    }

    public double getGPA(){

        return GPA;
    }

    // setters
    public void setStudentId(String studentId){

        this.studentId = studentId;
    }

    public void setMajor(String major){

        this.major = major;
    }

    public void setGPA(double GPA){

        this.GPA = GPA;
    }

    // methods
    @Override
    public String displayDetails(){
        // Reusing code from the Person class ^.^
        // https://www.w3schools.com/java/ref_keyword_super.asp
        return "Name: " + super.getName() + "\nAge: " + super.getAge() + "\nAddress: " + super.getAddress() + "\nID: " + studentId + "\nMajor: " + major + "\nGPA: " + GPA;
    }

    private static String generateStudentId(){
        return "S" + idCounter++;
    }


}
