package threadprac;

/**
 * @author lianxing
 * @create 2021-09-03 15:32
 */
public class Product {
    public static void main(String[] args) {
        Cleck cleck = new Cleck();

        Productor p1 = new Productor(cleck);
        Customer c1 = new Customer(cleck);

        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(c1);

        t1.start();
        t2.start();



    }





}




class Cleck  {
    private static int productNum=20;
    private final int MAXNUM=20;

    public int getProductNum() {
        return productNum;
    }

    public synchronized void  getProduct(){
        if(productNum<=0){

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        System.out.println("售出成功！消费者取走了第"+productNum+"个商品");
        productNum = productNum - 1;
        notifyAll();


//        System.out.println("目前没有足够产品了！");

    }

    public synchronized void addProduct(){
        if(productNum >= MAXNUM){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productNum =  productNum+1;
        System.out.println("进货成功！目前生产产品ID:"+productNum);
        notifyAll();

    }


}

class Productor implements Runnable{

    private Cleck cleck;

    public Productor(Cleck cleck) {
        this.cleck = cleck;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((int)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cleck.addProduct();
        }
    }
}

class Customer implements Runnable{
    private Cleck cleck;

    public Customer(Cleck cleck) {
        this.cleck = cleck;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep((int)Math.random()*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cleck.getProduct();
        }
    }
}
