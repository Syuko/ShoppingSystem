<%--
  Created by IntelliJ IDEA.
  User: sushu
  Date: 2020/5/14
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored= "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="js/jquery.min.js" ></script>
<div class="main_header">
    <div class="top_nav" id="navbar">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="logo">
                        <a href="index.jsp" title="Crave Ordering"><img src="images/logo.png" alt="Crave Ordering"></a>
                    </div>
                    <div class="nav_manu">
                        <div class="Menu_list">
                            <ul class="menu">
                                <li><a href="${pageContext.request.contextPath}/IndexServlet" class="trans hvr-underline-from-left">主页</a></li>
                                <li><a href="about.html" class="trans">关于</a></li>
                                <li><a href="${pageContext.request.contextPath}/MenuServlet?option=queryAllMenu" class="trans">订餐</a></li>
                                <!-- login -->
                                <c:if test="${empty user }">
                                    <li><a href="loginByUser.jsp" class="trans">登录</a></li>
                                    <li><a href="register.jsp" class="trans">注册</a></li>
                                </c:if>
                                <c:if test="${not empty user }">
                                    <li><a href="#" class="trans">${user.userFname}的信息</a></li>
                                    <li><a href="${pageContext.request.contextPath}/OrderServlet?option=orderShow" class="trans">我的订单</a></li>
                                </c:if>
                                <!-- //login -->
                            </ul>
                        </div>
                        <div class="Cart">
                            <a href="${pageContext.request.contextPath}/CartServlet?option=findCart" title="Cart">
                                <span class="Cart_count">我的购物车</span>
                                <!-- <i class="fa fa-shopping-cart" aria-hidden="true"></i> -->
                                <img class="cart_img" src="images/cart_1.webp" alt="cart_1">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <button id="burger" class="open-main-nav">
        <span class="burger"></span>
    </button>
    <div class="H_banner home">
        <div class="main_pitch">
            <!--                        <h1 class="page_title">Order Online Your Food</h1>-->
            <h3 class="cntct">联系我们<span class="call_desk"><a href="tel:+01234567890" id="typewriter_num"></a></span></h3>
        </div>
    </div>
    <div class="bottom_pitch">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="main_bpitch">
                        <ul id="mean">
                            <li class="pizza active"><a href="${pageContext.request.contextPath}/MenuServlet?option=queryAllMenu" class="trans" title="Pizza"><span class="icon">披萨</span></a></li>
                            <li class="burger1"><a href="${pageContext.request.contextPath}/MenuServlet?option=queryAllMenu" class="trans" title="Burgers"><span class="icon">汉堡</span></a></li>
                            <li class="salads"><a href="${pageContext.request.contextPath}/MenuServlet?option=queryAllMenu" class="trans" title="Salads"><span class="icon">沙拉</span></a></li>
                            <li class="fries"><a href="${pageContext.request.contextPath}/MenuServlet?option=queryAllMenu" class="trans" title="Fries"><span class="icon">杂食</span></a></li>
                            <li class="drinks"><a href="${pageContext.request.contextPath}/MenuServlet?option=queryAllMenu" class="trans" title="Drinks"><span class="icon">饮品</span></a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%--使用AJAX异步请求--%>
    <script>
        $(function () {
            $.ajax({
                url:'${pageContext.request.contextPath}/CategoryServlet',
                // data:   --参数 sql中的?
                type:'get',
                dataType:'json',   //表示服务器响应给客户端的数据格式
                success:function (result) {  //成功执行的回调函数
                    // console.log(result)
                    $("#mean").empty();//清空里面的子标签
                    //遍历json数组，value就是数组中的每一个元素
                    $.each(result,function (index,value) {
                        $("#mean").append("<li class=\""+ value.menuClass +"\"><a href=\"${pageContext.request.contextPath}/MenuServlet?option=queryAllMenu\" class=\"trans\"><span class=\"icon\">" + value.menuType + "</span></a></li>\n");
                    })
                }
            })
        })
    </script>
</div>
<div class="device">
    <nav class="main-nav" id="main-nav">
        <div class="logo">
            <a href="index.jsp" title="Crave Ordering"><img src="images/logoBlack.png" alt="Crave Ordering"></a>
        </div>
        <ul>
            <li><a href="${pageContext.request.contextPath}/IndexServlet">主页</a></li>
            <li><a href="about.html">关于</a></li>
            <li><a href="${pageContext.request.contextPath}/MenuServlet?option=queryAllMenu">点餐</a></li>
            <!-- login -->
            <c:if test="${empty user }">
                <li><a href="loginByUser.jsp">登录</a></li>
                <li><a href="register.jsp">注册</a></li>
            </c:if>
            <c:if test="${not empty user }">
                <li><a href="#">${user.userFname}的信息</a></li>
                <li><a href="${pageContext.request.contextPath}/OrderServlet?option=orderShow">我的订单</a></li>
            </c:if>
            <!-- //login -->

        </ul>
    </nav>
</div>



