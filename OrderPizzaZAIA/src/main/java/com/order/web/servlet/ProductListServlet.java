package com.order.web.servlet;

import com.order.dao.impl.ProductDao;
import com.order.entity.T_Product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ���ݿ���û���Ϣ���
		System.out.println("到达ProductListServlet的get");
//		ProductDao product = new ProductDao();
	    List<T_Product> listuser = ProductDao.GetProductList();
	    
	    //��ͻ��˽��ж�̬
	    request.setAttribute("listuser", listuser);
	    //ת��
	    request.getRequestDispatcher("userList2.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���봦��
		System.out.println("到达ProductListServlet的post");

		request.setCharacterEncoding("utf-8");
		//ģ����ѯ�ķ���
		//��ȡ����Ϣ
		String values = request.getParameter("values");
		
		//���ݿ����
		ProductDao product = new ProductDao();
		List<T_Product> listuser = product.GetProductList(values);
		
		
		request.setAttribute("listuser", listuser);
		
		request.getRequestDispatcher("userList2.jsp").forward(request,response);
		//System.out.println(values);
	}

}
