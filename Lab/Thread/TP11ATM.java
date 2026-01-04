class Account{
    int balance=0;
    public synchronized void deposit(int amt){
        System.out.println(Thread.currentThread().getName()+" depositing "+amt);
        balance=balance+amt;
        System.out.println("Balance:"+balance);
    }
    public synchronized void withdraw(int amt){
        System.out.println(Thread.currentThread().getName()+" withdrawing "+amt);
        if(balance>=amt){
            balance=balance-amt;
            System.out.println("Balance:"+balance);
        }
        else{
            System.out.println("Insufficient balance");
        }
    }
}
class ATMUser extends Thread{
    Account a;
    int amt;
    String type;
    ATMUser(Account a,int amt,String type,String name){
        this.a=a;
        this.amt=amt;
        this.type=type;
        setName(name);
    }
    public void run(){
        if(type.equals("deposit"))
            a.deposit(amt);
        else
            a.withdraw(amt);
    }
}
class TP11ATM{
    public static void main(String args[]){
        Account a=new Account();
        ATMUser u1=new ATMUser(a,1000,"deposit","User1");
        ATMUser u2=new ATMUser(a,500,"withdraw","User2");
        ATMUser u3=new ATMUser(a,700,"withdraw","User3");
        u1.start();
        u2.start();
        u3.start();
    }
}
