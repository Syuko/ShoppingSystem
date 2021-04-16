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
 * Servlet implementation class DeleteProductServlet
 */
@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������servlet��ȡ����
				String MenuId = request.getParameter("MenuId");
				System.out.println(MenuId);
				//�����������ɾ������
				ProductDao productdao = new ProductDao();
				boolean bl = productdao.deleteUserByid(MenuId);
				//�������յ����ݿ�ɾ��������Ϣ֮���������ת�������󷢳���
				if(bl) {
					 List<T_Product> listuser = productdao.GetProductList();
					    
					    //��ͻ��˽��ж�̬
					    request.setAttribute("listuser", listuser);
					    //ת��
					    request.getRequestDispatcher("userList2.jsp").forward(request, response);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
