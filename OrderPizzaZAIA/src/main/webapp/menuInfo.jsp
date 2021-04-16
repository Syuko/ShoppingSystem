<%--
  Created by IntelliJ IDEA.
  User: sushu
  Date: 2020/6/21
  Time: 13:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8" />
    <link rel="icon" href="images/favicon.ico" type="image/x-icon">
    <meta name="robots" content="index, follow">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta content="" name="description" />
    <meta content="" name="keywords" />
    <title>详情</title>
    <!-- Fonts Here-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:100,300,400,700" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,400i,500,500i,600,600i,700,700i,800" rel="stylesheet" >
    <!-- Fonts here-->

    <!-- Style Here -->
    <link rel="stylesheet" href="css/slick.css" >
    <link rel="stylesheet" href="css/style.css" >
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- bootstrap -->
    <link rel="stylesheet" href="css/bootstrap.min.css" >

    <!-- JS -->
    <script src="js/popper.min.js" ></script>
    <script src="js/jquery.min.js" ></script>
    <script src="js/bootstrap.min.js" ></script>
</head>

<body>
<div class="wrapper">
    <!-- Header Start Here -->
    <%--            静态包含--%>
    <%@include file="catrgoryHead.jsp" %>
    <%--            动态包含--%>
    <!-- Header Start Here -->

    <!-- breadcum section -->

    <div class="breadcum">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="main_breadcum">
                        <ul>
                            <li><a href="index.html" class="trans" title="Home">主页</a></li>
                            <li>详情</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- breadcum section -->
    <!-- Our login section -->
    <section id="login">
        <div class="login_section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="main_login">
                            <div class="login_left col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                <div class=""><img src="${pageContext.request.contextPath}/${menu.menuPhoto}" class="absoImg" alt=""></div>
                            </div>
                            <div class="signup_right col-lg-6 col-md-6 col-sm-12 col-xs-12">
                                <div class="login_box">
                                    <h3 class="title">${menu.menuName}</h3>
                                    <h4 class="create_ac">${menu.menuIntroduction}</h4>
                                    <h4 class="create_ac">价格</h4>
                                    <h2 class="title" style="color: red">￥ ${menu.menuRetail}</h2>
                                    <h4 class="create_ac">数量</h4>
                                    <button style="width: 25px" onclick="this.parentNode.querySelector('input[type=number]').stepDown()">-</button>
                                    <input form="menuInfoForm" name="quantity" type="number" value="1" min="1" style="width: 30px;text-align: center;margin-bottom: 20px">
                                    <button style="width: 25px" onclick="this.parentNode.querySelector('input[type=number]').stepUp()">+</button>
                                    <form method="post" id="menuInfoForm" action="CartServlet?option=addToCart&mid=${menu.menuId}">
                                        <button type="submit" class="register-btn red_btn trans squre-btn hvr-ripple-out" name="UpToCart">加入购物车</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Our login section -->

    <!-- Footer Section here -->
    <footer>
        <div class="main_footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="M_footer">
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 quick_links">
                                <div class="title">快速链接</div>
                                <div class="main_cnt">
                                    <ul>
                                        <li><a href="about.html" class="trans" title="About us">关于我们</a></li>
                                        <!--                                            <li><a href="faq.html" class="trans" title="Faq">相关</a></li>-->
                                        <li><a href="contactus.html" class="trans" title="Contacts">相关</a></li>
                                        <li><a href="loginByUser.jsp" class="trans" title="Login">登录</a></li>
                                        <li><a href="register.jsp.jsp" class="trans" title="Register">注册</a></li>
                                        <li><a href="terms_conditions.html" class="trans" title="Terms and conditions">条件、条款</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-5 col-md-5 col-sm-6 col-xs-12 location">
                                <div class="title">门店位置</div>
                                <div class="main_cnt"> <span class="address"><a href="#">广东省, 广州市, 从化区</a></span> <span class="time1">周一 - 周五: 08:00 am - 10:00 pm</span> <span class="time2">周六 - 周日: 10:00 am - 11:00 pm<strong></strong></span> <span class="conact"><a href="tel:+01234567890">+01 (234) 56 56 789</a></span> </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 subscribe">
                                <div class="title">订阅我们</div>
                                <div class="main_cnt">
                                    <p class="sbcr_label">订阅La Vie时事通讯，
                                        <br>定期更新优惠信息</p>
                                    <form method="post" id="subscribeform" action="thank-you.html">
                                        <div class="sbcrb_input">
                                            <input type="text" name="subscribeemail" class="form-control" placeholder="输入您的邮箱">
                                            <button class="subscribebutton send" name="getbutton" type="submit">
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="F_footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="payment"> <span>Payment Options</span> <span class="pay_cards"><img src="images/card_img.png" alt=""></span> </div>
                        <div class="social">
                            <ul>
                                <li><a href="#" class="trans" title="Facebook"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
                                <li><a href="#" class="trans" title="Twitter"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
                                <li><a href="#" class="trans" title="Google Plus"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li>
                                <li><a href="#" class="trans" title="Instagram"><i class="fa fa-instagram" aria-hidden="true"></i></a></li>
                                <li><a href="#" class="trans" title="Pinterest"><i class="fa fa-pinterest-p" aria-hidden="true"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="copyright">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <p>© <a href="${pageContext.request.contextPath}/IndexServlet" class="trans" title="Crave Ordering">Crave Ordering</a> 2019, All rights reserved </p>
            </div>
        </div>
    </footer>
    <!-- Footer Section here -->

</div>
<!-- JS Here -->
<script src="js/custome.js" ></script>
<script src="js/slick.js" ></script>
<script src="js/jquery.validate.min.js" ></script>
<!-- JS Here -->
</body>

</html>
