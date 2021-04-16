package com.order.service.impl;

import com.order.dao.ifc.MenuDao;
import com.order.dao.ifc.OrderDao;
import com.order.dao.impl.MenuDaoImpl;
import com.order.dao.impl.OrderDaoImpl;
import com.order.entity.*;
import com.order.service.ifc.OrderService;
import sun.security.util.KeyUtil;

import java.util.*;

public class OrderServiceImpl implements OrderService {
    OrderDao orderDao = new OrderDaoImpl();
    MenuDao menuDao = new MenuDaoImpl();

    @Override
    public void creatTicket(Cart cart, Users user, String address) {
        Ticket ticket = new Ticket();
        ticket.setUid(user.getUserId());//拿到用户id
        ticket.setState(0);//状态
        ticket.setAddress(address);//拿地址
        ticket.setTicket(creatTicketItem(cart.getCart()));//拿购物车里的购物项
        //orderDao.creatTicket(ticket);
//        System.out.println(ticket);
        orderDao.creatTicket(ticket);
    }

    @Override
    public List<TicketItem> findTicket(String userId) {

//        Ticket ticket = new Ticket();
//        ticket = orderDao.findTicket(userId);
//        Menu menu = menuDao.findMenuById();
        return orderDao.findTicket(userId);
    }

    /**
     * 把cartmap中的菜品放入ticketmap
     * @param cart
     * @return
     */
    public Map<Integer, TicketItem> creatTicketItem(Map<Integer, CartItem> cart) {
        Map<Integer,TicketItem> ticketMap = new LinkedHashMap<Integer,TicketItem>();
        Iterator<Map.Entry<Integer, CartItem>> iterator = cart.entrySet().iterator();
        while (iterator.hasNext()){
            CartItem cartItem = iterator.next().getValue();
            TicketItem ticketItem = new TicketItem();
            ticketItem.setCount(cartItem.getCount());
            ticketItem.setMenu(cartItem.getMenu());
            ticketItem.setSubtotal(cartItem.getSubtotal());
            ticketMap.put(cartItem.getMenu().getMenuId(),ticketItem);
        }
        return ticketMap;
    }


//    @Override
//    public Boolean creatTicket(Cart cart, Users user) {
//
//        //<Map.Entry<Integer,CartItem>> entrySet = cart.entrySet();
//        //Iterator<Map.Entry<Integer,CartItem>> iterator = cart.entrySet.iterator();
////        Ticket ticket = new Ticket();
////        ticket.setUid(user.getUserId());
////        ticket.setTotal(cart.getTotal());
////        ticket.setState(0);
//
//        //String tid = KeyUtil.getKey("ticket");
//
//        return orderDao.creatTicket(cart,user);
//    }



}
