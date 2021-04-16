package com.order.web.servlet;

import com.order.entity.*;
import com.order.service.ifc.OrderService;
import com.order.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    OrderService orderService = new OrderServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String option = request.getParameter("option");
        if ("order_info".equals(option)){//加入购物车
            order_info(request,response);
        } else if ("orderShow".equals(option)){
            orderShow(request,response);
        }
    }

    private void order_info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart)request.getSession().getAttribute("userCart");
        Users user = (Users) request.getSession().getAttribute("user");
        String address = request.getParameter("address");
        System.out.println(address);
        //boolean exeCreateTicket = orderService.creatTicket(cart,user);
        //System.out.println(exeCreateTicket);

        orderService.creatTicket(cart,user,address);
        List<TicketItem> user_Ticket = orderService.findTicket(user.getUserId());
//        Ticket ticket = orderService.findTicket(user.getUserId());
        System.out.println("这是servlet拿到的ticket"+user_Ticket);
        request.getSession().setAttribute("userTicket",user_Ticket);
//        Ticket ticket = orderService.findTicket(user.getUserId());
//        System.out.println("这是servlet拿到的ticket"+ticket);
//        request.getSession().setAttribute("userTicket",ticket);
        cart.cartClear();
        request.getRequestDispatcher("userTicket.jsp").forward(request,response);

    }

    private void orderShow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cart cart = (Cart)request.getSession().getAttribute("userCart");
        Users user = (Users) request.getSession().getAttribute("user");
//        System.out.println(address);
        //boolean exeCreateTicket = orderService.creatTicket(cart,user);
        //System.out.println(exeCreateTicket);

        List<TicketItem> user_Ticket = orderService.findTicket(user.getUserId());
        //Ticket ticket = orderService.findTicket(user.getUserId());
        System.out.println("这是servlet拿到的ticket"+user_Ticket);
        request.getSession().setAttribute("userTicket",user_Ticket);

        request.getRequestDispatcher("userTicket.jsp").forward(request,response);

    }
}
