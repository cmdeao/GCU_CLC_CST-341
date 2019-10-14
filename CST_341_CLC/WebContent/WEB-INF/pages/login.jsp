<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Member</title>
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
<font size="+2">Please Login to Continue:</font>
<form:form method="POST" action = "main" modelAttribute="user">
<form:errors path ="*" cssClass = "errorblock" element = "div"/>
<label>Username: </label>
<form:input path = "username"/>
<td><form:errors path = "username" cssClass = "username"/></td>
<br>
<label>Password: </label>
<form:input type = "password" path = "password"/>
<td><form:errors path = "password" cssClass = "password"/></td>
<br>
<input type = "submit" value = "Submit"/>
</form:form>
</body>
<%@ include file ="footer.jsp" %>
</html>