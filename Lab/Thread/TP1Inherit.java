class CThread extends Thread {
    int n;
    public CThread(int a) {
        n=a;
    }
    public void run() {
        int i;
        for(i=1;i<=n;i++) {
            System.out.println("i="+i+"\t");
        }
    }
}
class TP1Inherit{
    public static void main(String args[]) {
        CThread t1,t2;
        t1=new CThread(200);
        t2=new CThread(250);
        System.out.println("Be for Thread");
        t1.start();
        System.out.println("Between Thread");
        t2.start();
        System.out.println("Finished");
    }
}