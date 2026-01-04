class PThread extends Thread{
    String name;
    PThread(String n){
        name=n;
    }
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println(name+" running");
        }
    }
}
class TP10Priority{
    public static void main(String args[]){
        PThread t1=new PThread("Low Priority Thread");
        PThread t2=new PThread("Medium Priority Thread");
        PThread t3=new PThread("High Priority Thread");
        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
    }
}
