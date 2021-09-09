package Practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lianxing
 * @create 2021-09-08 19:26
 */
public class ProxyTest {
}




interface Human{

    String getBelief();

    void eat();


}




class superMan implements Human{
    int age;
    String name;

    public String getBelief(){

        return "I can fly";
    }

    @Override
    public void eat() {
        System.out.println("I like coke");
    }

}

class procyFactory {

    public Object getProxyInstance(Object o){
            myInvocationHandler ih = new myInvocationHandler();
            ih.bind(o);
        return Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces(),ih);

    }


}


class myInvocationHandler implements InvocationHandler{

    private Object obj;

    public void bind(Object obj){
        this.obj = obj;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object returnValue = method.invoke(obj,args);

        return returnValue;
    }
}


