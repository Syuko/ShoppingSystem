package com.order.web.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.order.entity.Users;
import com.order.service.ifc.UserService;
import com.order.service.impl.UserServiceImpl;
import com.order.util.LockUtil;

/**
 * Servlet implementation class LoginServlet
 * 
 * 需求分析：
 * 1、获取前端页面输入的参数(用户名和密码)
 * 2、调用UserService中的登录方法
 * 3、UserService调用Dao层访问数据库
 * 4、判断是否能登录
 * 5、登录成功后的处理
 * 
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService=new UserServiceImpl();
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		/**
		 * 获取请求的参数
		 */
		String username = request.getParameter("username");
		String securityCode = request.getParameter("securityCode");
		HttpSession session = request.getSession();
		//密码加密登录
		String password = null;

		try {
			password = new BigInteger(LockUtil.encryptMD5(request.getParameter("password").getBytes())).toString();
//			System.out.println(password);
			//验证码验证
			if("".equals(securityCode.trim()) || securityCode.trim() == null){
				request.setAttribute("errorMessage","请输入验证码");
				request.getRequestDispatcher("loginByUser.jsp").forward(request,response);
			}else if ("".equals(password.trim()) || password.trim() == null){
				request.setAttribute("errorMessage","请输入密码");
				request.getRequestDispatcher("loginByUser.jsp").forward(request,response);
			}else if ("".equals(username.trim()) || username.trim() == null) {
				request.setAttribute("errorMessage","请输入用户名");
				request.getRequestDispatcher("loginByUser.jsp").forward(request,response);
			}else {
				//判断验证码是否正确（忽略大小写）
				//session中获取每次请求生成的验证码
				String code = (String)session.getAttribute("code");
				if(code.equalsIgnoreCase(securityCode)){
					//验证码正确
					Users user = userService.userLogin(username, password);
					if (user != null){
						//存在用户
						session.setAttribute("user",user);
//					System.out.println("获取到的用户:"+user);
						//回到主页
//						request.getRequestDispatcher("index.jsp").forward(request,response);
						response.sendRedirect(request.getContextPath()+"/IndexServlet");

					}else {
						//用户不存在
//					System.out.println("login faild please retry to login");
//				HttpSession session = request.getSession();
						session.setAttribute("errorMessage","用户名或密码错误，请重新登陆");
						//request.setAttribute("message","用户名或密码错误，请重新登陆");
						request.getRequestDispatcher("loginByUser.jsp").forward(request,response);
					}
				}else{
					//验证码不正确
					request.setAttribute("errorMessage","验证码不正确");
					request.getRequestDispatcher("loginByUser.jsp").forward(request,response);
				}

			}
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}



	}
   
}
