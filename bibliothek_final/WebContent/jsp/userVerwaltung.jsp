<%-- Author: Lukas Schütte --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="fehlerausgabe.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>

<head>
<base href="/Bibliothek/" />
<meta charset="utf-8">
<title>Userverwaltung</title>
<link rel="stylesheet" href="css/styles.css">
<script language="javascript" type="text/javascript" src="js/getUser.js"></script>
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

  <button id="btUserData" type="button" onclick='loadUserData()'> Submit </button>
  <div id="div_user">
    <h4>Bitte User aktualisieren</h4>
  </div>
</div>

</body>

</html>