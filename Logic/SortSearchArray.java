import java.util.*;
class SortSearchArray{
	public static void main(String args[]){
		int a[],i,n,j,e;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the array size: ");
		n=sc.nextInt();
		a=new int[n];
		System.out.print("Enter the array elements: ");
		for(i=0;i<n;i++)
			a[i]=sc.nextInt();
		System.out.println("Sorted elements are: ");
		for(i=0;i<n;i++){
			for(j=0;j<n-i-1;j++){
				if(a[j]>a[j+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		for(i=0;i<n;i++)
			System.out.print(a[i]+"\t");
		System.out.println();
		System.out.print("Enter an element to search: ");
		e=sc.nextInt();
		int mid,h,l;
		h=n-1;		//using Binary Search since elements are sorted
		l=0;
		mid=(l+h)/2;
		while(l<=h){
			mid=(l+h)/2;
			if(a[mid]==e){
				System.out.println("Element "+a[mid]+" found at position "+mid);
				return ;
			}
			else if(e<a[mid])
				h=mid-1;
			else
				l=mid+1;
		}
		if(l>=h)
			System.out.println("Element not found");
	}
}