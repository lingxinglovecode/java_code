package com.lianxing.spring5.bean;

/**
 * @author lianxing
 * @description
 * @create 2021-10-30 16:01
 */
public class Dept {
    private String dname;

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getDname() {
        return dname;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "dname='" + dname + '\'' +
                '}';
    }
}
