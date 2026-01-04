class SM{
    int data;
    boolean f=false;
    public synchronized void put(int a){
        try{
            if(f==true)
                wait();
            data=a;
            System.out.println("PUT:"+data);
            f=true;
            notify();
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }
    public synchronized void get(){
        try{
            if(f==false)
                wait();
            System.out.println("GET:"+data);
            f=false;
            notify();
        }
        catch(InterruptedException e){
            System.out.println(e);
        }
    }
}
class Producer extends Thread{
    SM q;
    public Producer(SM q){
        this.q=q;
    }
    public void run(){
        int i=0;
        while(true){
            q.put(i);
            i++;
        }
    }
}
class Consumer extends Thread{
    SM q;
    public Consumer(SM q){
        this.q=q;
    }
    public void run(){
        while(true){
            q.get();
        }
    }
}
class TP8ProCons{
    public static void main(String args[]){
        SM q=new SM();
        Producer p=new Producer(q);
        Consumer c=new Consumer(q);
        p.start();
        c.start();
    }
}