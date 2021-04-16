package com.order.entity;

import java.io.Serializable;

public class TicketItem implements Serializable {
    private static final long serialVersionUID = -8093397092590129600L;
    private  float subtotal;
    private int count;
    private Menu menu;
    private Integer mid;

    @Override
    public String toString() {
        return "TicketItem{" +
                "subtotal=" + subtotal +
                ", count=" + count +
                ", menu=" + menu +
                ", mid=" + mid +
                '}';
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public float getSubtotal() {
        float price = this.menu.getMenuRetail();
        subtotal = price * this.count;
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
