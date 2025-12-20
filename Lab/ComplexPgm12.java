import java.util.*;

class Complex {
    int r,i;
    void read() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter real part: ");
        r=sc.nextInt();
        System.out.print("Enter imaginary part: ");
        i=sc.nextInt();
    }
    void display() {
        if(i>=0)
            System.out.println(r+"+"+i+"i");
        else
            System.out.println(r+"-"+(-i)+"i");
    }
    Complex add(Complex c) {
        Complex obj=new Complex();
        obj.r=r+c.r;
        obj.i=i+c.i;
        return obj;
    }
    Complex multiply(Complex c) {
        Complex obj=new Complex();
        obj.r=(r*c.r)-(i*c.i);
        obj.i=(r*c.i)+(i*c.r);
        return obj;
    }
}
public class ComplexPgm12{
    public static void main(String args[]) {
        Complex c1=new Complex();
        Complex c2=new Complex();
        System.out.println("Enter first complex number:");
        c1.read();
        System.out.println("Enter second complex number:");
        c2.read();
        Complex sum=c1.add(c2);
        Complex product=c1.multiply(c2);
        System.out.println("\nFirst number:");
        c1.display();
        System.out.println("Second number:");
        c2.display();
        System.out.println("\nSum:");
        sum.display();
        System.out.println("Product:");
        product.display();
    }
}
