import java.io.*;
class SumLoop{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			System.out.println("Enter n:");
			int n=Integer.parseInt(d.readLine());
			int i=1,j=1,sum=0;
			while(i<=n){
				sum=sum+j;
				j++;
				if(j>i){
					i++;
					j=1;
				}
			}
			System.out.println("Sum = "+sum);
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
