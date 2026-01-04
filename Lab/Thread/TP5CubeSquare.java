import java.util.*;
class SquareThread extends Thread{
    int n;
    SquareThread(int n){
        this.n=n;
    }
    public void run(){
        System.out.println("Square: "+(n*n));
    }
}
class CubeThread extends Thread{
    int n;
    CubeThread(int n){
        this.n=n;
    }
    public void run(){
        System.out.println("Cube: "+(n*n*n));
    }
}
class TP5CubeSquare{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n=sc.nextInt();
        SquareThread t1=new SquareThread(n);
        CubeThread t2=new CubeThread(n);
        t1.start();
        t2.start();
    }
}

//same as OddEven.java