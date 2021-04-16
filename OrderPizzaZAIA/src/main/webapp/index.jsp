<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page isELIgnored= "false" %>--%>
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
    <title>Home page | Order Online Fast Food & Pizza</title>
    <!-- Fonts Here-->
    <link href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i" rel="stylesheet" >
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab:100,300,400,700" rel="stylesheet">
    <!-- Fonts here-->

    <!-- Style Here -->
    <link rel="stylesheet" href="css/slick.css" >
    <link rel="stylesheet" href="css/style.css" >
    <link rel="stylesheet" href="css/my-account.css" >
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

    <!-- popular our food start here -->
    <section>
        <div class="popular">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="main_popular">
                            <h2 class="title">本月推荐</h2>
                            <!--                                <p class="desc">Choose from over 30 craveable toppings to make your perfect Food.-->
                            <!--                                    <br> Don’t love what you ordered? Let us know. We’re all about second chances.</p>-->
                            <div class="p_card">
                                <div class="row">
    <%--                            商品显示--%>
                                <c:forEach items="${newList}" var="m">
                                    <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                        <ul>
                                            <li>
                                                <div class="card">
                                                    <div class="C_img"> <img src="${pageContext.request.contextPath}/${m.menuPhoto}" class="absoImg" alt=""> </div>
                                                    <div class="C_desc">
                                                        <h3 class="title">${m.menuName}</h3>
                                                        <p class="desc">${fn:substring(m.menuIntroduction,0,15)}...</p>
<%--                                                        <p class="desc">sgsgrsgrsgrfgvg</p>--%>
                                                        <div class="price_block">
                                                            <div class="price">￥ ${m.menuRetail}</div>
                                                            <a href="${pageContext.request.contextPath}/MenuServlet?option=queryMenuById&mid=${m.menuId}" class="card_btn">现在去购买</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                                    </div>
                                </c:forEach>

    <%--                            商品显示-end--%>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- popular our food start here -->

    <!-- 客户反馈client feedback start here -->
    <section>
        <div class="client_say">
            <div class="main_client">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <div class="middle_Cpitch">
                                <h2 class="title">顾客怎么说</h2>
                                <div class="testi_slider">
                                    <div>
                                        <p class="desc"><span class="double_quat"></span>I ordered Pizza for the first time & I’m so glad I did! I Can’t wait till I order again. Thick, tasty,
                                            <br>absolutely delicious Pizza! The gal taking my order was so nice as well. <span class="double_quat2"></span></p>
                                        <div class="sign"> <span class="name">Paulette Pettry</span>
                                            <span class="Desig">CEO</span> </div>
                                    </div>
                                    <div>
                                        <p class="desc"><span class="double_quat"></span>Wow I have found a great pizza place. They brought me a great pizza and the guy that delivered
                                            <br> my pizza was a cool dude. Thanks for the great pizza. I recommend to everyone.<span class="double_quat2"></span></p>
                                        <div class="sign"> <span class="name">Jhon Walker</span> <span class="Desig">CEO</span> </div>
                                    </div>
                                    <div>
                                        <p class="desc"><span class="double_quat"></span>Great pizza. Tastes so fresh and original. Beats any of the chains hands down.
                                            <br> I was so glad to hear Mike’s was opening in Oregon and now it is a wonderful reality.
                                            <br> Give them a try, you won’t be sorry! <span class="double_quat2"></span></p>
                                        <div class="sign"> <span class="name">Glenn Cook</span> <span class="Desig">CEO</span> </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- client feedback end here -->


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
<script src="js/custome.js" defer></script>
<script src="js/slick.js" defer></script>
<script src="js/jquery.validate.min.js" defer></script>
<!-- JS Here -->
</body>

</html>