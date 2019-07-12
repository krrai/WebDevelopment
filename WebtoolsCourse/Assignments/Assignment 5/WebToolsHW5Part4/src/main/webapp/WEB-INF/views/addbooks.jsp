<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Books Details</title>

    </head>
    <body>
        <form method="post" action="addbooks.htm">
            <br/><br/>
            <c:set var = "n" value = "${sessionScope.numberBooks}" />
            <c:choose >
                <c:when test="${empty n}"> Data cannot be added as input is ${n}</c:when>
                <c:otherwise>
                    <table border="1" cellpadding="9" >
                        <tr>
                            <th>ISBN:</th>
                            <th>Book Title:</th>
                            <th>Authors:</th>
                            <th>Price:</th>
                        </tr>
                        <c:forEach var="i" begin="0" end="${n-1}" >
                            <tr>
                                <td><input type="text" name="isbn"/></td>
                                <td><input type="text" name="title"/></td>
                                <td><input type="text" name="authors"/></td>
                                <td><input type="text" name="price"/></td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:otherwise>
            </c:choose>
            <input type="hidden" name="action" value="add" />
            <input type="hidden" name="number" value="${n}" />
            <br/>
            <br/>
            <input type="submit" value="Add Books" style="position: relative; left:330px; height: 25px; font-size: 15px;"/>
            <a href="index.jsp">Go to the main page</a>
        </form>
        
    </body>
</html>