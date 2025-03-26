abstract class Person { // Abstract class for Person
    
    private String name; // Instance variable for name
    private int age; // Instance variable for age
    private String address; // Instance variable for address

    public String getName() { // Getter method for name
        return name; // Return the name
    }

    public int getAge() { // Getter method for age
        return age; // Return the age
    }

    public String getAddress() { // Getter method for address
        return address; // Return the address
    }

    public void setName(String name) { // Setter method for name
        this.name = name; // Set the name
    }

    public void setAge(int age) { // Setter method for age
        this.age = age; // Set the age
    }

    public void setAddress(String address) { // Setter method for address
        this.address = address; // Set the address
    }

    public Person(String name, int age, String address) { // Constructor with parameters
        this.name = name; // Initialize the name
        this.age = age; // Initialize the age
        this.address = address; // Initialize the address
    }

    public void displayDetails() { // Method to display the details of the person
        System.out.println("Name: " + name); // Display the name
        System.out.println("Age: " + age); // Display the age
        System.out.println("Address: " + address); // Display the address
    }
}