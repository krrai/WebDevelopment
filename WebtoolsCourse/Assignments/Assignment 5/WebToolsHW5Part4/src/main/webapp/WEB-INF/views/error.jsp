<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
    </head>
    <body>
        <h1>Something went wrong</h1>
        <h3>${sessionScope.errorMsg}</h3>
         <a href="addbboks.jsp"><< Back</a>
        <a href="index.jsp">Go to the main page</a>
    </body>
</html>
