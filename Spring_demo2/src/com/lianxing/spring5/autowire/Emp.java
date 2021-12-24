package com.lianxing.spring5.autowire;

/**
 * @author lianxing
 * @description
 * @create 2021-10-30 21:48
 */
public class Emp {
    private Dept dept;

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "dept=" + dept +
                '}';
    }
}
