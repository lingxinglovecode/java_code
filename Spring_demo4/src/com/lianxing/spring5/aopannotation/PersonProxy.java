package com.lianxing.spring5.aopannotation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lianxing
 * @description
 * @create 2021-11-20 16:20
 */
@Order(1)
@Component
@Aspect
public class PersonProxy {

    @Pointcut(value = "execution(* com.lianxing.spring5.aopannotation.User.add())")
    public void pointdemo(){

    }

    @Before(value="pointdemo()")
    public void  before(){
        System.out.println("Person before");
    }

}
