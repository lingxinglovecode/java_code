package com.lianxing.spring5.aopannotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author lianxing
 * @description
 * @create 2021-11-14 18:18
 */
@Order(1)
@Component
@Aspect
public class UserProxy {


    @Pointcut(value = "execution(* com.lianxing.spring5.aopannotation.User.add())")
    public void pointdemo(){

    }



    //前置通知
    @Before(value = "pointdemo()")
    public  void before(){
        System.out.println("before....");
    }

    @After(value = "pointdemo()")
    public void after(){

        System.out.println("After");
    }

    @Around(value = "pointdemo()")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕之前...");
        proceedingJoinPoint.proceed();
        System.out.println("环绕之后...");

    }

    @AfterReturning(value = "pointdemo()")
    public void afterReturning(){
        System.out.println("AfterReturning");

    }


    @AfterThrowing(value = "pointdemo()")
    public void afterThrowing(){
        System.out.println("AfterThrowing");

    }

}
