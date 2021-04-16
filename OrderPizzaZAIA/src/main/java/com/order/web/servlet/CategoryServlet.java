package com.order.web.servlet;

import com.alibaba.fastjson.JSON;
import com.order.entity.Category;
import com.order.service.ifc.CategoryService;
import com.order.service.impl.CategoryServiceImpl;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    CategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("访问到了CategoryServlet这里");
        //设置编码格式
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");

        List<Category> categoryList = categoryService.findAll();
        String data = JSON.toJSONString(categoryList);
        //设置相应数据格式
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(data);
    }


}

