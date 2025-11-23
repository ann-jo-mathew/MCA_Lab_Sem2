import java.io.*;
class DispCLA{
	public static void main(String args[]){
		int a,b;
		if(args.length!=2){
			System.out.println("Error: There should be exactly 2 argumnets");
			return;
		}
		a=Integer.parseInt(args[0]);
		b=Integer.parseInt(args[1]);
		System.out.println("a= "+a+" & b= "+b);	
	}
}