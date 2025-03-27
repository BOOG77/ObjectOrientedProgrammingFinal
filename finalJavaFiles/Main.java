package finalJavaFiles;

public class Main {

    public static void main(String[] args) {
        Employee e1 = new Employee("Judah", 18, "judah@csanyi.ca", "Janitor");
        Student s1 = new Student("Bob", 20, "asdf@email.com", "IT", 4.0);
        Instructor i1 = new Instructor("Billy", 46, "Billy@gmil.com", "Math");
        e1.displayDetails();
        s1.displayDetails();
        i1.displayDetails();
    }

}
