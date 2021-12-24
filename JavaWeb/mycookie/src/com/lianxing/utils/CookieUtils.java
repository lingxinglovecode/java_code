package com.lianxing.utils;

import javax.servlet.http.Cookie;

/**
 * @author lianxing
 * @description
 * @create 2021-10-21 18:34
 */
public class CookieUtils {

    /**
     * @Description: 查看指定名称的cookie对象
     * @param: name
     * @param: cookies
     * @return javax.servlet.http.Cookie
     * @author lianxing
     * @date 2021/10/22 14:16
    */
    public static Cookie findCookie(String name,Cookie[] cookies){
        if(name==null || cookies==null || cookies.length==0){return null;}

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName()) ){
                return cookie;
            }
        }
        return null;

    }
}
