package com.lianxing.spring5.aopannotation;

import org.springframework.stereotype.Component;

/**
 * @author lianxing
 * @description
 * @create 2021-11-14 18:18
 */
@Component
public class User {
    public void add() {
        System.out.println("add...");
    }
}
