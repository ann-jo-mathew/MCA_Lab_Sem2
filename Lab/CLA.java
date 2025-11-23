/* Display two numbers using command line arguments
@Ann Jo Mathew 
Roll No: 12
17/11/2025 */

import java.io.*;
class CLA{
	public static void main(String args[]){
		if(args.length!=2){
			System.out.println("Error: Need exactly 2 arguments");
			return;
		}
		String a=args[0];
		String b=args[1];
		System.out.println("The two numbers are: "+a+" and "+b);
	}
}
