package com.order.web.servlet;

import com.order.entity.Menu;
import com.order.service.ifc.MenuService;
import com.order.service.impl.MenuServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static MenuService menuService = new MenuServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        String option = request.getParameter("option");
        if ("queryAllMenu".equals(option)){//查询所有菜单
            queryAllMenu(request,response);
        } else if ("queryMenuById".equals(option)){//通过id显示详情
            queryMenuById(request,response);
        }

    }

    /**
     * 查询所有菜单
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void queryAllMenu(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
        //所有商品显示
        List<Menu> all_menu = menuService.findAllMenu();
        request.setAttribute("allMenuList",all_menu);
//        System.out.println("------------");
        request.getRequestDispatcher("menu.jsp").forward(request,response);
    }

    /**
     * 通过id显示单个商品信息
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void queryMenuById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int mid = Integer.parseInt(request.getParameter("mid"));
        Menu menu = menuService.findMenuById(mid);
        //将信息放入request并跳转到商品详情页面
        request.setAttribute("menu",menu);
        request.getRequestDispatcher("menuInfo.jsp").forward(request,response);

    }

}
