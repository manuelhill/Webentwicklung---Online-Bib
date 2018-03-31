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
<base href="${pageContext.request.requestURI}" />
<meta charset="utf-8">
<title>Cover Upload</title>
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
				<% out.print("<br/ ><a href=\"search.jsp\">Suche</a>");%>
				 | 
				<% 
					if (session.getAttribute("admin").equals(1))
					{
						out.println("<a href=\"admin.jsp\">Admin</a> | <a href=\"index.jsp\">Index</a>");
					}
				%>
				| <a href="logoutServlet" title="Logout">Logout</a>
			</fieldset>
		</div>
	</div>
	<div id="content">
		<form id="picUploadForm" action="generateUploadServlet" method="post" enctype="multipart/form-data">
					<input id="inputUpload" name="cover" type="file" accept="image/*" required>
					<br />
					<select name="category">
						<c:forEach var="title" items="${title}" varStatus="counter">
							<option value="${id[counter.index]}">${title}</option>
						</c:forEach>
	                </select>
	                <br>
					<input id="picUploadButton" type="submit">		
				</form>
	</div>
</body>
</html>