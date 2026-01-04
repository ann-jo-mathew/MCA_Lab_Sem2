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
    String subj;
    public void read(){
        super.read();
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter subject: ");
        subj=sc.nextLine();
    }
    public void disp(){
        super.disp();
        System.out.println("Subject: "+subj);
    }
}
class Pgm2OverridingSoln{
    public static void main(String args[]){
        Person p=new Person();
        Teacher t=new Teacher();
        System.out.println("Person details:");
        p.read();
        p.disp();
        System.out.println();   
        System.out.println("\nTeacher details:");
        t.read();
        t.disp();
    }
}   
        