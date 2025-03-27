/*
 * Author: Dawson Brown
 * LMD: March 19 2025
 * School: NSCC
 * Course: Object Oriented Programming
 * Assignment: Student Management System
 */
// Create a base class Person
abstract class Person {

    // attributes
    private String name;
    private int age;
    private String address;

    // constructors

    // default constructor
    public Person(){
        name = "default-name";
        age = 0;
        address = "default-address";
    }

    // paramaterized constructor
    public Person(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // setters
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setAddress(String address){
        this.address = address;
    }

    // getters
    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getAddress() {
        return address;
    }

    // methods
    abstract String displayDetails();
}
