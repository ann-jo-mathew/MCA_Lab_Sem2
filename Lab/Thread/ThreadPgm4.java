import java.util.*;
class SearchThread extends Thread {
    int[] arr;
    int start, end, key;
    boolean found=false;
    SearchThread(int[] arr, int start, int end, int key) {
        this.arr=arr;
        this.start=start;
        this.end=end;
        this.key=key;
    }
    public void run() {
        for(int i=start;i<end;i++) {
            if(arr[i]==key) {
                found=true;
                System.out.println("Found at index:"+i);
                break;
            }
        }
    }
}
class ThreadPgm4 {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter array size:");
        int n=sc.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter elements:");
        for(int i=0;i<n;i++) {
            arr[i]=sc.nextInt();
        }
        System.out.print("Enter key to search:");
        int key=sc.nextInt();
        int numThreads=n/5;
        if(numThreads==0) numThreads=1;
        int chunk=n/numThreads;
        SearchThread[] threads=new SearchThread[numThreads];
        for(int i=0;i<numThreads;i++) {
            int start=i*chunk;
            int end=(i==numThreads-1)?n:(i+1)*chunk;
            threads[i]=new SearchThread(arr, start, end, key);
            threads[i].start();
        }
        for(int i=0;i<numThreads;i++) {
            try {
                threads[i].join();
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}