package finalJavaFiles;

import java.io.Serializable;//allows the object to be converted into bytes

abstract class User implements Serializable {
    private String name;
    private int age;
    private String email;
    private String role;
    private String ID;

    // Constructor
    public User(String name, int age, String email, String ID, String role) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.role = role;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // *NEEDS TO BE WORKED ON SO THERE CAN NOT BE DUPLICATE ID'S */
    // public void setID(String ID){this.ID = ID;}

    // getters
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public String getEmail() {
        return this.email;
    }

    public String getRole() {
        return this.role;
    }

    public String getID() {
        return this.ID;
    }

}