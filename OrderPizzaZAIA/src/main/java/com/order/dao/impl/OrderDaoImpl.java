package com.order.dao.impl;

import com.order.dao.ifc.MenuDao;
import com.order.dao.ifc.OrderDao;
import com.order.entity.*;
import com.order.util.DBUtil_pool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class OrderDaoImpl implements OrderDao {

    private static Connection conn = DBUtil_pool.getConnection();
    private static PreparedStatement stat=null;
    private static ResultSet rs=null;

    MenuDao menuDao = new MenuDaoImpl();
    private static final String CREATE_TICKET="INSERT INTO order_ticket (UserId, MenuId,TicketState,TicketNum,TicketAddress,TicketTime) VALUES (?,?,?,?,?,NOW())";
    private static final String QUERY_MENU_BY_UID_MID_STATE="SELECT TicketId FROM order_ticket WHERE UserId=? AND MenuID=? AND TicketState=0";
    private static final String UPDATE_COUNT_BY_TID="UPDATE order_ticket SET TicketNum = TicketNum + ?, TicketTime = NOW() WHERE TicketId = ?";
    private static final String QUERY_TICKET_BY_UID="SELECT * FROM order_ticket WHERE UserId = ?";
    private static final String QUERY_MENU_BY_MID="SELECT * FROM order_menu WHERE MenuId = ?";
    private static final String QUERY_MENU_BY_MENUID="SELECT * FROM order_menu WHERE MenuId IN (SELECT MenuId FROM order_ticket WHERE UserId = ?);";
//    @Override
//    public Boolean creatTicket(Cart cart, Users user) {
//
//        Boolean creatTicket = false;
//
////        Set<Map.Entry<Integer,CartItem>> entrySet = cart.getCart().entrySet();
//        Iterator<Map.Entry<Integer, CartItem>> iterator = cart.getCart().entrySet().iterator();
//        int result = 0;
//        while (iterator.hasNext()){
//            try {
//                CartItem cartItem = iterator.next().getValue();
//                System.out.println(cartItem);
//                stat = conn.prepareStatement(CREATE_TICKET);
//                stat.setString(1,user.getUserId());
//                System.out.println("到了uid这里");
//                stat.setInt(2,cartItem.getMenu().getMenuId());
//                System.out.println("到了mid这里");
//                result = stat.executeUpdate();
//            } catch (SQLException throwables) {
//                throwables.printStackTrace();
//            }
//            if(result > 0){
//                creatTicket = true;
//            }else {
//                creatTicket = false;
//            }
//        }
//
//
//        return creatTicket;
//    }

    @Override
    public void creatTicket(Ticket ticket) {
        //1、先插入数据
        Ticket _ticket = new Ticket();
        Iterator<Map.Entry<Integer, TicketItem>> iterator = ticket.getTicket().entrySet().iterator();
        while (iterator.hasNext()){
            TicketItem ticketItem = iterator.next().getValue();
            try {
                //判断这个user是否买了状态为0的同样的商品

                stat = conn.prepareStatement(QUERY_MENU_BY_UID_MID_STATE);
                stat.setString(1, ticket.getUid());
                stat.setInt(2, ticketItem.getMenu().getMenuId());
                rs = stat.executeQuery();

                if (rs.next()){
                    //是的话在数量count上加上ticket的数量
                    Integer tid = rs.getInt("TicketId");
                    System.out.println(tid);
                    stat = conn.prepareStatement(UPDATE_COUNT_BY_TID);
                    stat.setInt(1,ticketItem.getCount());
                    stat.setInt(2,rs.getInt("TicketId"));
                    stat.executeUpdate();
                } else {
                    //不是的话新建一列数据
                    stat = conn.prepareStatement(CREATE_TICKET);
                    stat.setString(1,ticket.getUid());
                    stat.setInt(2,ticketItem.getMenu().getMenuId());
                    stat.setInt(3,ticket.getState());
                    stat.setInt(4,ticketItem.getCount());
                    stat.setString(5,ticket.getAddress());
                    stat.executeUpdate();
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } finally {
                DBUtil_pool.closeReSource(stat,rs);
            }
        }

    }

    /**
     *通过uid查询订单
     * @param userId
     * @return
     */
    @Override
    public List<TicketItem> findTicket(String userId) {
//        Ticket ticket = null;

        List<TicketItem> ticketList = new ArrayList<>();
        Menu menu = null;
        try {
            //拿到订单数据
            stat = conn.prepareStatement(QUERY_TICKET_BY_UID);
            stat.setString(1, userId);
            rs = stat.executeQuery();
            while (rs.next()){
                TicketItem ticketItem = new TicketItem();
                //拿到menuID，去找menu表的对象
                System.out.println("================开始循环");
//                System.out.println(rs.getInt("MenuId"));
                Integer mid = rs.getInt("MenuId");
//                System.out.println("这是mid"+rs.getInt("MenuId"));
                menu = menuDao.findMenuById(mid);
                System.out.println(menu);

                ticketItem.setMenu(menu);
                ticketItem.setCount(rs.getInt("TicketNum"));
                System.out.println(ticketItem);
                ticketList.add(ticketItem);
                System.out.println("4========"+ticketItem.getMenu());
//                ticket.getTicket().put(mid,ticketItem);
                System.out.println("===============一次结束");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil_pool.closeReSource(stat,rs);
        }
        return ticketList;
    }


}
