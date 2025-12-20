import java.util.*;
class C3ArrayOp{
	Scanner sc=new Scanner(System.in);
	public int[] read(){
		int a[],n,i;
		System.out.print("Enter the size of array: ");
		n=sc.nextInt();
		a=new int[n];
		for(i=0;i<a.length;i++){
			System.out.print("Enter a["+i+"]");
			a[i]=sc.nextInt();
		}
		return a;
	}
	public void disp(int a[]){
		int i;
		System.out.print("Array is:");
		for(i=0;i<a.length;i++){
			System.out.print(a[i]+"\t");
		}
	}
	public void search(int a[]){
		System.out.print("Enter the value:");
		int s=sc.nextInt();
		int i,count=0; 
		for(i=0;i<a.length;i++){
			if(a[i]==s){
				System.out.println("element "+s+" found at location "+i);
				count++;
				return;
			}
		}
		if(count==0)
			System.out.println("Element not found");
	}
}
class M3{
	public static void main(String args[]){
		C3ArrayOp obj=new C3ArrayOp();
		int ar[];
		ar=obj.read();
		obj.disp(ar);
		obj.search(ar);
	}
}
		