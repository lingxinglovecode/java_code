package com.lianxing.pojo;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lianxing
 * @description
 * @create 2021-10-23 11:55
 */
public class Cart {

//    private Integer totalCount;
//    private BigDecimal totalPrice;
    private Map<Integer,CartItem> items = new LinkedHashMap<Integer,CartItem>();


    public void addItem(CartItem cartItem) {

        //先查看购物车里是否已经添加了该商品，如果已经添加的话数量+1，金额累加
        CartItem item = items.get(cartItem.getId());
        if ( item==null ){
            items.put(cartItem.getId(),cartItem);
        }else {
            //数量累加，添加总金额
            item.setCount(item.getCount()+1);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount()) ));

        }


    }

    public void deleteItem(Integer id) {
        items.remove(id);

    }

    public void clear( ) {
        items.clear();

    }

    public void updateCount(Integer id,Integer count){
        CartItem item = items.get(id);
        if ( item!=null ){
            item.setCount(count);
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount()) ));
        }
    }


    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }

    public Cart() {
    }


    public Integer getTotalCount() {

        Integer totalCount = 0;

        for(Map.Entry<Integer, CartItem> entry : items.entrySet()){
            totalCount += entry.getValue().getCount();
        }


        return totalCount;
    }



    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for(Map.Entry<Integer, CartItem> entry : items.entrySet()){
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }

        return totalPrice;

    }



    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }
}
