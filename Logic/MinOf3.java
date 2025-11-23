import java.io.*;
class MinOf3{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			System.out.println("Enter 3 numbers:");
			int a=Integer.parseInt(d.readLine());
			int b=Integer.parseInt(d.readLine());
			int c=Integer.parseInt(d.readLine());
			int min=(a<b)?((a<c)?a:c):((b<c)?b:c);
			System.out.println("Minimum="+min);
		}
		catch(Exception e){
			System.out.println("Error:"+e);
		}
	}
}
