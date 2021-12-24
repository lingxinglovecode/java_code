package com.lianxing.spring5.collectiontype;

/**
 * @author lianxing
 * @description
 * @create 2021-10-30 19:55
 */
public class Course {
    private String cname;

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                '}';
    }
}
