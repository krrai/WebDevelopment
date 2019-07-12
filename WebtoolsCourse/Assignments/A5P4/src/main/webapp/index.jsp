<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
    	<%if(request.isUserInRole("asgn5p4")){%>
	        <c:set var="contextPath" value="${pageContext.request.contextPath}" />
	        <form action="${contextPath}/count.htm" method="get">
	            <h3>How many books do you want to add?</h3>
	            <input type="text" name="count"/>
	            <input type="submit" value="Submit"/>
	        </form>
	    <%} %>
        <% if(!request.isUserInRole("asgn5p4")){%>
        	User: ${requestScope.isAsgn5p4} <br/>
			You do not have access! Please request Access from Administrator and Try Again!
        <%} %>
        <c:if test="${requestScope.errorMessage ne null }">
        	<label style="color:red;">Enter digits 0-9 only!</label>
        </c:if>
    </body>
</html>
