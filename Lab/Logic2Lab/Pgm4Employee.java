import java.util.*;
class Employee {
    int eno;
    String ename;
    double esal;
    void read() {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Employee Number: ");
        eno=sc.nextInt();
        sc.nextLine();   // consume newline
        System.out.print("Enter Employee Name: ");
        ename=sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        esal=sc.nextDouble();
    }
    void display() {
        System.out.println("Employee Number:"+eno);
        System.out.println("Employee Name:"+ename);
        System.out.println("Employee Salary:"+esal);
    }
    boolean compareEno(int no) {
        if(eno==no)
            return true;
        else
            return false;
    }
}
class Pgm4Employee{
    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter total number of employees: ");
        int n=sc.nextInt();
        Employee e[]=new Employee[n];   //array of objects(only an array created of employee data type)
        for(int i=0;i<n;i++) {
            e[i]=new Employee();    //object creation
            System.out.println("\nEnter details of employee "+(i+1));
            e[i].read();
        }
        System.out.println("\nEmployee Details:");
        for(int i=0;i<n;i++) {
            e[i].display();
            System.out.println();
        }
        System.out.print("Enter employee number to search: ");
        int s=sc.nextInt();
        boolean found=false;
        for(int i=0;i<n;i++) {
            if(e[i].compareEno(s)==true) {
                System.out.println("\nEmployee Found:");
                e[i].display();
                found=true;
                break;
            }
        }
        if(found==false) {
            System.out.println("\nEmployee with number "+s+" not found.");
        }
    }
}