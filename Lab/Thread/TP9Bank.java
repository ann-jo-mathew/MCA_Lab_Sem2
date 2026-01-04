import java.util.*;
class Bank{
    int bal=0;
    void deposit(int amt){
        bal=bal+amt;
        System.out.println("Deposited:"+amt+" Balance:"+bal);
    }
    void withdraw(int amt){
        bal=bal-amt;
        System.out.println("Withdrawn:"+amt+" Balance:"+bal);
    }
}
class DepositThread extends Thread{
    Bank b;
    int amt;
    DepositThread(Bank b,int amt){
        this.b=b;
        this.amt=amt;
    }
    public void run(){
        b.deposit(amt);
    }
}
class WithdrawThread extends Thread{
    Bank b;
    int amt;
    WithdrawThread(Bank b,int amt){
        this.b=b;
        this.amt=amt;
    }
    public void run(){
        b.withdraw(amt);
    }
}
class TP9Bank{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        Bank b=new Bank();
        System.out.print("Enter deposit amount:");
        int d=sc.nextInt();
        System.out.print("Enter withdraw amount:");
        int w=sc.nextInt();
        DepositThread t1=new DepositThread(b,d);
        WithdrawThread t2=new WithdrawThread(b,w);
        t1.start();
        t2.start();
    }
}
