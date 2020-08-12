<%-- 
    Document   : detailbook
    Created on : Jun 8, 2020, 6:09:20 PM
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
        <script>
            function hiddenDiv() {
                //document.getElementsByClassName(notify-succes).style.display = "hidden";
                setTimeout(function(){ document.getElementsByClassName(notify-succes).style.display = "hidden"; }, 3000);
            }
           
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail book Page</title>
    </head>
    <body>
        <jsp:include page="layout/header.jsp"/>
        <c:set var="bookDetail" value="${requestScope.detailBook}"/>
        
        <c:set var="checkAddComplete" value="${sessionScope.checkAddComplete}"/>
        <c:if test="${checkAddComplete == true}">
        <div class="notify-succes alert-success">
             <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
            Add to cart success!
        </div>
        </c:if>
        <c:if test="${checkAddComplete == false}" >
        <div class="notify-danger alert-danger">
             <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
            Something wrong, we can not add this book to cart
        </div>
       </c:if>

        <div class="container">
            <div class="book-detail">
                <div class="book-detail-img">
                    <img src="${bookDetail.bookImage}" class="mg-left-80px mg-top-50px" height="400px;" width="60%"/>
                </div>
                <div class="book-detail-content">
                    <div class="name-detail">
                        <div class="book-name-detail">  
                            ${bookDetail.bookName}
                        </div>
                        <div class="name-author">
                            <c:if test="${requestScope.authorName != null}">
                            Tác giả: ${requestScope.authorName}
                            </c:if>
                            <c:if test="${requestScope.authorName == null}">
                            Tác giả: Đang cập nhật
                            </c:if>
                        </div>
                    </div>
                    <div class="price-detail">
                        <div class="btn-shopping">
                            <form action="MainController">
                                <input type="hidden" name="txtBookId" value="${bookDetail.bookID}" />
                                Quantity: <input type="number" name="txtQuantity" value="${bookDetail.quantity}" />
                                <button type="submit" name="btnAction" value="AddToCart" class="btn btn-warning mg-top-20px">Thêm vào giỏ hàng</button>
                            </form>
                        </div>
                    </div>
                    <div class="other-detail">
                        Kích thước: ${bookDetail.size} <br>
                        Loại bìa:  ${bookDetail.typeOfCover}<br>
                        Số trang:  ${bookDetail.pageNumber}<br>
                        Nhà xuất bản: ${bookDetail.publisher}<br>
                        Ngày xuất bản: ${bookDetail.publicDate}<br>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>
