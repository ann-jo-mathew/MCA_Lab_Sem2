/* Inputting two numbers using command line arguments and displaying their sum
@Ann Jo Mathew 
Roll No: 12
17/11/2025 */

import java.io.*;
class CLA1{
	public static void main(String args[]){
		if(args.length!=2){
			System.out.println("Error: Need Exactly 2 argumnets");
			return;
		}
		int n1,n2,sum;
		n1=Integer.parseInt(args[0]);
		n2=Integer.parseInt(args[1]);
		System.out.println("The two numbers are: "+n1+" and "+n2);
		sum=n1+n2;
		System.out.println("Sum="+sum);	

	}
}
