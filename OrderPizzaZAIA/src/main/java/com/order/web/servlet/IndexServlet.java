package com.order.web.servlet;

import com.alibaba.fastjson.JSON;
import com.order.entity.Category;
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

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static MenuService menuService = new MenuServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //商品显示
        List<Menu> new_menu = menuService.findNew();
        request.setAttribute("newList",new_menu);
//        System.out.println(new_menu);


        request.getRequestDispatcher("index.jsp").forward(request,response);

    }


}
