class CPrintPbm{
    public void print(String s){
        System.out.println("Printing...[");
        System.out.println(s);
        System.out.println("]");
    }
}
class PrintThreadPbm extends Thread{
    CPrintPbm p;
    String str;
    public PrintThreadPbm(CPrintPbm p,String s){
        this.p=p;
        str=s;
    }
    public void run(){
            p.print(str);
    }
}
class TP6PrinterPbm{
    public static void main(String args[]){
        CPrintPbm p=new CPrintPbm();
        PrintThreadPbm t1,t2,t3;
        t1=new PrintThreadPbm(p,"Hello");
        t2=new PrintThreadPbm(p,"World");
        t3=new PrintThreadPbm(p,"Good");
        t1.start();
        t2.start();
        t3.start();
    }
}