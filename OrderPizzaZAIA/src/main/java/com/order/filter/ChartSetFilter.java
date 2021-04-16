package com.order.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 过滤器：在服务器启动时被创建和实例化，服务器关闭时销毁
 */
@WebFilter(filterName = "/WebFilter")//过滤器拦截路径
public class ChartSetFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        //初始化
    }
    public void destroy() {
        //销毁
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("=================拦截了=========");
        chain.doFilter(request, response);
        //拦截请求
        //统一编码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //设置响应内容格式
        response.setContentType("text/html;charset=utf-8");
        //放行
        chain.doFilter(request, response);
    }



}
