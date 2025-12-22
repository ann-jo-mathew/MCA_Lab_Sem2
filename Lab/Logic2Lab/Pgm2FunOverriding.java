import java.util.*;
class Person{
    int age;
    String name;
    public void read(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter name: ");
        name=sc.nextLine();
        System.out.print("Enter age: ");
        age=sc.nextInt();
    }
    public void disp(){
        System.out.println("Name: "+name);
        System.out.println("Age: "+age);
    }
}
class Teacher extends Person{
    String subject;
    public void read(){
        super.read();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter subject: ");
        subject=sc.nextLine();
    }
    public void disp(){
        super.disp();
        System.out.println("Subject: "+subject);
    }
}
class Pgm2FunOverriding{
    public static void main(String args[]){
        Person p=new Person();
        Teacher t=new Teacher();
        System.out.println("Enter Person details:");
        p.read();
        System.out.println("Person details:");
        p.disp();
        System.out.println();
        System.out.println("\nEnter Teacher details:");
        t.read();
        System.out.println("Teacher details:");
        t.disp();
    }
}

