<%-- Author: Lukas Schütte --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="fehlerausgabe.jsp"%>

<!doctype html>
<html>

<head>
<meta charset="utf-8">
<title>Administration</title>
<link rel="stylesheet" href="css/styles.css">

</head>

<body>
	<%
	  if (session.getAttribute("username") != null || session.getAttribute("admin") == "1")
	  {
		  response.sendRedirect(request.getContextPath() + "/adminBibliothekServlet");
		  return;
	  }
	%>
	<div id="header">
		<div id=div_standardHeader">
			<h2>Welcome to our Bibliothek!</h2>
		</div>
		<!-- Kopfzeile -->
		<div id="div_userHeader">
			<%@ include file="/jspf/headerForUser.jspf"%>
		</div>
	</div>

	<div id="content">
		<%@ include file="adminBibliothek.jsp"%>
	</div>
</body>

</html>