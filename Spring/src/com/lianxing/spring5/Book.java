package com.lianxing.spring5;

/**
 * @author lianxing
 * @description
 * @create 2021-10-30 14:26
 */
public class Book {
    private String bname;
    private String bauthor;
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Book book = new Book();
//        book.setBname();
    }

}
