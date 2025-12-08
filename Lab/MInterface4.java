import java.io.*;			//Multiple interafaces
import java.util.*;
interface i1{
	public void disp();
}
interface i2{
	public void print();
}

class C1 implements i1,i2{
 	public void disp(){
		System.out.println("In disp interface");
	}
	public void print(){
		System.out.println("In print interface");
		show();
	}	
	public void show(){
		System.out.println("Show not interaface");
	}
}
class MInterface4{
	public static void main(String args[]){
		i1 obj1;
		i2 obj2;
		obj1=new C1();
		obj2=new C1();
		//il obj=new il(); not possible 
		obj1.disp();
		obj2.print();
		//obj.show();
	}
}