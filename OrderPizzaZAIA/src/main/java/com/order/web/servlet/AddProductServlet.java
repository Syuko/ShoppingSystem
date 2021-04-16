package com.order.web.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.order.dao.impl.ProductDao;
import com.order.entity.T_Product;





/**
 *  implementation class AddProductServlet
 */
@WebServlet("/addProductServlet")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

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
		
		
/*		//�洢��ʵ����
		T_Product product = new T_Product();
		product.setMenuId(MenuId);
		product.setMenuPhoto(MenuPhoto);
		product.setMenuName(MenuName);
		product.setMenuRetail(MenuRetail);
		product.setMenulntroduction(MenuIntroduction);
		product.setMenuTypeld(MenuTypeId);*/
		//�������������Ӳ���
		ProductDao productdao = new ProductDao();
		boolean bl = productdao.addUserByid(MenuId, MenuPhoto, MenuName, MenuRetail, MenuIntroduction, MenuTypeId);
		//�������յ����ݿ���Ӳ�����Ϣ֮���������ת�������󷢳���
		if(bl) {
			 List<T_Product> listuser = productdao.GetProductList();
			    
			    //��ͻ��˽��ж�̬
			    request.setAttribute("listuser", listuser);
			    //ת��
			    request.getRequestDispatcher("userList2.jsp").forward(request, response);
		}
        
        
//		��product���ݸ�service��
		
		
/*		String pname = request.getParameter("pname");
		String price = request.getParameter("market_price");
		String file = request.getParameter("Filename");
		String market = request.getParameter("market");
		
		System.out.println(pname +"::"+price+"::"+file+"::"+market);
		
		System.out.println("//////////////////////////////////////");
		ServletInputStream is = request.getInputStream();
		System.out.println(is);*/
		
		
/*		try {
			//1.���������ļ����
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//2.�������Ķ���
			ServletFileUpload upload = new ServletFileUpload(factory);
			//3.��������
			List<FileItem> list = upload.parseRequest(request);
			//4.��ȡÿһ���ļ���
			for(FileItem fi : list) {
				//a.��ȡ��ǩname����
				String fieldName = fi.getFieldName();
				System.out.println(fieldName);
				
				
				//b.�ж��Ƿ�����ͨ���ϴ����
				if(fi.isFormField()) {
					String value = fi.getString("utf-8");
					System.out.println(value);
				}else {
					//�ļ��ϴ����
					//��ȡ�ļ�����
					String fileName = fi.getName();
					
					//��ȡ�ļ�����
					InputStream is = fi.getInputStream();
					System.out.println(fileName+"::"+is);
					
					//����һ�������
					FileOutputStream os = new FileOutputStream(new File("D:\\BaiduNetdiskDownload\\"+fileName));
					
					//������
					IOUtils.copy(is, os);
					
					//�ͷ���Դ
					os.close();
					is.close();
					
					
					//ɾ����ʱ�ļ�
					fi.delete();
				}
			}
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
