<%-- 
    Document   : homepage
    Created on : Jun 3, 2020, 4:44:32 PM
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
        <title>Home Page</title>
    </head>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <div class="container">
            <div class="main-page">
                <div class="big-image">
                    <img src="resource/img/slider_1.jpg" salt=""　height="400" width="100%"/>
                </div>
                <div class="author-card">
                    <c:set var="authorlist" value="${requestScope.listAuthor}" />
                    <div class="titlt-author-card">
                        TÁC GIẢ NỔI BẬT
                    </div>
                    <div class="row">
                        <c:forEach var="author" items="${authorlist}">
                            <div class="author">
                                <div class="author-image">
                                    <img src="${author.authorImage}" style="width:89px;height:100px;" />
                                </div>
                                <div class="author-name">
                                    ${author.authorName}
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
                <c:set var="listBook" value="${requestScope.listBook}"/>
                <div class="category-card">
                    <div class="title-category-card">
                        Các tác phẩm nổi bật
                    </div>
                    <div class="row">
                        <c:forEach var="book" items="${listBook}">
                            <div class="book-card">
                                <a href="showDetailBookServlet?txtBookID=${book.bookID}">
                                <div class="book-image">
                                    <img src="${book.bookImage}" height="150px;" width="50%"/>
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
        </div>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>
