package com.lianxing.spring5;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @author lianxing
 * @description
 * @create 2021-10-31 12:07
 */
public class JDKProxy {

    public static void main(String[] args) {
        Class[] interfaces = {UserDao.class};
//        Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });
        UserDaoImpl userDao = new UserDaoImpl();
        UserDao instance = (UserDao) Proxy.newProxyInstance(JDKProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));
        int add = instance.add(1, 2);
        System.out.println(add);
    }

}
class UserDaoProxy implements InvocationHandler{
    private Object obj;

    //将代理对象传递过来
    public UserDaoProxy(Object obj){
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法之前
        System.out.println("方法之前执行..."+method.getName()+":传递的参数"+ Arrays.toString(args));

        Object res = method.invoke(obj, args);

        //方法之后
        System.out.println("方法之后执行...");


        return res;
    }
}