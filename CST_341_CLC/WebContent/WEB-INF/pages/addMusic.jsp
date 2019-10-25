<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@include file ="header.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Song</title>
</head>

<style><
	.error{
		color: #ff0000;
	}
	.errorblock{
		color: #000;
		background-color: #ffEEEE;
		border: 3px solid #ff0000;
		padding: 8px;
		margin: 16px;
	}
	form{
		text-align: center;
	}
	body{
		text-align: center;
	}
</style>

<body>
<br>
<br>
<font size="+2">Create a New Song for the Database!</font>
<!-- CHANGED action = "displayUserDB" to a different post action to see a different page -->
<form:form method="POST" action = "added" modelAttribute="product">
<form:errors path ="*" cssClass = "errorblock" element = "div"/>
<label>Song Name: </label>
<form:input path="songName"/>
<td><form:errors path = "songName" cssClass = "error"/></td>
<br>
<label>Band/Artist Name: </label>
<form:input path = "artistName"/>
<td><form:errors path = "artistName" cssClass = "error"/></td>
<br>
<label>Song Genre: </label>
<form:input path = "songGenre"/>
<td><form:errors path = "songGenre" cssClass = "error"/></td>
<br>
<label>Album Name: </label>
<form:input path = "albumName"/>
<td><form:errors path = "albumName" cssClass = "error"/></td>
<br>
<label>Song Length:</label>
<form:input path = "songLength"/>
<td><form:errors path = "songLength" cssClass = "error"/></td>
<br>
<input type = "submit" value = "Submit"/>
</form:form>
</body>
<%@ include file ="footer.jsp" %>
</html>