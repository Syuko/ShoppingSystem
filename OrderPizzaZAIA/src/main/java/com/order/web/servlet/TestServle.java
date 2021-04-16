package com.order.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServle extends HttpServlet {

	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet.............");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost.............");
	}*/
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 编译器已经帮我们完成以下代码
		 * String method=request.getMethod();
		System.out.println(method);
		if(method.equals("POST")) {
			doPost(request,response);
		}else if(method.equals("GET")) {
			doGet(request,response);
		}*/
		
	}
	
	
}
