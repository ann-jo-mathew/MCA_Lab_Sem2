class CIThread implements Runnable {
    int n;
    public CIThread(int a) {
        n=a;
    }
    public void run() {
        int i;
        for(i=1;i<=n;i++) {
            System.out.println("i="+i+"\t");
        }
    }
}
class TP2RunnableImp{
    public static void main(String args[]) {
        CIThread p,q;
        p=new CIThread(200);
        q=new CIThread(250);
        Thread t1,t2;
        t1=new Thread(p);
        t2=new Thread(q);
        System.out.println("Before Thread");
        t1.start();
        System.out.println("Between Thread");
        t2.start();
        System.out.println("Finished");
    }
}