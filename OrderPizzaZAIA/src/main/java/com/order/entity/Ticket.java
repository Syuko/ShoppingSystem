package com.order.entity;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Ticket implements Serializable {

    private Map<Integer,TicketItem> ticket = new LinkedHashMap<Integer,TicketItem>();
    private float total;
    private int state;
    private String address;
    private String uid;

    @Override
    public String toString() {
        return "Ticket{" +
                "ticket=" + ticket +
                ", total=" + total +
                ", state=" + state +
                ", address='" + address + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }

    public Map<Integer, TicketItem> getTicket() {
        return ticket;
    }

    public void setTicket(Map<Integer, TicketItem> ticket) {
        this.ticket = ticket;
    }

    public float getTotal() {
        Set<Map.Entry<Integer,TicketItem>> entrySet = ticket.entrySet();
        Iterator<Map.Entry<Integer,TicketItem>> iterator = entrySet.iterator();
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setTicketItem(Object creatTicketItem) {

    }

    public void addTicket(TicketItem ticketItem) {
        Integer id = ticketItem.getMenu().getMenuId();
        if (ticket.containsKey(id)){
            //已存在购物项
            TicketItem _ticketItem = ticket.get(id);
            _ticketItem.setCount(_ticketItem.getCount()+ticketItem.getCount());

        } else {
            //不存在
            ticket.put(id,ticketItem);
        }
        total += ticketItem.getSubtotal();
    }
}
