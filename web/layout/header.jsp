<%-- 
    Document   : header
    Created on : Jun 4, 2020, 7:43:20 AM
    Author     : ADMIN
--%>

<%@page import="minhnlt.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            <%@include file="../resource/css/bootstrap.min.css" %>
            <%@include file="../resource/css/mycss.css" %>
            <%@include file="../resource/js/myjs.js" %>
            <%@include file="../resource/js/bootstrap.bundle.min.js" %>
            <%@include file="../resource/js/bootstrap.js" %>

        </style>
        <script src="https://kit.fontawesome.com/9a588d95f0.js" crossorigin="anonymous"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Header Page</title>
    </head>
    <body>

        <div class="my-header">
            <div class="header-topbar">
                <div class="welcome-card">
                    Welcome to our website, ${sessionScope.USER.userFullName}
                </div>
                <div class="contact-card">
                    Facebook
                </div>
            </div>
            <div class="header-middlebar">
                <a href="LoadHomePageServlet?">
                <div class="title-card">
                    Book Library
                </div>
                </a>
                <form action="MainController">
                    <div class="header-search-card">
                        <div class="input-group mb-3">
                            <%
                                String lastSearchValue = request.getParameter("txtSearchValue");
                                session.setAttribute("lastSearchValue", lastSearchValue);
                            %>
                            <input type="text" name="txtSearchValue" class="form-control" placeholder="nhập cuốn sách bạn muốn tìm" >
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary" value="SearchBook" name="btnAction"><i class="fa fa-search"></i></button>
                            </div>
                        </div>
                    </div>
                </form>
                <div class="account-card">
                    <a href="LogoutServlet?" >Logout</a>
                </div>
                <div class="shopping-cart ">
                    <a href="loadCartPageServlet?" class="cl-white">
                        <i class="fa fa-shopping-cart fa-2x"></i>
                        <div class="cart-infor">

                            <div class="name-cart">
                                Giỏ hàng
                            </div>
                            <div class="quantity-cart">
                                <%
                                    CartObj cart = (CartObj) session.getAttribute("CART");
                                    if (cart == null) {
                                %>
                                0
                                <%
                                } else {
                                %>
                                ${sessionScope.CART.getCart().size()}
                                <%
                                    }
                                %>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
        <div class="container">
            <div class="category-bar">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <div class="collapse navbar-collapse" id="navbarText">
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item active margin-10px">
                                <a class="nav-link" href="LoadHomePageServlet?">Home<span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item margin-10px">
                                <a class="nav-link" href="#">Giới thiệu</a>
                            </li>
                            <li class="nav-item margin-10px">
                                <a class="nav-link" href="loadBookPageServlet?">Sản phẩm</a>
                            </li>
                            <li class="nav-item margin-10px">
                                <a class="nav-link" href="#">Liên hệ</a>
                            </li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>


    </body>
</html>
