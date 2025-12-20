import java.util.*;
class Student {
    int sno;
    String sname, sprogram;
    void read() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter student number: ");
        sno=sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter student name: ");
        sname=sc.nextLine();
        System.out.print("Enter program: ");
        sprogram=sc.nextLine();
    }
    void display() {
        System.out.println(sno+" "+sname+" "+sprogram);
    }
    boolean compare(Student s) {   
        return sno==s.sno && sname.equals(s.sname) && sprogram.equals(s.sprogram);
    }
}
public class Pgm14 {
    public static void main(String args[]) {
        Student s1=new Student();
        Student s2=new Student();
        System.out.println("Enter first student details:");
        s1.read();
        System.out.println("Enter second student details:");
        s2.read();
        boolean same=s1.compare(s2);
        System.out.println("\nFirst student:");
        s1.display();
        System.out.println("Second student:");
        s2.display();
        System.out.println("\nStudents equal? "+same);
    }
}
