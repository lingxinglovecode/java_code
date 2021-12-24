package com.atguigu.mvc.bean;

/**
 * @author lianxing
 * @description
 * @create 2021-12-02 9:59
 */
public class User {

    private Integer ID;
    private String username;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }

    private String sex;
    private String email;
    private Integer age;

    public User() {
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(Integer ID, String username, String password, String sex, String email, Integer age) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.sex = sex;
        this.email = email;
        this.age = age;
    }
}
