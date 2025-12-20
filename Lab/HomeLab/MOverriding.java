import java.io.*;
import java.util.*;
class Person{
	int age;
	String name;
	public void read(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the name: ");
		name=sc.nextLine();
		System.out.print("Enter the age: ");
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
		System.out.println("Enter the subject: ");
		subj=sc.nextLine();
	}
	public void disp(){
		super.disp();
		System.out.println("Subject: "+subj);
	}
}
class MOverriding{
	public static void main(String args[]){
		Person p=new Person();
		Teacher t=new Teacher();
		p.read();
		t.read();
		p.disp();
		t.disp();
	}
}
		