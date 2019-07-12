<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to our Movie Store</h1>
        <p>Please make your selection below </p>
        
        <form method="post" action="select.htm">
        <select name="select">
            <option value="browse">Browse Movies</option>
            <option value="add">Add New Movies to Database</option>
        </select>
    <input type="Submit" value="Send">
</form>
</body>
</html>