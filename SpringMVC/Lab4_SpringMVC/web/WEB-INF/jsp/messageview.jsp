<%-- 
    Document   : messageview
    Created on : Feb 10, 2018, 2:54:55 PM
    Author     : krapa
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Message View</h1>
        <table border="1">
            <tr>
                <th>Message Id</th>
                <th>User Name</th>
                <th>From User</th>
                <th>Message</th>
                <th>Message Date</th>
                
            </tr>
        <c:forEach items="${requestScope.messagelist}" var="msg">
            <tr>
                <td> ${msg.messageId}</td>
                <td>${msg.userName}</td>
                <td>${msg.fromUser}</td>
                <td>${msg.message}</td>
                <td>${msg.messageDate}</td>

            </tr>
        </c:forEach>
        </table>
    </body>
</html>
