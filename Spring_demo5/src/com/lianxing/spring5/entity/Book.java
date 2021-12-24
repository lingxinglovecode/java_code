package com.lianxing.spring5.entity;

/**
 * @author lianxing
 * @description
 * @create 2021-11-20 22:27
 */
public class Book{
    private int userId;
    private String userName;
    private  String ustatus;

    public int getUserId() {
        return userId;
    }

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", ustatus='" + ustatus + '\'' +
                '}';
    }

    public Book(int userId, String userName, String ustatus) {
        this.userId = userId;
        this.userName = userName;
        this.ustatus = ustatus;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUstatus() {
        return ustatus;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }
}
