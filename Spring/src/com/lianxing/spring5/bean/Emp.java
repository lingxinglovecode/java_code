package com.lianxing.spring5.bean;

/**
 * @author lianxing
 * @description
 * @create 2021-10-30 16:02
 */
public class Emp {
    private String ename;
    private String gender;
    private Dept dept;

    public String getEname() {
        return ename;
    }

    public String getGender() {
        return gender;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", gender='" + gender + '\'' +
                ", dept=" + dept +
                '}';
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
