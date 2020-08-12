<%-- 
    Document   : thankyou
    Created on : Jun 29, 2020, 10:52:09 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thank you Page</title>
    </head>
    <body>
         <jsp:include page="layout/header.jsp"/>
         <div class="container">
         <h2> Thank you for using our service </h2>
         <br>
         <h5>Click <a href="LoadHomePageServlet?">here</a> to return homepage</h5>
         <br>
         </div>
         <jsp:include page="layout/footer.jsp"/>
    </body>
</html>
