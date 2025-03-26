abstract class Person {
    private String name;
    private int age;
    private String address;


    //Constructor
    public Person(String name, int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setAddress(String address){
        this.address = address;
    }

    //getters
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public String getAddress(){
        return address;
    }

    //Methods
    public void displayDetails(){
        System.out.println("--------------------------");
        System.out.println("Person name: "+name);
        System.out.println("Person age: "+age);
        System.out.println("Person address: "+address);
        System.out.println("--------------------------");
    }
    
}