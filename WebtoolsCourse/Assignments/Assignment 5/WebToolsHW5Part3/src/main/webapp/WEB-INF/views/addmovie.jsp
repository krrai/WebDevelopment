<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Movie Page</title>
</head>
<body>
	<h1>Please Enter the details below</h1>
	<form action="addmovie" method="post">
        
            
        <font size=5 color="red">
        Movie Title <input type="text" name="title"/> <br/><br/>
        Lead Actor <input type="text" name="actor"/> <br/><br/>
        Lead Actress <input type="text" name="actress"/> <br/><br/>
        Genre <input type="text" name="genre"/> <br/><br/>
        Year <input type="text" name="year"/> <br/><br/>
        </font>
        <input type="submit" value="Add Movie"/> 
    </form>
    </body>
</body>
</html>