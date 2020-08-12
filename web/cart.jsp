<%-- 
    Document   : cart
    Created on : Jun 11, 2020, 11:52:16 AM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="minhnlt.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            <%@include file="resource/css/bootstrap.min.css" %>
            <%@include file="resource/css/mycss.css" %>
        </style>
        <script src="https://kit.fontawesome.com/9a588d95f0.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <div class="container">
            <%
                CartObj cart = (CartObj) session.getAttribute("CART");
                if (cart == null || cart.getCart().size() == 0) {
            %>
            <div class="title-menuside">Giỏ hàng không có sản phẩm </div>
            <%
            } else {
            %>
            <c:set var="listBook" value="${sessionScope.CART.getCart().values()}"/>
            <div class="title-menuside">Giỏ hàng</div>
            <div class="main-content-80">
                <div class="row">
                    <c:forEach var="book" items="${listBook}">
                        <div class="book-in-cart">
                            <form action="MainController">
                                <div class="img-book-cart">
                                    <img src="${book.bookImage}" style="height: 180px;width: 75%"/>
                                </div>
                                <div class="book-content-cart">
                                    ${book.bookName}
                                </div>
                                <div class="book-edit">
                                    <input type="hidden" name="txtBookId" value="${book.bookID}" />
                                    <button type="submit" name="btnAction" value="DeleteBook" class="btn btn-danger">Xóa</button>
                                    <input type="text" name="txtQuantity" value="${book.quantity}" readonly="true" />
                                    <div class="edit-quantity">
                                        <a href="DecreaseQuantityServlet?txtBookId=${book.bookID}">
                                            <div class="edition cl-black">
                                                -  
                                            </div>
                                        </a>
                                        <a href="IncreaseQuantityServlet?txtBookId=${book.bookID}">
                                            <div class="edition cl-black">
                                                +  
                                            </div>
                                        </a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <div class="check-out">
                <a href="CheckOutServlet?" >
                <div class="button-check-out btn-success">
                    CHECK OUT
                </div>
                </a>
            </div>
            <div class="empty-div"></div>
            <%
                }
            %>


        </div>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>
