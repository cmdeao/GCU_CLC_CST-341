<!DOCTYPE html>
<html>
<%@ include file ="header.jsp" %>
<head>
<title>Music Management Application</title>
<style>
body{
	text-align: center;
	ul-align: center;
}

ul{
	display: inline-block;
	list-style-type: none;
	margin: 0;
	padding: 0;
	width: 1600px;
	background-color: #f1f1f1;
	border: 10px solid #555;
}

li a{
	display: block;
	color: #000;
	padding: 8px 16px;
	text-decoration: none;
}

li{
	text-align: center;
	border-bottom: none;
}

li:last-child{
	border-bottom: none;
}

li a.active{
	background-color: #4CAF50;
}

li a:hover:not(.active){
	background-color: #555;
	color:white;
}

</style>
</head>
<body>
<h1>Music Management Application!</h1>
<br>
<br> 
<ul>
	<li><a href="addMusic">Add Music</a></li>
	<li><a href="removeMusic">Remove Music</a></li>
	<li><a href="createPlaylist">Create Playlist</a></li>
	<li><a href="viewMusic">View Music</a></li>
</ul>
</body>
<%@ include file ="footer.jsp" %>
</html>