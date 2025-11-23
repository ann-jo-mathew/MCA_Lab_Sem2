import java.io.*;
class MatrixSum{
	public static void main(String args[]){
		DataInputStream d=new DataInputStream(System.in);
		try{
			int a[][]=new int[3][3];

			System.out.println("Enter 9 numbers:");
			for(int i=0;i<3;i++){
				for(int j=0;j<3;j++){
					a[i][j]=Integer.parseInt(d.readLine());
				}
			}

			int col1=0,col2=0,col3=0;

			for(int i=0;i<3;i++){
				int rowSum=0;
				for(int j=0;j<3;j++){
					System.out.print(a[i][j]+" ");
					rowSum=rowSum+a[i][j];
				}
				System.out.println("| "+rowSum);

				col1=col1+a[i][0];
				col2=col2+a[i][1];
				col3=col3+a[i][2];
			}

			System.out.println("---------");
			System.out.println(col1+" "+col2+" "+col3);
		}
		catch(Exception e){
			System.out.println("Error: "+e);
		}
	}
}
