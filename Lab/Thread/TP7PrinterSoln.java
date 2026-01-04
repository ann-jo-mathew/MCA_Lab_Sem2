class CPrint{
    public synchronized void print(String s){
        System.out.println("Printing...[");
        System.out.println(s);
        System.out.println("]");
    }
}
class PrintThread extends Thread{
    CPrint p;
    String str;
    public PrintThread(CPrint p,String s){
        this.p=p;
        str=s;
    }
    public void run(){
            p.print(str);
    }
}
class TP7PrinterSoln{
    public static void main(String args[]){
        CPrint p=new CPrint();
        PrintThread t1,t2,t3;
        t1=new PrintThread(p,"Hello");
        t2=new PrintThread(p,"World");
        t3=new PrintThread(p,"Good");
        t1.start();
        t2.start();
        t3.start();
    }
}