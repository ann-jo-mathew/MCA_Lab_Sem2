import java.io.*;
class Guess{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			int secret=27;
			int g=0,count=0;
			do{
				System.out.println("Enter a number between 20 and 30:");
				g=Integer.parseInt(d.readLine());
				count++;
			}while(g!=secret);
			System.out.println("Your guess is Correct\nAttempts = "+count);
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
