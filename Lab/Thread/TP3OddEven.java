import java.util.*;
class NumThread implements Runnable{
    int n;
    String type;
    NumThread(int n,String type){
        this.n=n;
        this.type=type;
    }
    public void run(){
        if(type.equals("Odd")){
            for(int i=1;i<=n;i+=2)
                System.out.println("Odd: "+i);
        }
        else if(type.equals("Even")){
            for(int i=2;i<=n;i+=2)
                System.out.println("Even: "+i);
        }
    }
}
class TP3OddEven{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter N:");
        int n=sc.nextInt();
        NumThread o=new NumThread(n,"Odd");
        NumThread e=new NumThread(n,"Even");
        Thread t1=new Thread(o);
        Thread t2=new Thread(e);
        t1.start();
        t2.start();
    }
}
