<%-- Author: Lukas Schütte --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="fehlerausgabe.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Quelle: www.codejava.net/ -->
<!doctype html>
<html>

<head>
<meta charset="utf-8">
<title>Bücher Administration</title>
<link rel="stylesheet" href="css/styles.css">

</head>

<body>
	<%
	
	  if (request.getParameter("bookid") != null)
	  {
		  session.setAttribute("bookid", request.getParameter("bookid"));
		  response.sendRedirect(request.getContextPath() + "/adminBookServlet");
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
		<form id="change_book" method="post" action="changeBookServlet?bookid=${book_id}">
			Titel:<br /> <input type="text" value="${book_title}" name="title" /><br />
			<br /> Author: <br /> <input type="text" value="${book_author}"
				name="author" /><br />
			<br /> <input type="submit" value="Aendern" />
		</form>

		<c:forEach var="id" items="${id}" varStatus="counter">
			<br />
			ID: ${id}
			<br />
			Kapitel: ${title[counter.index]}
			<a href="adminChapterServlet?chapterid=${id}">edit</a>
		</c:forEach>
		<br />
		<a href="jsp/createChapter.jsp?bookid=${book_id}">Erstelle neues Chapter</a>
	</div>

</body>

</html>