package java_learning;

/**
 * 1.创建一个继承于Tread类的子类
 * 2.重写run()方法 -→此线程执行的操作声明在run方法中
 * 3.创建子类对象
 * 4.调用start()方法
 * @author lianxing
 * @create 2021-09-02 15:32
 */

class MyTreade extends Thread{

    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println(i);
        }
    }
}



public class TreadTest {
    public static void main(String[] args) {
        //3.创建Thread类的子类对象
        MyTreade t1 = new MyTreade();

        //4.通过对象调用start方法 ，①启动当前线程 ②调用当前线程的run方法
        t1.start();

        //问题1：不能通过直接调用run()方式启动线程
//        t1.run();
        //问题2：不能让已经start()的线程去执行
//        t1.start();
        //需要重新创建一个对象
        MyTreade t2 = new MyTreade();
        t2.run();


        //如下操作在main线程中执行
        for (int i = 0; i < 5; i++) {
            System.out.println("---------------");

        }
    }

}
