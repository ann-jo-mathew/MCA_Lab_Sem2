import java.io.*;
class SecondSmallest{
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

			int small=Integer.MAX_VALUE;
			int second=Integer.MAX_VALUE;

			for(int i=0;i<n;i++){
				if(a[i]<small){
					second=small;
					small=a[i];
				}
				else if(a[i]<second && a[i]!=small){
					second=a[i];
				}
			}

			if(second==Integer.MAX_VALUE){
				System.out.println("No second smallest element");
			}
			else{
				System.out.println("Second smallest element = "+second);
			}
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
