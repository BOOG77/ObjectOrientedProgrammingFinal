/***************************
 Name: Jeremy Paruch       *
 Student Number: W0222971  *
 Date: February 24, 2025   *
 Course: Intro to OOP      *
 Instructor: Nadia Gouda   *
 ***************************/
abstract class Person {
    private String name; 
    private int age; 
    private String address;


    //constructor
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public void setName(String name) {this.name = name;}
    public void setAge(int age) {this.age = age;}
    public void setAddress(String address) {this.address = address;}

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }

    //display detail method

    public void displayDetails() {
        System.out.println("*****************************\n\n");
        System.out.println("This persons name is " + name );
        System.out.println("Their age is " + age);
        System.out.println("Their address is " + address);
        System.out.println("*****************************\n\n");
    }




}
