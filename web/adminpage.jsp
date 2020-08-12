<%-- 
    Document   : adminpage
    Created on : Jun 3, 2020, 4:58:01 PM
    Author     : ADMIN
--%>

<%@page import="java.util.List"%>
<%@page import="minhnlt.tblBook.BookDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            <%@include file="resource/css/bootstrap.min.css" %>
            <%@include file="resource/css/mycss.css" %>
        </style>
        <script src="https://kit.fontawesome.com/9a588d95f0.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administrator Page</title>
    </head>
    <body>
        <jsp:include page="layout/headerAdminPage.jsp"/>
        <c:set var="checkInsert" value="${sessionScope.CheckInsert}"/>
        <c:if test="${checkInsert == true}">
            <div class="notify-succes alert-success top-40px">
             <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
                    Add new book success!
            </div>
        </c:if>
        <%
        session.setAttribute("CheckInsert", false);
        %>
        <c:set var="checkUpdate" value="${requestScope.CheckUpdate}"/>
        <c:if test="${checkUpdate == true}">
            <div class="notify-succes alert-success top-40px">
             <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
                    Update book success!
            </div>
        </c:if>
        <%
        session.setAttribute("CheckUpdate", false);
        %>
        <c:set var="checkDelete" value="${requestScope.CheckDelete}"/>
        <c:if test="${checkDelete == true}">
            <div class="notify-succes alert-success top-40px">
             <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span> 
                    Delete book success!
            </div>
        </c:if>
        <%
        session.setAttribute("CheckDelete", false);
        %>
        <div class="container">
            <div class="button-bar mg-top-20px">
                <form action="MainController">
                    <button type="submit" name="btnAction" value="ToStatisticsPage" class="btn btn-success">Statistic Book</button>
                    <button type="submit" name="btnAction" value="ToCreatePage" class="btn btn-primary">Create Book</button>
                </form>
            </div>
            <div class="search-bar">
                <form action="MainController">
                <div class="search-icon" id="padding-top-8px"><i class="fa fa-search"></i></div>
                <div class="seach-value">
                    <div class="col-sm-12">
                        <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" class="form-control-plaintext" placeholder="Tên cuốn sách bạn muốn tìm">
                    </div>
                    <input type="submit" value="SearchBookAdmin" name="btnAction" hidden="true" />
                </div>
                </form>
            </div>
            <div class="all-book-cart">
                <c:set var="listBook" value="${requestScope.listBook}"/>
                <c:if test="${not empty listBook}">
                    
                
                <table class="table table-borderless">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">BookID</th>
                            <th scope="col">BookName</th>
                            <th scope="col">Publisher</th>
                            <th scope="col">PublicDate</th>
                            <th scope="col">Action</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${listBook}" varStatus="counter">
                        <form action="MainController">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${book.bookID}</td>
                                <td>${book.bookName}</td>
                                <td>${book.publisher}</td>
                                <td>${book.publicDate}</td>
                                
                                <td>
                                    <input type="hidden" name="txtBookID" value="${book.bookID}" />
                                    <button class="btn-1" type="submit" name="btnAction" value="delete"><i class="fa fa-trash"></i></button>
                                    <button class="btn-1" type="submit" name="btnAction" value="infor"><i class="fa fa-info-circle"></i></button>
                                </td>
                            </tr>
                        </form>
                    </c:forEach>
                    </tbody>
                </table>
                <%
                int sizeList = (int) request.getAttribute("NumberOfPage");
                if(sizeList>1){
                    %>
                <div class="pagination-bar">
                    <nav aria-label="Page navigation example">
                        <ul class="pagination">
                            <%
                            int NumberOfPage =(int)request.getAttribute("NumberOfPage");
                            int pageNum = 0;
                            for(int i=1; i<=NumberOfPage; i++){
                                %>
                             <li class="page-item"><a class="page-link" href="LoadAdminPageServlet?PageNo=<%=pageNum%>"><%=i%></a></li>
                            <%
                                pageNum = pageNum + 10;
                            }
                            %>
                           
<!--                            <li class="page-item"><a class="page-link" href="loadAdminPage?PageNo=9">3</a></li>-->
                        </ul>
                    </nav>
                </div>
                <%
                }
                %>
                </c:if>
                <c:if test="${empty listBook}">
                    <h3>Không tìm thấy kết quả</h3>
                </c:if>
            </div>
        </div>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>
