<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Searching Movies</h1>
        <form ACTION=movieresult method="post">
            <BR>
            <font size=5 color="red">
        Keyword: <input type="text" name="query"/> <br/><br/>

        <input TYPE=radio name=searchby VALUE=title checked=""> Search by Title <BR>
        <input TYPE=radio name=searchby VALUE=actor> Search by Actor <BR>
        <input TYPE=radio name=searchby VALUE=actress> Search by Actress <BR>
        

	<br> <INPUT TYPE=submit name=submit Value="Submit">
	</font>
	</form>
        
</body>
</html>