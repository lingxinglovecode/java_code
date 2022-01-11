public class Singleton {



}

//单例模式


//1.懒汉式（线程不安全），在需要的时候创建，线程不安全
class Singleton_1{
    private static Singleton_1 instance;
    private Singleton_1(){

    }
    public static Singleton_1 getInstance(){
        if (instance==null){
            instance = new Singleton_1();
        }
        return instance;
    }

}


//2.懒汉式（线程安全），只需要在方法上加上synchronized关键字
class Singleton_2{
    private static Singleton_2 instance;
    private Singleton_2(){

    }
    public static synchronized Singleton_2 getInstance(){
        if (instance==null){
            instance = new Singleton_2();
        }
        return instance;
    }

}

//3.饿汉式，在类初始化阶段就创建一个实例对象
class Singleton_3{
    private static Singleton_3 instance = new Singleton_3();
    private Singleton_3(){}
    public static Singleton_3 getInstance(){
        return instance;
    }

}
//4.双重检查锁，在线程安全的懒汉式基础上进行改进
class Singleton_4{
    private static volatile Singleton_4 instance;
    private Singleton_4(){};
    public Singleton_4 getInstance(){
        if (instance==null){
            synchronized (Singleton_4.class){
                if (instance==null){
                    instance = new Singleton_4();
                }
            }
        }
        return instance;
    }
}

//5.静态内部类实现
class Singleton_5{
    private Singleton_5(){};
    private static class SingletonHolder{
        private static final Singleton_5 INSTANCE = new Singleton_5();
    }
    public static Singleton_5 getInstance(){
        return SingletonHolder.INSTANCE;
    }


}



