import java.io.*;
class C1{
	public void disp(){
		System.out.println("In disp");
	}
	public void show(){
		disp();
		System.out.println("In show");
		disp();
	}
}
class M1{
	public static void main(String args[]){
		C1 obj;
		obj=new C1();
		System.out.println("In main");
		obj.disp();
		System.out.println("Back to main");
		obj.show();
		System.out.println("Finished");
	}
}
	