import java.io.*;
import java.util.*;
interface il{
	public void disp();
	public void print();
}

class C1 implements il{
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
class MInterface3{
	public static void main(String args[]){
		il obj;
		obj=new C1();
		//il obj=new il(); not possible 
		obj.disp();
		obj.print();
		//obj.show();
	}
}