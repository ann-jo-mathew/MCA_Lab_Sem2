import java.io.*;
import java.util.*;
class Puzzle{
int a[][],i,j,m,mr,mc,zr,zc;		//size is 4x4
	void checkMove(){
		int c=0;
		//a=new int[][]{1,2,3,4,5,6,7,8,9,10,11,0,13,14,15,12};
		a=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,0,15}};
		System.out.println("Solve the puzzle");
		display(c);
		Scanner sc=new Scanner(System.in);
		while(true){
			System.out.println();
			System.out.print("Enter the value that you want to Move: ");
			m=sc.nextInt();
			if(m<0 || m>15){
				System.out.println("Invalid Input");
				continue;
			}
			for(i=0;i<4;i++){
				for(j=0;j<4;j++){
					if(a[i][j]==m){
						mr=i;
						mc=j;
					}
					if(a[i][j]==0){
						zr=i;
						zc=j;
					}
				}
			}
			if((zr==mr)&&(zc==mc-1||zc==mc+1))	{
				swap(zr,zc,mr,mc);
			}
			else if((zr==mr-1||zr==mr+1)&&(zc==mc)){
				swap(zr,zc,mr,mc);
			}
			else{
				System.out.println("Invalid Move");
				continue;
			}
			c++;
			display(c);
			if(checkWin()){
				System.exit(0);
			}
		}		
	}
	boolean checkWin(){
		int fin[][]=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,0}};
		int f=0;
		for(i=0;i<4;i++){
			for(j=0;j<4;j++){
				if(a[i][j]!=fin[i][j]){
					f++;
				}
			}
		}
		if(f>0){
			return false;
		}
		else{
			System.out.println("Congratulations! You have solved the puzzle.");
			return true;
		}
	}
	void swap(int i,int j,int m,int n){
		int temp=a[i][j];
		a[i][j]=a[m][n];
		a[m][n]=temp;
	}
	void display(int c){
		for(i=0;i<4;i++){
			for(j=0;j<4;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Number of moves: "+c);
	}
}
public class PuzzlePgm9{
	public static void main(String args[]){
		Puzzle p=new Puzzle();
		p.checkMove();
	}
}