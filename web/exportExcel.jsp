<%-- 
    Document   : exportExcel
    Created on : Jul 7, 2020, 3:13:49 PM
    Author     : ADMIN
--%>

<%@page import="java.sql.Time"%>
<%@page import="com.sun.org.apache.xalan.internal.lib.ExsltDatetime"%>
<%@page import="java.util.List"%>
<%@page import="minhnlt.statisticObj.StatisticDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Statistic Book</h1>
        <table cellpadding="1"  cellspacing="1" border="1" bordercolor="gray">
            <tr>
                <th scope="col">Book Name</th>
                <th scope="col">Quantity</th>
                <th scope="col">User Name</th>
                <th scope="col">UserID</th>
                <th scope="col">Rent Date</th>
                <th scope="col">Return Date</th>
            </tr>
            <%
               
                List<StatisticDTO> list = (List<StatisticDTO>) session.getAttribute("listStatistic");
                
                if (list != null) {
                    response.setContentType("application/vnd.ms-excel");
                    response.setHeader("Content-Disposition", "inline; filename=" + "bookreport" + java.time.LocalDateTime.now() + ".xls");
                }
                for (StatisticDTO dto : list) {
            %>
            <tr>
                <td><%=dto.getBookName() %></td>
                <td><%=dto.getQuantity() %></td>
                <td><%=dto.getFullName() %></td>
                <td><%=dto.getUserID() %></td>
                <td><%=dto.getRentDate() %></td>
                <td><%=dto.getReturnDate() %></td>
                
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
