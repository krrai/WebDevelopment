<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User View</h1>
        <!-- here we are making a foreach  loop for user list and our object is user. and now we will call all the attributes from the user class. -->
        <c:forEach items="${requestScope.userlist}" var="user">
            ${user.userId}
            ${user.fname}
            ${user.lname}
            ${user.email}
        </c:forEach>
        
        
    </body>
</html>
