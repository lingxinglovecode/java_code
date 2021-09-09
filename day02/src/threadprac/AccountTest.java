package threadprac;

/**
 * @author lianxing
 * @create 2021-09-02 22:13
 */
public class AccountTest {
    public static void main(String[] args) {
        Account accountOne = new Account(0);
        Person Man = new Person(accountOne);
//        Person twoMan = new Person(accountOne);

        new Thread(Man).start();
        new Thread(Man).start();




    }


}


class Account{
    private int balance;

    public Account(int balance) {
        this.balance = balance;
    }

    public synchronized void addMoney(int money){
        this.balance = money+this.balance;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"目前余额："+this.balance);
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }
}

class Person implements Runnable{
    private  Account account;

    public Person(Account account) {
        this.account = account;
    }

    public void addMoney(int money){
        account.addMoney(money);
    }


    @Override
    public  void run() {
        for (int i = 0; i < 10; i++) {
            addMoney(1000);
//            System.out.println(Thread.currentThread().getName()+ "账户余额："+account.getBalance());
        }
    }
}

