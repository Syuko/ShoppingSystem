<%--
  Created by IntelliJ IDEA.
  User: sushu
  Date: 2020/6/17
  Time: 20:00
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
    <title>点餐</title>
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
    <header id="Header">

        <%--            静态包含--%>
        <%@include file="catrgoryHead.jsp" %>
        <%--            动态包含--%>

    </header>
    <!-- Header End Here -->

    <!-- How to work section start here -->
    <div class="hwork">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="main_hwork">
                        <ul>
                            <li class="order">
                                <div class="title"><img src="images/h_img1.png" alt=""></div>
                            </li>
                            <li class="deliver_L">
                                <div class="title"><img src="images/h_img2.png" alt="Delivery location"></div>
                            </li>
                            <li class="deliver_pick">
                                <div class="title"> <img src="images/h_img3.png" alt=" Delivery or Pick up "> </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- How to work section start here -->

    <!-- Our Menu section -->
    <!-- Our Menu section -->
    <section>
        <div class="Our_menu">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="main_Ourmenu">
                            <h2 class="title">Pizza</h2>
                            <div class="content_menu bottom_pitch">
                                <div class="main_bpitch">
                                    <ul class="nav nav-tabs" role="tablist">
                                        <li class="nav-item pizza">
                                            <a class="nav-link active trans" data-toggle="tab" href="#pizza" title="Pizza">
                                                <span class="icon">披萨</span>
                                            </a>
                                        </li>
                                        <li class="nav-item burger1">
                                            <a class="nav-link trans" data-toggle="tab" href="#burger1" title="Burgers">
                                                <span class="icon">汉堡</span>
                                            </a>
                                        </li>
                                        <li class="nav-item salads">
                                            <a class="nav-link trans" data-toggle="tab" href="#salad" title="Salads">
                                                <span class="icon">沙拉</span>
                                            </a>
                                        </li>
                                        <li class="nav-item fries">
                                            <a class="nav-link trans" data-toggle="tab" href="#fries" title="Fries">
                                                <span class="icon">杂食</span>
                                            </a>
                                        </li>
                                        <li class="nav-item drinks">
                                            <a class="nav-link trans" data-toggle="tab" href="#drinks" title="Drinks">
                                                <span class="icon">饮料</span>
                                            </a>
                                        </li>
                                    </ul>
                                </div>
                            </div>

                            <div class="tab-content">

                                <div id="pizza" class=" tab-pane active">
                                    <div class="content_row">
                                        <div class="left_cntbar">
                                            <div class="pizza_items">
                                                <div class="row">

                                                            <c:forEach items="${allMenuList}" var="a">
                                                                <c:if test="${a.category.menuTypeId == '1'}">
                                                            <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
                                                                <div class="P_itmesbox">
                                                                    <div class="PT_image"><img src="${pageContext.request.contextPath}/${a.menuPhoto}" class="absoImg" alt=""></div>
                                                                    <div class="PT_dscr">
                                                                        <h3 class="PT_title">${a.menuName}</h3>
                                                                        <p class="PT_dtls"> ${fn:substring(a.menuIntroduction,0,27)}...
                                                                        </p>

                                                                        <div class="price_block">
                                                                            <div class="price">￥ ${a.menuRetail}</div>
                                                                            <a href="${pageContext.request.contextPath}/MenuServlet?option=queryMenuById&mid=${a.menuId}" class="card_btn">现在去购买</a>
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                                </c:if>
                                                            </c:forEach>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>

                                <div id="burger1" class=" tab-pane fade">
                                    <div class="content_row">
                                        <div class="left_cntbar">
                                            <div class="pizza_items">
                                                <div class="row">
                                                    <c:forEach items="${allMenuList}" var="a">
                                                        <c:if test="${a.category.menuTypeId == '2'}">
                                                            <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
                                                                <div class="P_itmesbox">
                                                                    <div class="PT_image"><img src="${pageContext.request.contextPath}/${a.menuPhoto}" class="absoImg" alt=""></div>
                                                                    <div class="PT_dscr">
                                                                        <h3 class="PT_title">${a.menuName}</h3>
                                                                        <p class="PT_dtls"> ${fn:substring(a.menuIntroduction,0,27)}...
                                                                        </p>

                                                                        <div class="price_block">
                                                                            <div class="price">${a.menuRetail}</div>
                                                                            <a href="${pageContext.request.contextPath}/MenuServlet?option=queryMenuById&mid=${a.menuId}" class="card_btn">现在去购买</a>
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        </c:if>
                                                    </c:forEach>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div id="salad" class=" tab-pane fade">
                                    <div class="content_row">
                                        <div class="left_cntbar">
                                            <div class="pizza_items">
                                                <div class="row">
                                                    <c:forEach items="${allMenuList}" var="a">
                                                        <c:if test="${a.category.menuTypeId == '3'}">
                                                            <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
                                                                <div class="P_itmesbox">
                                                                    <div class="PT_image"><img src="${pageContext.request.contextPath}/${a.menuPhoto}" class="absoImg" alt=""></div>
                                                                    <div class="PT_dscr">
                                                                        <h3 class="PT_title">${a.menuName}</h3>
                                                                        <p class="PT_dtls"> ${fn:substring(a.menuIntroduction,0,27)}...
                                                                        </p>

                                                                        <div class="price_block">
                                                                            <div class="price">${a.menuRetail}</div>
                                                                            <a href="${pageContext.request.contextPath}/MenuServlet?option=queryMenuById&mid=${a.menuId}" class="card_btn">现在去购买</a>
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        </c:if>
                                                    </c:forEach>


                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div id="fries" class=" tab-pane fade">
                                    <div class="content_row">
                                        <div class="left_cntbar">
                                            <div class="pizza_items">
                                                <div class="row">
                                                    <c:forEach items="${allMenuList}" var="a">
                                                        <c:if test="${a.category.menuTypeId == '4'}">
                                                            <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
                                                                <div class="P_itmesbox">
                                                                    <div class="PT_image"><img src="${pageContext.request.contextPath}/${a.menuPhoto}" class="absoImg" alt=""></div>
                                                                    <div class="PT_dscr">
                                                                        <h3 class="PT_title">${a.menuName}</h3>
                                                                        <p class="PT_dtls"> ${fn:substring(a.menuIntroduction,0,27)}...
                                                                        </p>

                                                                        <div class="price_block">
                                                                            <div class="price">${a.menuRetail}</div>
                                                                            <a href="${pageContext.request.contextPath}/MenuServlet?option=queryMenuById&mid=${a.menuId}" class="card_btn">现在去购买</a>
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        </c:if>
                                                    </c:forEach>


                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                                <div id="drinks" class=" tab-pane fade">
                                    <div class="content_row">
                                        <div class="left_cntbar">
                                            <div class="pizza_items">
                                                <div class="row">
                                                    <c:forEach items="${allMenuList}" var="a">
                                                        <c:if test="${a.category.menuTypeId == '5'}">
                                                            <div class="col-lg-4 col-md-6 col-sm-6 col-xs-12">
                                                                <div class="P_itmesbox">
                                                                    <div class="PT_image"><img src="${pageContext.request.contextPath}/${a.menuPhoto}" class="absoImg" alt=""></div>
                                                                    <div class="PT_dscr">
                                                                        <h3 class="PT_title">${a.menuName}</h3>
                                                                        <p class="PT_dtls"> ${fn:substring(a.menuIntroduction,0,27)}...
                                                                        </p>

                                                                        <div class="price_block">
                                                                            <div class="price">${a.menuRetail}</div>
                                                                            <a href="${pageContext.request.contextPath}/MenuServlet?option=queryMenuById&mid=${a.menuId}" class="card_btn">现在去购买</a>
                                                                        </div>
                                                                    </div>

                                                                </div>
                                                            </div>
                                                        </c:if>
                                                    </c:forEach>


                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Our Menu section -->
    <!-- Quick Order Section -->
    <section>
        <div class="quick_order">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="main_quickorder">
                            <h3 class="title">Call Us for Quick Order</h3>
                            <div class="cntct typewriter-effect"><span class="call_desk"><a href="tel:+01234567890" id="typewriter_num"></a></span></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Quick Order Section -->
    <!-- Footer Section here -->
    <footer>
        <div class="main_footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="M_footer">
                            <div class="col-lg-3 col-md-3 col-sm-6 col-xs-12 quick_links">
                                <div class="title">Quick Links</div>
                                <div class="main_cnt">
                                    <ul>
                                        <li><a href="about.html" class="trans" title="About us">About us</a></li>
                                        <li><a href="faq.html" class="trans" title="Faq">Faq</a></li>
                                        <li><a href="contactus.html" class="trans" title="Contacts">Contacts</a></li>
                                        <li><a href="备份/login.html" class="trans" title="Login">Login</a></li>
                                        <li><a href="备份/login.html" class="trans" title="Register">Register</a></li>
                                        <li><a href="terms_conditions.html" class="trans" title="Terms and conditions">Terms and conditions</a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-lg-5 col-md-5 col-sm-6 col-xs-12 location">
                                <div class="title">Our Location</div>
                                <div class="main_cnt"> <span class="address"><a href="#">234 Main Street, Uni 01, New Mexico City</a></span> <span class="time1">Mon - Fri: 08:00 am - 10:00 pm</span> <span class="time2">Sat - Sun: 10:00 am - 11:00 pm<strong></strong></span> <span class="conact"><a href="tel:+01234567890">+01 (234) 56 56 789</a></span> </div>
                            </div>
                            <div class="col-lg-4 col-md-4 col-sm-6 col-xs-12 subscribe">
                                <div class="title">Subscribe Us</div>
                                <div class="main_cnt">
                                    <p class="sbcr_label">Subscribe to the La Vie newsletter to
                                        <br> get regular update about offers
                                    </p>
                                    <form method="post" id="subscribeform" action="thank-you.html">
                                        <div class="sbcrb_input">
                                            <input type="text" name="subscribeemail" class="form-control" placeholder="Enter your email">
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
                <p>© <a href="index.html" class="trans" title="Crave Ordering">Crave Ordering</a> 2019, All rights reserved </p>
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
