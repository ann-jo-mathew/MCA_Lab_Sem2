class MyRunnable implements Runnable {
    public void run() {
        System.out.println("Runnable thread is running");
    }
}
class ThreadPgm2 {
    public static void main(String args[]) {
        Thread t=new Thread(new MyRunnable());
        t.start();
    }
}