<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ include file = "header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<sql:setDataSource dataSource="jdbc/SampleDB"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Music Database</title>
</head>
<body>
<h2>Collection of Music within the Database!</h2>
<table border='1' align="center">
	<tr>
		<th>Song Name</th>
		<th>Band/Artist Name</th>
		<th>Album Name</th>
		<th>Song Length</th>
		<th>Song Genre</th>
	</tr>
	
	<c:if test="${not empty list }">
		<c:forEach items="${list}" var="list">
			<tr>
				<td><c:out value="${list.songName}"/></td>
				<td><c:out value="${list.artistName}"/></td>
				<td><c:out value="${list.albumName}"/></td>
				<td><c:out value="${list.songLength}"/></td>
				<td><c:out value="${list.songGenre}"/></td>
			</tr>
		</c:forEach>
	</c:if>
</table>

<!-- <table border ='1' align="center">
	<tr>
		<th>Song Name</th>
		<th>Band/Artist Name</th>
		<th>Album Name</th>
		<th>Song Length</th>
		<th>Song Genre</th>
	</tr>
	
	<sql:query var="qryMusic">
		SELECT songName, artistName, albumName, songLength, songGenre FROM app.music
	</sql:query>
	
	<c:forEach var="row" items="${qryMusic.rows }">
		<tr>
			<td><c:out value="${row.songName}" /></td>
			<td><c:out value="${row.artistName}" /></td>
			<td><c:out value="${row.albumName}" /></td>
			<td><c:out value="${row.songLength}" /></td>
			<td><c:out value="${row.songGenre}" /></td>
		</tr>
	</c:forEach>
</table>  --> 
</body>
<%@ include file ="footer.jsp" %>
</html>