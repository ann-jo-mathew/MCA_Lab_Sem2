import java.util.*;
interface shape{
	public void read();
	public void disp();
	public void area();
}
class Circle implements shape {
	double r;
	double a;
	public void read(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the radius: ");
		r=sc.nextInt();
	}
	public void area(){
		a=3.14*r*r;
		System.out.println("Area= "+a);
	}
	public void disp(){
		System.out.println("Radius= "+r); 
	}
}
class Rectangle implements shape{
	int l,b,a;
	public void read(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter length and breadth: ");
		l=sc.nextInt();
		b=sc.nextInt();
	}
	public void area(){
		a=l*b;
		System.out.println("Area= "+a);
	}
	public void disp(){
		System.out.println("Length= "+l+" ; Breadth= "+b); 
	}

}
class Triangle implements shape{
	double b,h,a;
	public void read(){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter length and breadth: ");
		b=sc.nextInt();
		h=sc.nextInt();
	}
	public void area(){
		a=0.5*b*h;
		System.out.println("Area= "+a);
	}
	public void disp(){
		System.out.println("Base= "+b+" ; Height= "+b); 
	}

}
class MIArea{
	public static void main(String args[]){
		int ch;
		while(true){
			System.out.println();
			System.out.println("1.Circle\n2.Rectangle\n3.Triangle\n4.Exit");
			System.out.print("Enter your choice: ");
			Scanner sc=new Scanner(System.in);
			ch=sc.nextInt();
			switch(ch){
				case 1:
					shape C1=new Circle();
					C1.read();
					C1.disp();
					C1.area();
					break;
				case 2:
					shape R1=new Rectangle();
					R1.read();
					R1.disp();
					R1.area();
					break;
				case 3:
					shape T1=new Triangle();
					T1.read();
					T1.disp();
					T1.area();
					break;
				case 4:
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice");
			}
		}
	}
}
	
