import java.util.*;
class RethrowFinally {
    void divide(int a,int b) {
        try {
            int c=a/b;
            System.out.println("Result:"+c);
        }
        catch(ArithmeticException e) {
            System.out.println("Exception caught in divide()");
            throw e;        // re-throwing the exception
        }
        finally {
            System.out.println("Finally block in divide()");
        }
    }
}
class Pgm9RethrowFinally {
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        RethrowFinally obj=new RethrowFinally();
        System.out.print("Enter numerator:");
        int a=sc.nextInt();
        System.out.print("Enter denominator:");
        int b=sc.nextInt();
        try {
            obj.divide(a,b);
        }
        catch(ArithmeticException e) {
            System.out.println("Exception caught in main()");
        }
        finally {       // finally block 
            System.out.println("Finally block in main()");  
        }
    }
}
