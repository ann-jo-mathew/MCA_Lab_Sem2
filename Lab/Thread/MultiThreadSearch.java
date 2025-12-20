import java.util.Scanner;

class SearchThread extends Thread {
    int[] a;
    int start, end, key;
    static boolean found = false;

    SearchThread(int[] a, int start, int end, int key) {
        this.a = a;
        this.start = start;
        this.end = end;
        this.key = key;
    }

    public void run() {
        for (int i = start; i < end; i++) {
            if (!found && a[i] == key) {
                found = true;
                System.out.println("Element found at index " + i);
            }
        }
    }
}

public class MultiThreadSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int t = n / 5;
        if (t == 0) t = 1;

        int size = n / t;
        int s = 0;

        for (int i = 0; i < t; i++) {
            int e = (i == t - 1) ? n : s + size;
            new SearchThread(a, s, e, key).start();
            s = e;
        }
    }
}
