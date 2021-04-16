package com.order.entity;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * 购物车
 */
public class Cart implements Serializable{
    private static final long serialVersionUID = -5011105232965262325L;
    //定义一个购物项的集合的属性，采用map集合，使用商品的id作为map的key
        //使用购物项CartItem作为map的value
    private Map<Integer,CartItem> cart = new LinkedHashMap<Integer,CartItem>();
    //定义购物车中的统计价格
    private float total;

    @Override
    public String toString() {
        return "Cart{" +
                "cart=" + cart +
                ", total=" + total +
                '}';
    }
    public Map<Integer, CartItem> getCart() {
        return cart;
    }

    public void setCart(Map<Integer, CartItem> cart) {
        this.cart = cart;
    }

    public float getTotal() {
        Set<Map.Entry<Integer,CartItem>> entrySet = cart.entrySet();
        Iterator<Map.Entry<Integer,CartItem>> iterator = entrySet.iterator();
        float total = 0;
        while (iterator.hasNext()){
            total += iterator.next().getValue().getSubtotal();
        }
        this.total = total;
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void addCart(CartItem cartItem) {
        Integer id = cartItem.getMenu().getMenuId();
        if (cart.containsKey(id)){
            //已存在购物项
            CartItem _cartItem = cart.get(id);
            _cartItem.setCount(_cartItem.getCount()+cartItem.getCount());

        } else {
            //不存在
            cart.put(id,cartItem);
        }
        total += cartItem.getSubtotal();
    }

    public void removeCart(int mid) {
        CartItem cartItem = cart.remove(mid);
        total -= cartItem.getSubtotal();//总价减少
    }

    //清空购物车
    public void cartClear(){
        cart.clear();
        total = 0;
    }
}
