import java.util.*;
class CString {
    String s;
    void read() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter string: ");
        s=sc.nextLine();
    }
    void display() {
        System.out.println(s);
    }
    boolean compare(CString c) {        // returns true/false
        return s.equals(c.s);
    }
    CString add(CString c) {            // "add" = string addition (concatenation)
        CString r=new CString();
        r.s=s+c.s;
        return r;
    }
    CString concatenate(CString c) {    // same as add but kept separate because question asked
        CString r=new CString();
        r.s=s+c.s;
        return r;
    }
}
public class StringPgm13{
    public static void main(String args[]) {
        CString c1=new CString();
        CString c2=new CString();
        System.out.println("Enter first string:");
        c1.read();
        System.out.println("Enter second string:");
        c2.read();
        boolean eq=c1.compare(c2);
        CString added=c1.add(c2);
        CString conc=c1.concatenate(c2);
        System.out.println("\nFirst string:");
        c1.display();
        System.out.println("Second string:");
        c2.display();
        System.out.println("\nStrings equal? "+eq);
        System.out.println("Added:");
        added.display();
        System.out.println("Concatenated:");
        conc.display();
    }
}
