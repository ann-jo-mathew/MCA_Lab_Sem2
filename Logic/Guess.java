import java.io.*;
class Guess{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			int secret=27;
			int guess=0,count=0;
			do{
				System.out.println("Enter a number between 20 and 30:");
				guess=Integer.parseInt(d.readLine());
				count++;
			}while(guess!=secret);
			System.out.println("Correct! Attempts = "+count);
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
