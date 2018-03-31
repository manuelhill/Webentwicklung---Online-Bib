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
<!-- <base href="${pageContext.request.requestURI}" /> -->
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
			<form method="post" action="loginServlet">
				<fieldset>
					<legend>Login</legend>
					<div>
						<label id="username" for="username">Username</label> <input
							type="text" name="username" id="username" placeholder="Username">
					</div>
					<div>
						<label id="password" for="password">Password:</label> <input
							type="password" name="password" id="password" placeholder="Password">
					</div>
					<div>
						<button name="buttonLogin" id="buttonLogin" type="submit">Login</button>
						<a href="jsp/registrieren.jsp">registrieren</a>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
	<div id="content">
		<%
		if(request.getParameter("register") == "1")
		{%>
			Sie wurden erfolgreich registriert!<br />
			Bitte loggen Sie sich ein, um auf die B&uuml;cher zuzugreifen.
		<% }%>
		<br />
		
		Willkommen in unserer Online Bibliothek.<br />
		Sobald Sie sich eingeloggt haben, haben Sie zugriff auf folgende B&uuml;cher:<br />
		
		
		<c:forEach var="id" items="${id}" varStatus="counter">
			Titel: <c:out value="${title[counter.index]}" /><br />
			Author: <c:out value="${author[counter.index]}" /><br /><br />
			<br />
		</c:forEach>
	</div>
</body>
</html>