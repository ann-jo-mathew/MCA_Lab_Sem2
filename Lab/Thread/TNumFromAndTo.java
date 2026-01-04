class CNThread implements Runnable {
    int f,t;
    public CNThread(int f,int t) {
        this.f=f;
        this.t=t;
    }
    public void run() {
        while(f!=t){
            System.out.println(f+"\t");
            if(f<t)
                f++;
            else
                f--;
        }
        System.out.println(f+"\t");
    }
}
class TNumFromAndTo{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter from value :");
        int f=sc.nextInt();
        System.out.print("Enter to value:");
        int t=sc.nextInt();
        CNThread p=new CNThread(f,t);
        CNThread q=new CNThread(t,f);
        Thread t1=new Thread(p);
        Thread t2=new Thread(q);
        t1.start();
        t2.start();
    }
}