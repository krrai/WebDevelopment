<%-- 
    Document   : result
    Created on : Feb 23, 2018, 3:31:36 AM
    Author     : Jigar
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
   	    <c:set var="contextPath" value="${pageContext.request.contextPath}" />
	    
    	<c:if test="${requestScope.errorMessage eq null}">
	        <h3>${count} books added successfully!</h3>
	        <br />
        </c:if>
        
        <c:if test="${requestScope.errorMessage ne null}">
        	<h2><label style="color:red;">Error: ${requestScope.errorMessage}</label></h2>
        </c:if>
        
        <br/><br/>
        <a href="${contextPath}">Click Here to go back to Homepage!</a>
	
    </body>
</html>
