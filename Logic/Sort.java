import java.io.*;
class Sort{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			System.out.println("Enter size:");
			int n=Integer.parseInt(d.readLine());
			int a[]=new int[n];

			System.out.println("Enter elements:");
			for(int i=0;i<n;i++){
				a[i]=Integer.parseInt(d.readLine());
			}

			for(int i=0;i<n-1;i++){
				for(int j=i+1;j<n;j++){
					if(a[j]<a[i]){
						int temp=a[i];
						a[i]=a[j];
						a[j]=temp;
					}
				}
			}

			System.out.println("Sorted array:");
			for(int i=0;i<n;i++){
				System.out.println(a[i]);
			}
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
