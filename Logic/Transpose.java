import java.io.*;
class Transpose{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			System.out.println("Enter rows and columns:");
			int r=Integer.parseInt(d.readLine());
			int c=Integer.parseInt(d.readLine());

			int a[][]=new int[r][c];
			int t[][]=new int[c][r];

			System.out.println("Enter matrix elements:");
			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					a[i][j]=Integer.parseInt(d.readLine());
				}
			}

			for(int i=0;i<r;i++){
				for(int j=0;j<c;j++){
					t[j][i]=a[i][j];
				}
			}

			System.out.println("Transpose:");
			for(int i=0;i<c;i++){
				for(int j=0;j<r;j++){
					System.out.print(t[i][j]+" ");
				}
				System.out.println();
			}
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
