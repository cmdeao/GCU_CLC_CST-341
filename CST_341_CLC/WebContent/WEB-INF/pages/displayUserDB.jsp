<%@ page language="java" contentType="text/html; charset=ISO-8859-1"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

     <sql:setDataSource dataSource="jdbc/SampleDB" />

        <!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
        <html>
        <head>
        <title>Music Management Application</title>
        </head>
        <body>

        <h1>Music Management Application</h1>

        Welcome to the application! 
		<h2>Registed Users</h2>
		<table border='1'>
			<tr><th>First Name</th><th>Last Name</th>
			<th>Email Address</th><th>Phone Number</th>
			<th>Username</th><th>Password</th></tr>
		<sql:query var="qryUsers" >
				SELECT firstName, lastName, emailAddress, phoneNumber, username, password FROM app.users
		</sql:query>
		        <c:forEach var="row" items="${qryUsers.rows}">
        	<tr>
        		<td><c:out value="${row.firstName}" /></td>
        		<td><c:out value="${row.lastName}"/></td>
        		<td><c:out value="${row.emailAddress}"/></td>
        		<td><c:out value="${row.phoneNumber}"/></td>
        		<td><c:out value="${row.username}"/></td>
        		<td><c:out value="${row.password}"/></td>
        	</tr>
        </c:forEach>
		</table>
        </body>
        <%@ include file ="footer.jsp" %>
        </html>