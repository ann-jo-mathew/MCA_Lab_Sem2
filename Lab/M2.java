import java.util.*;
class C2{
	public int add(int a,int b){
		return a+b;
	}
	public String add(String a,String b){
		return a+b;
	}
}
class M2{
	public static void main(String args[]){
		C2 obj=new C2();
		System.out.println("Sum= "+(obj.add(10,20)));
		System.out.println("Concat= "+(obj.add("hello","world")));
	}
}