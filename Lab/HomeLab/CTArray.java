import java.util.*;
class CTArray{
	public static void main(String args[]){
		int a[][],r,c,i,j;
		Scanner s;
		s=new Scanner(System.in);
		System.out.println("Enter the no. of r and c");
		r=s.nextInt();
		c=s.nextInt();
		a=new int[r][c];
		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				System.out.println("Enter a["+i+"]["+j+"]");
				a[i][j]=s.nextInt();
			}
		}
		for(i=0;i<r;i++){
			for(j=0;j<c;j++){
				System.out.print(a[i][j]+"\t");
			}
			System.out.println("");
		}
	}
}