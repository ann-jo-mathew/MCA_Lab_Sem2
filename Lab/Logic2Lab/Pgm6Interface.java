import java.util.*;
interface IShape {
    void draw();
    void mov();
}
class Circle implements IShape {
    public void draw() {
        System.out.println("Drawing Circle");
    }
    public void mov() {
        System.out.println("Moving Circle");
    }
}
class Rectangle implements IShape {
    public void draw() {
        System.out.println("Drawing Rectangle");
    }
    public void mov() {
        System.out.println("Moving Rectangle");
    }
}
class Pgm6Interface{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        IShape obj;
        System.out.print("1 - Circle \n2 - Rectangle\nEnter choice: ");
        int ch=sc.nextInt();
        if(ch==1) {
            obj=new Circle();
        } 
        else if(ch==2) {
            obj=new Rectangle();
        }
        else {
            System.out.println("Invalid choice");
            return;
        }
        obj.draw();
        obj.mov();
    }
}