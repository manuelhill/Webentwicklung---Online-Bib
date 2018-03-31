<%-- Author: Lukas Schütte --%>
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
	  if (session.getAttribute("username") != null && (request.getParameter("id") != null))
	  {		  
		  //response.sendRedirect(request.getContextPath() + "/bookServlet?id=" + request.getParameter("id"));
		  session.setAttribute("id", request.getParameter("id"));
		  response.sendRedirect(request.getContextPath() + "/bookServlet"); 
		  return;
	  }
	%>
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

		<c:forEach var="id" items="${id}" varStatus="counter">
				ID:<c:out value="${id}" />
			<br />
			<c:out value="${title[counter.index]}" />
			<br />
			<c:out value="${text[counter.index]}" />
			<br />
			<br />
			<br />
		</c:forEach>
		<br />
		<br />
		<br />
	</div>
	<div id="side">
		<a href="index.jsp">zurück</a>
	</div>


</body>

</html>