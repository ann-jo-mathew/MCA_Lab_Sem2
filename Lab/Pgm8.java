import java.io.*;
import java.util.*;
class Reverse{
	public int reverse(int n){
		int p=0;
		while(n>0){
			int r=n%10;
			p=p*10+r;
			n=n/10;
		}
		return p;
	}
	public void palindrome(int n){
		int temp=n;
		n=reverse(n);
		if(temp==n)
			System.out.println("The number is a Palindrome Number");
		else
			System.out.println("iThe number is not palindrome");
	}
	public int read(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a number: ");
		int n=sc.nextInt();
		return n;
	}
}
class Pgm8{
	public static void main(String args[]){
		int a,r;
		Reverse obj=new Reverse();
		a=obj.read();
		r=obj.reverse(a);
		System.out.println("Reverse: "+r);
		obj.palindrome(a);
	}
}		

		
		
		
				
			
		