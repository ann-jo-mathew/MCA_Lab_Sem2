import java.util.*;
class Buffer {
    int item;
    boolean produced=false;
    synchronized void produce(int item) {
        while(produced) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
        this.item=item;
        System.out.println("Produced:"+item);
        produced=true;
        notify();
    }
    synchronized int consume() {
        while(!produced) {
            try {
                wait();
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
        System.out.println("Consumed:"+item);
        produced=false;
        notify();
        return item;
    }
}
class Producer extends Thread {
    Buffer b;
    Producer(Buffer b) {
        this.b=b;
    }
    public void run() {
        for(int i=0;i<5;i++) {
            b.produce(i);
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
class Consumer extends Thread {
    Buffer b;
    Consumer(Buffer b) {
        this.b=b;
    }
    public void run() {
        for(int i=0;i<5;i++) {
            b.consume();
            try {
                Thread.sleep(150);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
class ThreadPgm8a {
    public static void main(String args[]) {
        Buffer b=new Buffer();
        Producer p=new Producer(b);
        Consumer c=new Consumer(b);
        p.start();
        c.start();
    }
}