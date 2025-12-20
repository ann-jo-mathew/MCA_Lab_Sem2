import java.util.*;
class Person{      // Base class
	String name;
	Aadhaar a=new Aadhaar();
	public Person(String name,int n){
		this.name=name;
		a.id=n;
	}
	public Person(String name){
		this.name=name;
	}
    	void dispP(){
        	System.out.println("Name: "+name);
		a.dispA();
    	}
}
class Student extends Person{      // Student ISA Person
    	int rollNo;
	public Student(String name, int rollNo) {
        	super(name);
       		this.rollNo=rollNo;
    	}
    	void dispS() {
		dispP();
        	System.out.println("Roll No: "+rollNo);
    	}
}
class Aadhaar{         // Person HASA Aadhaar
    	int id;
    	void dispA() {
        	System.out.println("Aadhaar no: "+id);
    	}
}
public class IsaHasaRelation {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);

		System.out.println("ISA Relationship:");
		System.out.println("Enter the name: ");
		String a=sc.nextLine();
		System.out.print("Enter Roll no: ");
		int rn=sc.nextInt();
		Student s = new Student(a,rn);
		s.dispS();
		System.out.println();

		System.out.println("HASA Relationship:");
		System.out.print("Enter the name: ");
		String b=sc.nextLine();
		System.out.print("Enter Aadhaar no: ");
		int n=sc.nextInt();
		Person p = new Person(b,n);
		p.dispP();
	}
}
