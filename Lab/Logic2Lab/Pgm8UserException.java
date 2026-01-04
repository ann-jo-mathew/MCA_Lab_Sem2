import java.util.*;
class UDE extends Exception{
	String strError;
	public UDE(){		//constructor
		strError="Unknown Error";
	}
	public UDE(String s){	//constructor with argument
		strError=s;
	}
	public String showError(){	//method to return error
		return strError;
	}	
}
class Pgm8UserException{	//throw
	public static void main(String args[]){
		int a,b,c;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter numerator:");
		a=sc.nextInt();
		System.out.print("Enter dinominator:");
		b=sc.nextInt();
		try{
			if(b==0)
				throw new UDE("Dinominator is ZERO");	//here 2nd consructor is invoked
			c=a/b;
			System.out.println(c);
		}
		catch(UDE e){
			System.out.println(e.showError());
		}
	}
}