<%-- Author: Lukas Schütte --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="fehlerausgabe.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Quelle: www.codejava.net/ -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<!--  https://www.tutorialspoint.com/jsp/jsp_database_access.htm -->
<!doctype html>
<html>

<head>
<meta charset="utf-8">
<title>Bibliothek Administration</title>
<link rel="stylesheet" href="css/styles.css">

</head>

<body>
	<%
	//if (session.getAttribute("user") == null)
	//{
	//	response.sendRedirect(request.getContextPath() + "/index.jsp");
	//	return;
	//}
	%>
	<div id="header">
		<div id=div_standardHeader">
			<h2>Welcome to our Bibliothek!</h2>
		</div>
		<div id="div_userHeader">
			<%@ include file="/jspf/headerForUser.jspf"%>
		</div>
	</div>
	<!-- Inhalt -->
	<div id="content">
		Index For Admins<br />
		<br />		
		<c:forEach var="id" items="${id}" varStatus="counter">
					ID: ${id} <br />
					${title[counter.index]} <a href="jsp/adminBook.jsp?bookid=${id}">edit</a>
			<br />
		</c:forEach>
		<br />
		<a href="jsp/createBook.jsp">erstelle neues Buch</a>
		<br />
		<a href="jsp/coverUploadServlet">Cover Upload</a>
	</div>
	<div id="side">
		<a href="jsp/userVerwaltung.jsp">Userverwaltung</a>
	</div>
</body>

</html>