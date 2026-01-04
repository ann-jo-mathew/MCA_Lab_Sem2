class RW {
    int readers=0;
    boolean writing=false;
    public synchronized void startRead(int id) {
        try {
            while(writing) {
                wait();
            }
            readers++;
            System.out.println("Reader "+id+" started reading");
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }
    public synchronized void endRead(int id) {
        readers--;
        System.out.println("Reader "+id+" finished reading");
        notifyAll();
    }
    public synchronized void startWrite(int id) {
        try {
            while(writing||readers>0) {
                wait();
            }
            writing=true;
            System.out.println("Writer "+id+" started writing");
        } catch(InterruptedException e) {
            System.out.println(e);
        }
    }
    public synchronized void endWrite(int id) {
        writing=false;
        System.out.println("Writer "+id+" finished writing");
        notifyAll();
    }
}
class Reader implements Runnable {
    RW q;
    int id;
    public Reader(RW q,int id) {
        this.q=q;
        this.id=id;
    }
    public void run() {
        while(true) {
            q.startRead(id);
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {}
            q.endRead(id);
        }
    }
}
class Writer implements Runnable {
    RW q;
    int id;
    public Writer(RW q,int id) {
        this.q=q;
        this.id=id;
    }
    public void run() {
        while(true) {
            q.startWrite(id);
            try {
                Thread.sleep(500);
            } catch(InterruptedException e) {}
            q.endWrite(id);
        }
    }
}
class TP8ReadWrite {
    public static void main(String args[]) {
        RW q=new RW();
        Reader r1=new Reader(q,1);
        Reader r2=new Reader(q,2);
        Writer w1=new Writer(q,1);
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        Thread t3=new Thread(w1);
        t1.start();
        t2.start();
        t3.start();
    }
}
