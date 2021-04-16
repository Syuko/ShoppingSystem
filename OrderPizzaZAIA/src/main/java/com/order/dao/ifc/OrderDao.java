package com.order.dao.ifc;

import com.order.entity.*;

import java.util.List;

public interface OrderDao {

//    public Boolean creatTicket(Cart cart, Users user);
    //往表中添加购物车的食品
    public void creatTicket(Ticket ticket);

    public List<TicketItem> findTicket(String userId);
}
