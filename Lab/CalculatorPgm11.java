import java.util.*;
class Calculator {
    int add(int a, int b) {     // Addition
        return a + b;
    }
    int subtract(int a, int b) {        // Subtraction
        return a - b;
    }
    int multiply(int a, int b) {        // Multiplication
        return a * b;
    }
    float divide(int a, int b) {        // Division 
        if(b == 0) {
            System.out.println("Cannot divide by zero.");
            return 0;
        }
        return (float)a / b;
    }
}
public class CalculatorPgm11{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Calculator c = new Calculator();
        System.out.print("Enter first number: ");
        int n1 = sc.nextInt();
        System.out.print("Enter second number: ");
        int n2 = sc.nextInt();
        System.out.println("Addition: " + c.add(n1, n2));
        System.out.println("Subtraction: " + c.subtract(n1, n2));
        System.out.println("Multiplication: " + c.multiply(n1, n2));
        System.out.println("Division: " + c.divide(n1, n2));
    }
}
