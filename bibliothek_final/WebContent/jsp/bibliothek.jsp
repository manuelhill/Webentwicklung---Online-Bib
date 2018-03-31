<%-- Author: Lukas Schütte --%>
<%@page import="beans.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="fehlerausgabe.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Quelle: www.codejava.net/ -->
<!doctype html>
<html>

<head>
<meta charset="utf-8">
<title>Willkommen auf unserer Bibliothek</title>
<link rel="stylesheet" href="css/styles.css">

</head>

<body>
	<%
	  if (session.getAttribute("username") == null)
	  {
		  response.sendRedirect(request.getContextPath() + "/index.jsp");
		  return;
	  }
	%>
	<div id="header">
		<div id="div_standardHeader">
			<h2>Welcome to our Bibliothek!</h2>
		</div>
		<div id="div_userHeader">
			<%@ include file="/jspf/headerForUser.jspf"%>
		</div>
	</div>

	
	<!-- Inhalt -->
	<div id="content">
		<c:forEach var="id" items="${id}" varStatus="counter">
					ID:<c:out value="${id}" />
			<br />
					Buch:<a href="jsp/book.jsp?id=${id}" />
			<c:out value="${title[counter.index]}" />
			</a>
			<br />
		</c:forEach>
	</div>
</body>
</html>