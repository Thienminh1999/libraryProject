<%-- 
    Document   : menu-side
    Created on : Jun 8, 2020, 1:43:06 PM
    Author     : ADMIN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>

            <%@include file="../resource/css/mycss.css" %>
        </style>
        <script src="https://kit.fontawesome.com/9a588d95f0.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="left-side-card">
            <div class="filter-card">
                <div class="title-sub-menuside">
                    Danh mục sách
                </div>
                <c:set var="listCategory" value="${sessionScope.listCategory}"/>
                <c:forEach var="category" items="${listCategory}">
                    <div class="category-item">
                        ${category.categoryName}
                    </div>
                </c:forEach>    
            </div>
            <div class="filter-card">
                <div class="title-sub-menuside">
                    Tác giả
                </div>
                <c:set var="listAllAuthor" value="${sessionScope.listAllAuthor}"/>
                 <c:forEach var="author" items="${listAllAuthor}">
                    <div class="category-item">
                        ${author.authorName}
                    </div>
                </c:forEach> 
            </div>
        </div>
    </body>
</html>
