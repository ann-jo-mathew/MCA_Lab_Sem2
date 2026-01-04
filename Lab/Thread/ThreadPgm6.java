import java.util.*;
class PrinterQueue {
    LinkedList<String> queue=new LinkedList<>();
    void addJob(String job) {
        queue.add(job);
    }
    void printJob() {
        if(!queue.isEmpty()) {
            System.out.println("Printing:"+queue.removeFirst());
        }
    }
}
class ProducerThread extends Thread {
    PrinterQueue pq;
    ProducerThread(PrinterQueue pq) {
        this.pq=pq;
    }
    public void run() {
        for(int i=0;i<5;i++) {
            pq.addJob("Job"+i);
            try {
                Thread.sleep(100);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
class ConsumerThread extends Thread {
    PrinterQueue pq;
    ConsumerThread(PrinterQueue pq) {
        this.pq=pq;
    }
    public void run() {
        for(int i=0;i<5;i++) {
            pq.printJob();
            try {
                Thread.sleep(150);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
class ThreadPgm6 {
    public static void main(String args[]) {
        PrinterQueue pq=new PrinterQueue();
        ProducerThread pt=new ProducerThread(pq);
        ConsumerThread ct=new ConsumerThread(pq);
        pt.start();
        ct.start();
    }
}