import java.util.*;
class MatrixAddMulti{
	public static void main(String args[]){
		int a[][],r1,c1,r2,c2,i,j,k;
		Scanner s;
		s=new Scanner(System.in);
		System.out.println("Enter the no. of r and c");
		r1=s.nextInt();
		c1=s.nextInt();
		a=new int[r1][c1];
		System.out.println("Enter elements of matrix A");
		for(i=0;i<r1;i++){
			for(j=0;j<c1;j++){
				System.out.println("Enter a["+i+"]["+j+"]");
				a[i][j]=s.nextInt();
			}
		}
		System.out.print("Enter the no. of r and c of B:");
		r2=s.nextInt();
		c2=s.nextInt();
		System.out.println("Enter elements of matrix B");
		int b[][]=new int[r2][c2];
		for(i=0;i<r2;i++){
			for(j=0;j<c2;j++){
				System.out.print("Enter b["+i+"]["+j+"]");
				b[i][j]=s.nextInt();
			}
		}
        if(r1==r2 && c1==c2){
            System.out.println("Sum of Matrices:");
            int sum[][]=new int[r1][c1];
            for(i=0;i<r1;i++){
                for(j=0;j<c1;j++){
                    sum[i][j]=a[i][j]+b[i][j];
                }
            }
            for(i=0;i<r1;i++){
                for(j=0;j<c1;j++){
                    System.out.print(sum[i][j]+"\t");
                }
                System.out.println("");
            }
        }
        else{
            System.out.println("Addition not possible");
        }
		if(r2==c1){
            int r[][]=new int[r1][c2];	
            for(i=0;i<r1;i++){
                for(j=0;j<c2;j++){
                    r[i][j]=0;
                }
            }
			for(i=0;i<r1;i++){
				for(j=0;j<c2;j++){
					for(k=0;k<c1;k++)
						r[i][j]=r[i][j]+a[i][k]*b[k][j];
				}
			}
            System.out.println("Product of Matrices:");
			for(i=0;i<r1;i++){
				for(j=0;j<c2;j++){
					System.out.print(r[i][j]+"\t");
				}
				System.out.println("");
			}
		}
	    else
		    System.out.println("Multiplication not possible");
	}
}