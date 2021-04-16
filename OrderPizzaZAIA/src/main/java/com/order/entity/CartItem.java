package com.order.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 购物项
 */
public class CartItem implements Serializable{
    private static final long serialVersionUID = -8520038895184509384L;
    private Menu menu;//菜品
    private int count;//数量
    private float subtotal;//小计


    @Override
    public String toString() {
        return "CartItem{" +
                "menu=" + menu +
                ", count=" + count +
                ", subtotal=" + subtotal +
                '}';
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getSubtotal() {
        float price = this.menu.getMenuRetail();
        subtotal = price * this.count;
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }
}
