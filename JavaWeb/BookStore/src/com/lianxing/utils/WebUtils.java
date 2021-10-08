package com.lianxing.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author lianxing
 * @description
 * @create 2021-09-25 15:38
 */
public class WebUtils {
    @Test
    public void test1(){


        ArrayList a1 = new ArrayList();
        a1.add(2);
        System.out.println(a1);
    }

    /**
     * @Description: 把map中的值注入到javaBean中
     * @param: value
     * @param: bean
     * @return void
     * @author lianxing
     * @date 2021/9/25 15:49
    */
    public  static <T> T copyParamToBean(Map value, T bean){
        try {
            BeanUtils.populate(bean,value);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;

    }
    /***
     * @Description: 字符串转换成int型
     * @param: strInt
     * @param: defaultValue
     * @return int
     * @author lianxing
     * @date 2021/10/1 16:35
    */
    public static int parseInt(String strInt,int defaultValue){
        try {
            return Integer.parseInt(strInt);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return defaultValue;


    }

}
