import java.util.*;
class RWLock {
    int readers=0;
    boolean writing=false;
    synchronized void readLock() {
        while(writing) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
        readers++;
    }
    synchronized void readUnlock() {
        readers--;
        if(readers==0) notifyAll();
    }
    synchronized void writeLock() {
        while(writing || readers>0) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
        writing=true;
    }
    synchronized void writeUnlock() {
        writing=false;
        notifyAll();
    }
}
class Reader extends Thread {
    RWLock lock;
    Reader(RWLock lock) {
        this.lock=lock;
    }
    public void run() {
        lock.readLock();
        System.out.println("Reading");
        try {
            Thread.sleep(100);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
        lock.readUnlock();
    }
}
class Writer extends Thread {
    RWLock lock;
    Writer(RWLock lock) {
        this.lock=lock;
    }
    public void run() {
        lock.writeLock();
        System.out.println("Writing");
        try {
            Thread.sleep(100);
        } catch(InterruptedException e) {
            System.out.println(e);
        }
        lock.writeUnlock();
    }
}
class ThreadPgm8b {
    public static void main(String args[]) {
        RWLock lock=new RWLock();
        Reader r1=new Reader(lock);
        Reader r2=new Reader(lock);
        Writer w=new Writer(lock);
        r1.start();
        r2.start();
        w.start();
    }
}