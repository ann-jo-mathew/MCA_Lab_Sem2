import java.io.*;
class Swap3Logic{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			System.out.println("Enter the numbers:");
			int a=Integer.parseInt(d.readLine());
			int b=Integer.parseInt(d.readLine());
			System.out.println("a="+a+" and b= "+b);
		
		//swap1
		int t=a;
		a=b;
		b=t;
		System.out.println("a="+a+" and b= "+b);
		//swap2
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("a="+a+" and b= "+b);
		//swap3
		a=a*b;
		b=a/b;
		a=a/b;
		System.out.println("a="+a+" and b= "+b);
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}