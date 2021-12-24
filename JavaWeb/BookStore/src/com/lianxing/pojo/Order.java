package com.lianxing.pojo;


import javax.xml.crypto.Data;

;import java.math.BigDecimal;
import java.util.Date;

/**
 * @author lianxing
 * @description
 * @create 2021-10-23 20:09
 */
public class Order {

    private String orderID;
    private Date createDate;
    private BigDecimal price;
    //0未发货 1已发货 2已收货
    private Integer status = 0;
    private Integer userId;

    @Override
    public String toString() {
        return "Order{" +
                "orderID='" + orderID + '\'' +
                ", createDate=" + createDate +
                ", price=" + price +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Order() {
    }

    public Order(String orderID, Date createDate, BigDecimal price, Integer status, Integer userId) {
        this.orderID = orderID;
        this.createDate = createDate;
        this.price = price;
        this.status = status;
        this.userId = userId;
    }
}
