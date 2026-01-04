import java.util.*;
class Pgm7MultiCatch{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        try {
            System.out.print("Enter first number:");
            int a=sc.nextInt();
            System.out.print("Enter second number:");
            int b=sc.nextInt();
            int c=a/b;
            System.out.println("Result:"+c);
        } 
        catch(ArithmeticException e) {
            System.out.println("Arithmetic Exception:"+e);
        } 
        catch(InputMismatchException e) {
            System.out.println("Input Mismatch Exception:"+e);
        } 
        catch(Exception e) {
            System.out.println("General Exception:"+e);
        }
    }
}