package threadprac;

/**
 * @author lianxing
 * @create 2021-09-03 16:49
 */
public class Bank {
    public static void main(String[] args) {
        BankAccount account= new BankAccount("123123123",1000);
        BankPerson xiaoming = new BankPerson(account,100);


        Thread t1 = new Thread(xiaoming);
        Thread t2 = new Thread(xiaoming);

        t1.setName("小明");
        t2.setName("小明的老婆");

        t1.start();
        t2.start();


    }
}


class BankAccount{
    private String AccountId;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String accountId, double balance) {
        AccountId = accountId;
        this.balance = balance;
    }

    public String getAccountId() {
        return AccountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setAccountId(String accountId) {
        AccountId = accountId;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void withDraw(double money){

        this.balance = this.balance - money;

    }


}


class BankPerson implements Runnable{
    private BankAccount account;
    private double withdraw;

    public BankPerson(BankAccount account, double withdraw) {
        this.account = account;
        this.withdraw = withdraw;
    }

    @Override
    public void run() {
        while(true) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            withDrawMoney();
        }
    }

    public synchronized void withDrawMoney(){
        if (account.getBalance() < withdraw) {
            System.out.println("余额不足！目前账户余额：" + account.getBalance() + "小于" + withdraw);
        }
        else {
            System.out.println(Thread.currentThread().getName() + "取钱" + withdraw);
            account.withDraw(withdraw);}

    }


}

