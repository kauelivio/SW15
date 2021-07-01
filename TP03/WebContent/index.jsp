<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bookstore</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/style.css" type="text/css"/>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Fira+Sans:wght@300;400;500&display=swap" rel="stylesheet">
<style>
	html, body {
		margin: 0;
		padding: 0;
		box-sizing: border-box;
		font-family: 'Fira Sans', sans-serif;
	}
	
	body {
		background: #15181d;
		color: #FFFFFF;
	}
	
	.menu {
	  display: flex;
	  align-items: center;
	  flex-direction: column;
	  height: 100vh;
	  width: 100vw;
	  color: #FFFFFF
	}
	
	.list a{
		color: #FFFFFF;
		text-decoration: none;
	}
	
</style>
</head>
<body>
	<div class="menu">
		<h3>BOOKSTORE MENU</h3>
		<ul class="list">
			<li><a href="addBook.html" class="content-list">Add Book</a></li>
			<li><a href="ViewServlet" class="content-list">View Books</a></li>
			<li><a href="creditos.html" class="content-list">Credits</a></li>
		</ul>	
	</div>
</body>
</html>