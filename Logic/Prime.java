import java.io.*;
class Prime{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			System.out.println("Enter a number:");
			int n=Integer.parseInt(d.readLine());
			int i=2,c=0;
			while(i<=n/2){
				if(n%i==0){
					c=1;
					break;
				}
				i++;
			}
			if(n<=1){
				System.out.println(n+" is not prime");
			}
			else if(c==0){
				System.out.println(n+" is prime");
			}
			else{
				System.out.println(n+" is not prime");
			}
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
