<%-- Author: Manuel Hill --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="fehlerausgabe.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Quelle: www.codejava.net/ -->
<!doctype html>
<html>

<head>
<meta charset="utf-8">
<title>Kapitel Administration</title>
<link rel="stylesheet" href="css/styles.css">

</head>

<body>
	<%
	 if (request.getAttribute("chapterid") != null)
	 {
	 	session.setAttribute("chapterid", request.getAttribute("chapterid"));
		response.sendRedirect(request.getContextPath() + "/adminChapterServlet");
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
		<form method="post" action="changeChapterServlet?chapterid=${id}">
			Title:<br /> <input type="text" value="${title}" name="title"><br />
			<br /> Text:<br />
			<textarea name="text" cols="100" rows="20">${text}</textarea>
			<input type="submit" value="Aendern" />
		</form>
	</div>

</body>

</html>