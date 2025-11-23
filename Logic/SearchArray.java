import java.io.*;
class SearchArray{
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

			System.out.println("Enter element to search:");
			int x=Integer.parseInt(d.readLine());

			int flag=0;
			for(int i=0;i<n;i++){
				if(a[i]==x){
					flag=1;
					break;
				}
			}

			if(flag==1){
				System.out.println(x+" found in array");
			}
			else{
				System.out.println(x+" not found in array");
			}
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
