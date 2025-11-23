import java.io.*;
class MatrixMulti{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			System.out.println("Enter rows and columns of first matrix:");
			int r1=Integer.parseInt(d.readLine());
			int c1=Integer.parseInt(d.readLine());

			System.out.println("Enter rows and columns of second matrix:");
			int r2=Integer.parseInt(d.readLine());
			int c2=Integer.parseInt(d.readLine());

			if(c1!=r2){
				System.out.println("Matrix multiplication not possible");
				return;
			}

			int a[][]=new int[r1][c1];
			int b[][]=new int[r2][c2];
			int c[][]=new int[r1][c2];

			System.out.println("Enter elements of first matrix:");
			for(int i=0;i<r1;i++){
				for(int j=0;j<c1;j++){
					a[i][j]=Integer.parseInt(d.readLine());
				}
			}

			System.out.println("Enter elements of second matrix:");
			for(int i=0;i<r2;i++){
				for(int j=0;j<c2;j++){
					b[i][j]=Integer.parseInt(d.readLine());
				}
			}

			for(int i=0;i<r1;i++){
				for(int j=0;j<c2;j++){
					c[i][j]=0;
					for(int k=0;k<c1;k++){
						c[i][j]=c[i][j]+a[i][k]*b[k][j];
					}
				}
			}

			System.out.println("Resultant matrix:");
			for(int i=0;i<r1;i++){
				for(int j=0;j<c2;j++){
					System.out.print(c[i][j]+" ");
				}
				System.out.println();
			}
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
