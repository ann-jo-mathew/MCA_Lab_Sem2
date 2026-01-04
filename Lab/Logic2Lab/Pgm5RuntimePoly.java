import java.util.*;
interface Shape {
    void disp();
}
class Circle implements Shape {
    public void disp() {
        System.out.println("Circle");
    }
}
class Rectangle implements Shape {
    public void disp() {
        System.out.println("Rectangle");
    }
}
class Pgm5RuntimePoly{
    public static void main(String args[]) {
        Shape s1=new Circle();
        s1.disp();
        Shape s2=new Rectangle();
        s2.disp();
    }
}