<%-- 
    Document   : headerAdminPage
    Created on : Jun 24, 2020, 1:55:54 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <style>
            <%@include file="../resource/css/bootstrap.min.css" %>
            <%@include file="../resource/css/mycss.css" %>
        </style>
        <script src="https://kit.fontawesome.com/9a588d95f0.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="top-bar">
            <div class="welcome-card">
                    Welcome to our website, ${sessionScope.USER.userFullName}
            </div>
            <a class="logout-div" href="LogoutServlet?">Logout</a>
            <a href="LoadAdminPageServlet?">
            <div class="welcome-card txt-center cl-white">
                Book Library
            </div>
            </a>
        </div>
    </body>
</html>
