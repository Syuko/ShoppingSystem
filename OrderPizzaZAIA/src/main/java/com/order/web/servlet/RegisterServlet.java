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
import com.order.util.UUIDProducer;

/**
 * Servlet implementation class RegisterServlet
 *
 * 需求分析：
 * 1、获取前端页面输入的参数(用户名和密码)
 * 2、调用UserService中的注册方法
 * 3、UserService调用Dao层访问数据库
 * 4、判断是否能插入
 * 5、插入成功后的处理
 *
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService userService=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String username=request.getParameter("username");
        String userSex=request.getParameter("sex");
        String userPhone=request.getParameter("phone");
        String securityCode = request.getParameter("securityCode");
        HttpSession session = request.getSession();
        //密码MD5加密
        String password = null;
        try {
            password = new BigInteger(LockUtil.encryptMD5(request.getParameter("password").getBytes())).toString();
//            System.out.println(password);
            //输入验证
            if("".equals(securityCode.trim()) || securityCode.trim() == null){
                request.setAttribute("errorMessage","请输入验证码");
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }else if ("".equals(password.trim()) || password.trim() == null){
                request.setAttribute("errorMessage","请输入密码");
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }else if ("".equals(username.trim()) || username.trim() == null) {
                request.setAttribute("errorMessage","请输入用户名");
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }else if ("".equals(userPhone.trim()) || userPhone.trim() == null) {
                request.setAttribute("errorMessage","请输入手机号码");
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }else if ("".equals(userSex.trim()) || userSex.trim() == null) {
                request.setAttribute("errorMessage","请确认性别");
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }else {
                //判断验证码是否正确（忽略大小写）
                //session中获取每次请求生成的验证码
                String code = (String)session.getAttribute("code");
                if(code.equalsIgnoreCase(securityCode)){
                    //验证码正确
                    Users user = new Users();
                    String userId = UUIDProducer.getIncreaseIdByNanoTime();//创建唯一有序的ID
                    user.setUserId(userId);
                    user.setUserFname(username);
                    user.setUserPassword(password);
                    user.setUserSex(userSex);
                    user.setUserPhone(userPhone);
//                System.out.println("顺利到达这里"+user);
                    Boolean exeRegister = userService.userRegister(user);
                    //判断数据是否插入成功
                    if(exeRegister){
                        //成功返回登录页面
                        System.out.println("register success");
                        request.setAttribute("registerMessage",1);
                        request.getRequestDispatcher("loginByUser.jsp").forward(request,response);
                    }else {
                        //失败返回注册页面
                        System.out.println("register failed");
                        request.setAttribute("registerMessage","注册失败，请重新注册");
                        request.getRequestDispatcher("register.jsp").forward(request,response);
                    }

                }else{
                    //验证码不正确
                    request.setAttribute("errorMessage","验证码不正确");
                    request.getRequestDispatcher("register.jsp").forward(request,response);
                }

            }


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

//        try {
//            System.out.println(new BigInteger(LockUtil.encryptMD5(request.getParameter("password").getBytes())).toString());
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        }





    }

}
