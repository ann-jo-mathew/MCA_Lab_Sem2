import java.io.*;
class SumLoop2{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			System.out.println("Enter n:");
			int n=Integer.parseInt(d.readLine());
			double sum=0.0;
			int fact=1;

			for(int i=1;i<=n;i++){
				fact=fact*i;
				sum=sum+(double)i/fact;
			}

			System.out.println("Sum = "+sum);
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
