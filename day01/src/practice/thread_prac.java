package practice;

/**
 * @author lianxing
 * @create 2021-09-02 18:58
 */
public class thread_prac {
    public static void main(String[] args) {
//        MyThreadEven evenThread = new MyThreadEven();
//        MyThreadOdd oddThread = new MyThreadOdd();
//
//        evenThread.setName("线程1");
//        oddThread.setName("线程2");
//        evenThread.start();

        Thread even2 = new Thread(new MyThreadEven2());
        Thread odd2 = new Thread(new MyThreadOdd2());

        even2.start();
        odd2.start();



    }


}


class MyThreadEven2 implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 ==0 ) {
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}


class MyThreadOdd2 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println( Thread.currentThread().getName()+":"+i);
            }
        }
    }
}



class MyThreadEven extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(currentThread().getName()+":"+i);
            }
        }
    }
}

class MyThreadOdd extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) {
                System.out.println(currentThread().getName()+":"+i);
            }
        }
    }
}



