package com.order.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.dao.impl.ProductDao;
import com.order.entity.T_Product;



/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//��ȡҳ���ֵ
		String MenuId = request.getParameter("MenuId");
		String MenuPhoto = request.getParameter("MenuPhoto");
		String MenuName = request.getParameter("MenuName");
		String MenuRetail = request.getParameter("MenuRetail");
		String MenuIntroduction = request.getParameter("MenuIntroduction");
		String MenuTypeId = request.getParameter("MenuTypeId");
			
		//������������޸Ĳ���
		ProductDao productdao = new ProductDao();
		boolean bl = productdao.UserUpdateById(MenuId, MenuPhoto, MenuName, MenuRetail, MenuIntroduction, MenuTypeId);
		//�������յ����ݿ��޸Ĳ�����Ϣ֮���������ת�������󷢳���
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
