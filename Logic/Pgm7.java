import java.util.*;
class Pgm7{
	public int max(int x,int y){
		if(x>y)
			return x;
		else
			return y;
	} 
	public static void main(String args[]){
		int a,b,c,m;
		Pgm7 obj=new Pgm7();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter three numbers: ");
		a=sc.nextInt();
		b=sc.nextInt();
		c=sc.nextInt();
		m=obj.max(a,b);
		m=obj.max(m,c);
		System.out.println("Max= "+m);
	}
}