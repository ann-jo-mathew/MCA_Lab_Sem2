import java.io.*;
class Quadratic{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			System.out.println("Enter a, b, c:");
			double a=Double.parseDouble(d.readLine());
			double b=Double.parseDouble(d.readLine());
			double c=Double.parseDouble(d.readLine());

			double dlt=b*b-4*a*c;

			if(dlt>0){
				double r1=(-b+Math.sqrt(dlt))/(2*a);
				double r2=(-b-Math.sqrt(dlt))/(2*a);
				System.out.println("Roots are real and different:");
				System.out.println("Root1 = "+r1);
				System.out.println("Root2 = "+r2);
			}
			else if(dlt==0){
				double r=-b/(2*a);
				System.out.println("Roots are real and equal:");
				System.out.println("Root = "+r);
			}
			else{
				double real=-b/(2*a);
				double imag=Math.sqrt(-dlt)/(2*a);
				System.out.println("Roots are complex:");
				System.out.println("Root1 = "+real+" + "+imag+"i");
				System.out.println("Root2 = "+real+" - "+imag+"i");
			}
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
