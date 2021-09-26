package com.lianxing.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author lianxing
 * @description
 * @create 2021-09-25 15:38
 */
public class WebUtils {

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
}
