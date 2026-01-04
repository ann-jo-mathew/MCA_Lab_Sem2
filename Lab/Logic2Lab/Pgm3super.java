import java.util.*;
class Person {
    int age;
    String name;
    Person(String name,int age) {
        this.name=name;
        this.age=age;
    }
    void display() {
        System.out.println("Name:"+name);
        System.out.println("Age:"+age);
    }
}
class Teacher extends Person {
    String subject;
    Teacher(String name,int age,String subject) {
        super(name,age);        //passing arguments to base class constructor
        this.subject=subject;
    }
    void display() {
        super.display();    //base class method overriden in derived class
        System.out.println("Subject:"+subject);
    }
}
class Pgm3Super{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter teacher name:");
        String name=sc.nextLine();
        System.out.print("Enter teacher age:");
        int age=sc.nextInt();
        sc.nextLine();
        System.out.print("Enter subject:");
        String subject=sc.nextLine();
        Teacher t=new Teacher(name,age,subject);
        System.out.println("\nTeacher Details:");
        t.display();
    }
}
