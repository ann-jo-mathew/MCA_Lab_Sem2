import java.util.*;
class Employee {
    int eno;
    String ename;
    double esal;
    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Number: ");
        eno = sc.nextInt();
        sc.nextLine();   // consume newline
        System.out.print("Enter Employee Name: ");
        ename = sc.nextLine();
        System.out.print("Enter Employee Salary: ");
        esal = sc.nextDouble();
    }
    void display() {
        System.out.println("Employee Number: " + eno);
        System.out.println("Employee Name  : " + ename);
        System.out.println("Employee Salary: " + esal);
    }
    boolean compareEno(int no) {
        return eno == no;
    }
}
class Pgm4Employee{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        Employee e[] = new Employee[n];
        for (int i = 0; i < n; i++) {
            e[i] = new Employee();
            System.out.println("\nEnter details of employee " + (i + 1));
            e[i].read();
        }
        System.out.println("\nEmployee Details:");
        for (int i = 0; i < n; i++) {
            e[i].display();
            System.out.println();
        }
        System.out.print("Enter employee number to search: ");
        int searchNo = sc.nextInt();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (e[i].compareEno(searchNo)) {
                System.out.println("\nEmployee Found:");
                e[i].display();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nEmployee with number " + searchNo + " not found.");
        }
    }
}