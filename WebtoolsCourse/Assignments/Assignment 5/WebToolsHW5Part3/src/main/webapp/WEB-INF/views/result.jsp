<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
        Your Searched for ${sessionScope.moviename}<br/>
        <h2><c:out value="Here are the search results"></c:out><br/></h2>
        <%-- <c:if test="${(requestScope.map.movietype eq 'display')}">--%>
        
                
                <c:forEach items="${sessionScope.movieList}" var="movie">
                    <h3><th>Title : </th> ${movie.title}<br/>
                    <th>Actor : </th>${movie.actor}<br/>
                    <th>Actress : </th>${movie.actress}<br/>
                    <th>Genre : </th>${movie.genre}<br/>
                    <th>Year : </th>${movie.year}<br/>
                    
                        <td><a href="${contextPath}/register.htm">Click here to go back to the main page</a></td>
                     
                 </c:forEach>
        <%-- </c:if> --%>
</body>
</html>