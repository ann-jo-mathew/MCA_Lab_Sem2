import java.io.*;
class Sum{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			System.out.println("Enter the numbers:");
			int a=Integer.parseInt(d.readLine());
			int b=Integer.parseInt(d.readLine());
			System.out.println("Sum of "+a+" and "+b+" is "+(a+b));
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}