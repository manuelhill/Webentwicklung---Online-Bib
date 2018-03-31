<%-- Author: Lukas Schütte --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Quelle: www.codejava.net/ -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!--  https://www.tutorialspoint.com/jsp/jsp_database_access.htm -->
<!doctype html>
<html>

<head>
<meta charset="utf-8">
<title>Willkommen auf unserer Bibliothek</title>
<link rel="stylesheet" href="css/styles.css">

</head>
<body>
	<div id="header">
		<div id="div_standardHeader">
			<h2>Welcome to our Bibliothek!</h2>
		</div>
		<div id="div_userHeader">
			<fieldset>
				<legend>User</legend>
				<span class="sp_user">Hallo <% out.println(session.getAttribute("username")); %></span><br />
				<% out.println(session.getAttribute("vorname")); %>,
				<% out.println(session.getAttribute("nachname")); %>
				<% out.print("<br/ ><a href=\"jsp/search.jsp\">Suche</a>");%>
				 | 
				<% 
					if (session.getAttribute("admin").equals(1))
					{
						out.println("<a href=\"jsp/admin.jsp\">Admin</a> | <a href=\"index.jsp\">Index</a>");
					}
				%>
				| <a href="logoutServlet" title="Logout">Logout</a>
			</fieldset>
		</div>
	</div>
	<div id="content">
		Sie sind eingeloggt und haben nun Zugriff auf alle Bücher.<br />
		Klicken Sie dazu einfach auf den von Ihnen gewünschten Titel. <br />
		<br />		
		<c:forEach var="id" items="${id}" varStatus="counter">

				Buch: <a href="jsp/book.jsp?id=${id}">${title[counter.index]}</a><br />
				Autor: ${author[counter.index]} <br />
			<br />
		</c:forEach>
	</div>
</body>
</html>