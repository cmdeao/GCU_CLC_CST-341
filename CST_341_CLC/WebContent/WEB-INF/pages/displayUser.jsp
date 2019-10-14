<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Registered!</title>
</head>
<body>
Thank you for registering your account!
<table>
<tr>
<td>First Name:</td>
<td>${firstName}</td>
<td>Last Name: ${lastName}</td>
<td>Email Address: ${emailAddress}</td>
<td>Phone Number: ${phoneNumber}</td>
<td>Username: ${username}</td>
<td>Password: ${password}</td>
</tr>
</table>
</body>
<%@ include file ="footer.jsp" %>
</html>