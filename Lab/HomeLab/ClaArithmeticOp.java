/* Arithmetic operation using Command Line Arguments
@Ann Jo Mathew 
Roll No: 12
17/11/2025 */

import java.io.*;
class ClaArithmeticOp{
	public static void main(String args[]){
		if(args.length!=3){
			System.out.println("Error: Need exactly 3 arguments: operand1 operand2 choice");
			return;	
		}
		int n1,n2,ch,r;
		n1=Integer.parseInt(args[0]);
		n2=Integer.parseInt(args[1]);
		ch=Integer.parseInt(args[2]);
		switch(ch){
		case 0:
			r=n1+n2;
			System.out.println("Sum= "+r);
			break;
		case 1:
			r=n1-n2;
			System.out.println("Difference= "+r);
			break;
		case 2:
			r=n1*n2;
			System.out.println("Product= "+r);
			break;
		case 3:
			if(n2==0)
				System.out.println("Error: Division by zero is not allowed");
			else{
				r=n1/n2;
				System.out.println("Quotient= "+r);
			}
				break;
		default:
			System.out.println("Invalid choice! Choices are: 0 for Addition, 1 for Subtraction, 2 for multiplication, 3 for Division.");	
		}	

	}
}
