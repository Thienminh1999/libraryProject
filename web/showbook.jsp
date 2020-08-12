<%-- 
    Document   : showbook
    Created on : Jun 8, 2020, 2:46:51 PM
    Author     : ADMIN
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Show book Page</title>
    </head>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <div class="container">
            <div class="title-menuside">Tất cả sách</div>
            <jsp:include page="layout/menu-side.jsp"/>
            <c:set var="listAllBook" value="${requestScope.listAllBook}"/>
            <div class="show-book-side">
                <div class="row margin-20px">
                    <c:forEach var="book" items="${listAllBook}">
                        <div class="book-card margin-44px">
                            <a href="showDetailBookServlet?txtBookID=${book.bookID}">

                                <input type="hidden" name="txtBookID" value="${book.bookID}" />
                                <div class="book-image">
                                    <img src="${book.bookImage}" height="150px;" width="60%"/>
                                </div>
                                <div class="book-name cl-black">
                                    ${book.bookName}
                                </div>
                                

                            </a>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>
