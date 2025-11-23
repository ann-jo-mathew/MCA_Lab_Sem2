import java.io.*;
class DisplayMtoN{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			System.out.println("Enter m and n:");
			int m=Integer.parseInt(d.readLine());
			int n=Integer.parseInt(d.readLine());
			while(m<=n){
				System.out.println(m);
				m++;
			}
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
