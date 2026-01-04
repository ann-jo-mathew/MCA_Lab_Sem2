import java.util.*;
class Account {
    int balance=1000;
    void deposit(int amt) {
        balance+=amt;
        System.out.println("Deposited:"+amt+" Balance:"+balance);
    }
    void withdraw(int amt) {
        if(balance>=amt) {
            balance-=amt;
            System.out.println("Withdrew:"+amt+" Balance:"+balance);
        } else {
            System.out.println("Insufficient balance");
        }
    }
}
class DepositThread extends Thread {
    Account acc;
    DepositThread(Account acc) {
        this.acc=acc;
    }
    public void run() {
        for(int i=0;i<5;i++) {
            acc.deposit(100);
            try {
                Thread.sleep(50);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
class WithdrawThread extends Thread {
    Account acc;
    WithdrawThread(Account acc) {
        this.acc=acc;
    }
    public void run() {
        for(int i=0;i<5;i++) {
            acc.withdraw(50);
            try {
                Thread.sleep(50);
            } catch(InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}
class ThreadPgm9 {
    public static void main(String args[]) {
        Account acc=new Account();
        DepositThread dt=new DepositThread(acc);
        WithdrawThread wt=new WithdrawThread(acc);
        dt.start();
        wt.start();
    }
}