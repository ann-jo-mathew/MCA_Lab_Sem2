import java.util.*;
class OddThread extends Thread {
    int n;
    OddThread(int n) {
        this.n=n;
    }
    public void run() {
        for(int i=1;i<=n;i+=2) {
            System.out.println("Odd:"+i);
        }
    }
}
class EvenThread extends Thread {
    int n;
    EvenThread(int n) {
        this.n=n;
    }
    public void run() {
        for(int i=2;i<=n;i+=2) {
            System.out.println("Even:"+i);
        }
    }
}
class ThreadPgm3 {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter N:");
        int n=sc.nextInt();
        OddThread ot=new OddThread(n);
        EvenThread et=new EvenThread(n);
        ot.start();
        et.start();
    }
}