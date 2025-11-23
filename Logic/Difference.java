import java.io.*;
class Difference{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			System.out.println("Enter the numbers:");
			int a=Integer.parseInt(d.readLine());
			int b=Integer.parseInt(d.readLine());
			int d=a;
			while(d!=a-b){
				if(d>a-b){
					d--;
				}
				else{
					d++;
				}
			}
			System.out.println("Difference of "+a+" and "+b+" is "+d);
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
