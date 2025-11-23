import java.io.*;
class MaxOf3_3Logic{
	public static void main(String args[]){
		int a,b,c;
		a=10;
		b=2;
		c=13;
		//1
		if(a>b){
			if(a>c)
				System.out.println(a);
			else
				System.out.println(c);
		}
			
		else{
			if(b>c)
				System.out.println(b);
			else
				System.out.println(c);
		}
		//2
		int max = a;
        	if (b > max)
            		max = b;
        	if (c > max)
            		max = c;
		//3
	}
}
		