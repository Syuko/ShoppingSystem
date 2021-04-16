package com.order.service.ifc;

import com.order.entity.*;

import java.util.List;

public interface OrderService {
    //public Boolean creatTicket(Cart cart, Users user);
    public void creatTicket(Cart cart, Users user, String address);

    public List<TicketItem> findTicket(String userId);
}
