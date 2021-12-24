package com.lianxing.spring5.Bean;

/**
 * @author lianxing
 * @description
 * @create 2021-10-30 20:43
 */
public class Orders {
    private String oname;

    public void setOname(String oname) {
        System.out.println("第二部 调用set方法设置属性值");
        this.oname = oname;
    }

    public Orders() {

        System.out.println("第一步 执行了无参数构造器");

    }

    //创建执行的初始化方法
    public void initMethod(){
        System.out.println("第三步 执行初始化方法");
    }

    //销毁的时候执行的方法
    public void destroyMethod(){
        System.out.println("第五步 调用销毁方法");
    }

}
