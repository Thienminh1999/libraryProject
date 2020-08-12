<%-- 
    Document   : createNewBook
    Created on : Jun 24, 2020, 1:53:19 PM
    Author     : ADMIN
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <title>Create new book Page</title>
    </head>
    <body>
        <jsp:include page="layout/headerAdminPage.jsp"/>
        <div class="container">
            <div class="title-bar mg-top-20px">
                Add new book
            </div>
            <div class="form-card">
                <c:set var="listCategory" value="${requestScope.listCategory}"/>
                <c:set var="error" value="${requestScope.ERROR}"/>
                <c:set var="book" value="${requestScope.BOOK}"/>
                <form action="MainController">
                    <div class="form-row">
                        <div class="form-group col-md-3">
                            <label for="inputEmail4">BookID*</label>
                            <input class="form-control" name="txtBookID" placeholder="BookID" value="${book.bookID}">
                            <p style="color:red">${error.bookIDError} </p> 
                        </div>
                        <div class="form-group col-md-9">
                            <label for="inputPassword4">Book name*</label>
                            <input class="form-control" name="txtBookName" placeholder="Book name" value="${book.bookName}">
                            <p style="color:red">${error.bookNameError}</p>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-3">
                            <label for="inputPassword4">Public Date*</label>
                            <input class="form-control datepicker" name="txtPublicDate" placeholder="Public Date" value="${book.publicDate}">
                            <p style="color:red">${error.publicDateError}</p>
                        </div>
                        <div class="form-group col-md-6">
                            <label for="inputEmail4">Publisher*</label>
                            <input class="form-control" name="txtPublisher" placeholder="Publisher" value="${book.publisher}">
                            <p style="color:red">${error.publisherError}</p>
                        </div>
                        <div class="form-group col-md-3">
                            <label for="inputPassword4">Category*</label>
                            <select class="custom-select col-md-12" id="validationDepartment" name="txtCategory">
                                <option value=""></option>
                                <c:forEach var="category" items="${listCategory}">
                                    <option value="${category.categoryID}">${category.categoryName}</option>
                                </c:forEach>
                            </select>
                            <p style="color:red">${error.categoryIDError}</p>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group col-md-3">
                            <label for="inputPassword4">Quantity*</label>
                            <input class="form-control" name="txtQuantity" placeholder="Quantity" value="${book.quantity}">
                            <p style="color:red">${error.quantityError}</p>
                        </div>
                        <div class="form-group col-md-3">
                            <label for="inputEmail4">Size</label>
                            <input class="form-control" name="txtSize" placeholder="Size" value="${book.size}">
                        </div>
                        <div class="form-group col-md-3">
                            <label for="inputPassword4">Type Of Cover</label>
                            <input class="form-control" name="txtTypeOfCover" value="" placeholder="Type Of Cover" value="${book.typeOfCover}">
                        </div>
                        <div class="form-group col-md-3">
                            <label for="inputPassword4">Page number</label>
                            <input class="form-control" name="txtPageNumber" placeholder="Page number" value="${book.pageNumber}">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="inputPassword4">Description</label>
                        <textarea name="txtDescription" rows="10" cols="155" value="${book.descriptions}"></textarea>
                    </div>
                    <div class="form-group row">
                        <div class="col-sm-10">
                            <button type="submit" name="btnAction" value="CreateNewBook" class="btn btn-primary">Add book</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <jsp:include page="layout/footer.jsp"/>
    </body>
</html>
