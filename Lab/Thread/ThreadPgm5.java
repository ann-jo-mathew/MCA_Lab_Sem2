import java.util.*;
class SquareThread extends Thread {
    int num;
    SquareThread(int num) {
        this.num=num;
    }
    public void run() {
        System.out.println("Square:"+ (num*num));
    }
}
class CubeThread extends Thread {
    int num;
    CubeThread(int num) {
        this.num=num;
    }
    public void run() {
        System.out.println("Cube:"+ (num*num*num));
    }
}
class ThreadPgm5 {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number:");
        int num=sc.nextInt();
        SquareThread st=new SquareThread(num);
        CubeThread ct=new CubeThread(num);
        st.start();
        ct.start();
    }
}