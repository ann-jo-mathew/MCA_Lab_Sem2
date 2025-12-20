import java.util.*;
class Recursion{
    public void printDesc(int n) {     // Print from n to 1
        if(n==0) return;
        System.out.print(n+" ");
        printDesc(n-1);
    }
    public void printAsc(int n) {          // Print from 1 to n
        if(n==0) return;
        printAsc(n-1);
        System.out.print(n+" ");
    }  
}
class RecursivePgm10{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        Recursion obj = new Recursion();
        System.out.println("Descending (n to 1):");
        obj.printDesc(n);
        System.out.println("\nAscending (1 to n):");
        obj.printAsc(n);
    }
}
