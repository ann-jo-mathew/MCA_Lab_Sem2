import java.util.*;
class Person {
    int age;
    String name;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Person constructor called");
    }
    void display() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}
class Teacher extends Person {
    String subject;
    Teacher(String name, int age, String subject) {     // Passing arguments to base class constructor using super
        super(name, age);
        this.subject = subject;
        System.out.println("Teacher constructor called");
    }
    void display() {
        super.display();    // calls base class method overriden in derived class
        System.out.println("Subject: " + subject);
    }
}
class SuperKeywordDemo {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter teacher name: ");
        String name = sc.nextLine();
        System.out.print("Enter teacher age: ");
        int age=sc.nextInt();
        System.out.print("Enter subject: ");
        String subject = sc.nextLine();
        Teacher t = new Teacher(name, age, subject);
        System.out.println("\nTeacher Details:");
        t.display();
    }
}
