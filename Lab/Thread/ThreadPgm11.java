import java.util.*;
class Account {
    int balance=1000;
    synchronized void deposit(int amt) {
        balance+=amt;
        System.out.println("Deposited:"+amt+" Balance:"+balance);
    }
    synchronized void withdraw(int amt) {
        if(balance>=amt) {
            balance-=amt;
            System.out.println("Withdrew:"+amt+" Balance:"+balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}
class ATMThread extends Thread {
    Account acc;
    boolean deposit;
    int amt;
    ATMThread(Account acc, boolean deposit, int amt) {
        this.acc=acc;
        this.deposit=deposit;
        this.amt=amt;
    }
    public void run() {
        if(deposit) {
            acc.deposit(amt);
        } else {
            acc.withdraw(amt);
        }
    }
}
class ThreadPgm11 {
    public static void main(String args[]) {
        Account acc=new Account();
        ATMThread t1=new ATMThread(acc, true, 200);
        ATMThread t2=new ATMThread(acc, false, 100);
        ATMThread t3=new ATMThread(acc, true, 300);
        t1.start();
        t2.start();
        t3.start();
    }
}