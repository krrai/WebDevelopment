<%-- 
    Document   : addBooks
    Created on : Feb 22, 2018, 6:56:17 PM
    Author     : Jigar
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body align="center">
        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
        <br/><br/>
        <h1 align="center">Add Books</h1>
        <form action="${contextPath}/books/addResult.htm" method="post">
            <table border="1" align="center">
                <tr>
	                <th>ISBN</th>
	                <th>Title</th>
	                <th>Authors</th>
	                <th>Price</th>
                </tr>
                <c:forEach begin="1" end="${count}" step="1">
                    <tr>
                        <td><input type="text" name="isbn" /></td>
                        <td><input type="text" name="title" /></td>
                        <td><input type="text" name="authors" /></td>
                        <td><input type="text" name="price" /></td>
                    </tr>
                </c:forEach>
                    <tr><td colspan="4" align="center"><input type="submit" value="Add Books" /></td></tr>
            </table>
                
        </form>
    </body>
</html>
