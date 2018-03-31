<%-- Author: Lukas Schütte --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="fehlerausgabe.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Quelle: www.codejava.net/ -->
<!doctype html>
<html>

<head>
<base href="/Bibliothek/" />
<meta charset="utf-8">
<title>Erzeuge Buch</title>
<link rel="stylesheet" href="css/styles.css">

</head>

<body>
	<div id="header">
		<div id="div_standardHeader">
			<h2>Welcome to our Bibliothek!</h2>
		</div>
		<!-- Kopfzeile -->
		<div id="div_userHeader">
			<%@ include file="/jspf/headerForUser.jspf"%>
		</div>
	</div>

	<div id="content">
		<form id="createBook" method="post" action="createBookServlet">
			Titel:<br /> <input type="text" placeholder="Titel" name="title" /><br />
			<br /> Author: <br /> <input type="text" placeholder="Author"
				name="author" /><br />
			<br /> <input type="submit" value="erstellen" />
		</form>

		<a href="jsp/adminBibliothek.jsp">zurueck</a>
	</div>

</body>

</html>