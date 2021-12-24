package com.lianxing.i18n;

import org.junit.Test;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author lianxing
 * @description
 * @create 2021-10-28 16:16
 */
public class i18nTest {
    @Test
    public void testLocale(){
        Locale aDefault = Locale.getDefault();
//        System.out.println(aDefault);

        System.out.println(Locale.CHINA);
        System.out.println(Locale.US);
    }

    @Test
    public void testI18n(){
//        Locale locale = Locale.US;
        Locale locale = Locale.CHINA;

        ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);

        System.out.println("username="+bundle.getString("username"));
        System.out.println("password="+ bundle.getString("password"));
        System.out.println("sex="+bundle.getString("sex"));
        System.out.println("age="+bundle.getString("age"));



    }
}
