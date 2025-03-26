/***************************
 Name: Jeremy Paruch       *
 Student Number: W0222971  *
 Date: February 24, 2025   *
 Course: Intro to OOP      *
 Instructor: Nadia Gouda   *
 ***************************/
public class Student extends Person {
    private String studentID = generateStudentId();
    private String major;
    private double GPA;
    private static int idCounter = 1000;

    private static String generateStudentId() {
        return "S" + (idCounter++);
    } 

    // constructor
    Student(String major, double GPA, String name, int age, String address){
        // super has to be the first thing in the instructor or it will ALWAYS throw errors :( *Shout out to judah for this*
        super(name, age, address);
        this.major = major;
        this.GPA = GPA;
    }
 
    public String getStudentID() {
        return studentID;
    }

    public String getMajor() {
        return major;
    }
    public double getGPA() {
        return GPA;
    }

    public void setStudentID(String studentID) {this.studentID = studentID;}
    public void setMajor(String major) {this.major = major;}
    public void setGPA(double GPA) {this.GPA = GPA;}

    @Override
    public void displayDetails() {
        System.out.println("\nThis persons name is " + getName());
        System.out.println("Their age is " + getAge());
        System.out.println("Their address is " + getAddress());
        System.out.println("Their ID is " + studentID);
        System.out.println("Their Major is " + major);
        System.out.println("Their GPA is " + getGPA());
        System.out.println("\n******************\n");
        System.out.println("End of Student Details");
        System.out.println("\n******************\n");
        System.out.println("\nPress Enter to Continue\n");
        try
        {
            System.in.read();
        }
        catch(Exception e)
        {}
    }
}
    