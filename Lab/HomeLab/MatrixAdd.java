import java.util.*;
class MatrixAdd{
	public static void main(String args[]){
		int a[][],r,c,i,j;
		Scanner s;
		s=new Scanner(System.in);
		System.out.println("Enter the no. of r and c");
		r=s.nextInt();
		c=s.nextInt();
		a=new int[r][c];
		System.out.println("Enter elements of matrix A");
		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				System.out.println("Enter a["+i+"]["+j+"]");
				a[i][j]=s.nextInt();
			}
		}
		System.out.println("Enter elements of matrix B");
		int b[][]=new int[r][c];
		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				System.out.println("Enter b["+i+"]["+j+"]");
				b[i][j]=s.nextInt();
			}
		}
		int sum[][]=new int[r][c];
		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				sum[i][j]=a[i][j]+b[i][j];
			}
		}
		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				System.out.print(sum[i][j]+"\t");
			}
			System.out.println("");
		}
	}
}