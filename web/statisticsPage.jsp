<%-- 
    Document   : statisticsPage
    Created on : Jul 7, 2020, 1:57:39 PM
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
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <link rel="stylesheet" href="/resources/demos/style.css">
        <script src="https://kit.fontawesome.com/9a588d95f0.js" crossorigin="anonymous"></script>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
            $(function () {
                $(".datepicker").datepicker();
            });
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Statistics Page</title>
    </head>
    <body>
        <jsp:include page="layout/headerAdminPage.jsp"/>
        <div class="container">
            <div class="title-bar mg-top-20px">
                Book Information
            </div>
            <div class="search-bar height-auto">
                <form action="MainController">
                    <div class="form-row" >
                        <div class="form-group col-md-3">
                            <label>Rent Date From</label>
                            <input class="form-control datepicker" name="txtRentDateFrom" placeholder="Rent Date From" value="${param.txtRentDateFrom}">
                        </div>
                        <div class="form-group col-md-3">
                            <label>Rent Date To</label>
                            <input class="form-control datepicker" name="txtRentDateTo" placeholder="Rent Date To" value="${param.txtRentDateTo}">
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-3">
                            <button type="submit" name="btnAction" value="SearchAsDate" class="btn btn-primary">Search</button>
                        </div>
                    </div>
                    <div class="func-div">
                        <button type="submit" name="btnAction" value="ExportToExcel" class="btn btn-success float-right">Export excel</button>
                    </div>
                </form>
            </div>
            <div class="all-book-cart">
                <c:set var="listStatistic" value="${requestScope.listStatistic}"/>
                
                <c:if test="${not empty listStatistic}">
                    <table class="table table-borderless">
                        <thead>
                            <tr>
                                <th scope="col">#</th>
                                <th scope="col">Book Name</th>
                                <th scope="col">Quantity</th>
                                <th scope="col">User Name</th>
                                <th scope="col">UserID</th>
                                <th scope="col">Rent Date</th>
                                <th scope="col">Return Date</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="book" items="${listStatistic}" varStatus="counter">
                                <tr>
                                    <td>${counter.count}</td>
                                    <td>${book.bookName}</td>
                                    <td>${book.quantity}</td>
                                    <td>${book.fullName}</td>
                                    <td>${book.userID}</td>
                                    <td>${book.rentDate}</td>
                                    <td>${book.returnDate}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                <c:if test="${empty listStatistic}">
                    <h3>Don't have any book is match</h3>
                </c:if>
                
                
            </div>
        </div>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>
