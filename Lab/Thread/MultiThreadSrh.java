import java.util.*;
class MultiThread extends Thread{
	int a[],s,e,k;
	public MultiThread(int a[],int s,int e,int key){
		this.a=a;
		this.s=s;
		this.e=e;
		k=key;
	}
	public void run(){
		for(int i=s;i<=e;i++){		//starts at 0 
			if(a[i]==k)
				System.out.println("Elemnt found at index "+i);
		}
	}
}
class MMultiThread{
	public static void main(String args[]){
		int key,a[],n,s,e;
		MultiThread t[];
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the size: ");
		n=sc.nextInt();
		a=new int[n];
		t=new MultiThread[n/5];
		System.out.println("Enter the elements: ");
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
		}
		System.out.print("Enter the element to search: ");
		key=sc.nextInt();
		for(int i=0;i<n/2;i++){
			System.out.println("Thread "+i);
			//if(i==0)s=0;
			//else s=e+1;
			s=i*5;
			//if(i==0)e=5-1;
			//else e=(5*(i+1))-1;
			e=s+4;
			if(e>=n)
				e=n-1;
			t[i]=new MultiThread(a,s,e,key);
			t[i].start();
		}
	}
}	