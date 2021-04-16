package com.order.web.servlet;


import com.order.entity.Cart;
import com.order.entity.CartItem;
import com.order.entity.Menu;
import com.order.service.ifc.MenuService;
import com.order.service.impl.MenuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static MenuService menuService = new MenuServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String option = request.getParameter("option");
        if ("addToCart".equals(option)){//加入购物车
            addToCart(request,response);
        } else if ("moveToCart".equals(option)){
            moveToCart(request,response);//从购物车删除
        } else if ("clearCart".equals(option)){
            clearCart(request,response);
        } else if ("findCart".equals(option)){
            findCart(request,response);
        }
    }

    /**
     * 把商品加入购物车
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void addToCart(HttpServletRequest request, HttpServletResponse response){
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        int mid = Integer.parseInt(request.getParameter("mid"));
        String uid = request.getParameter("uid");
//        System.out.println("这是用户id"+uid);
//        String mid = request.getParameter("mid");
        try {
            System.out.println(quantity+"=========="+mid);
            //创建购物项
            CartItem cartItem = new CartItem();
            //通过id查找菜品
            Menu menu = menuService.findMenuById(mid);
            cartItem.setMenu(menu);
//            System.out.println("这是menu对象"+menu);
            cartItem.setCount(quantity);
            System.out.println(cartItem.getCount());
            Cart cart = getCart(request);
            cart.addCart(cartItem);

            request.getSession().setAttribute("userCart",cart);
//            System.out.println("这是cart对象"+cart);
//            System.out.println("这是商品小计" + cartItem.getSubtotal());
//            System.out.println("购物车总价" + cart.getTotal());
            request.getRequestDispatcher("cart.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    protected String moveToCart(HttpServletRequest request, HttpServletResponse response){
        try {
            int mid = Integer.parseInt(request.getParameter("mid"));
            Cart cart = getCart(request);
            cart.removeCart(mid);
            request.getSession().setAttribute("userCart",cart);
            request.getRequestDispatcher("cart.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 清空购物车
     */
    protected String clearCart(HttpServletRequest request, HttpServletResponse response){
        Cart cart = getCart(request);
        cart.cartClear();
        try {
            request.getSession().setAttribute("userCart",cart);
            request.getRequestDispatcher("cart.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 查看购物车
     */
    protected void findCart(HttpServletRequest request, HttpServletResponse response){

        try {
            Cart cart = (Cart)request.getSession().getAttribute("userCart");
            if (cart == null){
                //没有购物车
                cart = new Cart();
            }
            request.getSession().setAttribute("userCart",cart);
            request.getRequestDispatcher("cart.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取购物车
     * @param request
     * @return
     */
    public Cart getCart(HttpServletRequest request){
        Cart cart = (Cart)request.getSession().getAttribute("userCart");
        if (cart == null){
            //没有购物车
            cart = new Cart();
        }
        return cart;
    }

}
