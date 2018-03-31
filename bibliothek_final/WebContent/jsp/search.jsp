<%-- Author: Manuel Hill --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="de">
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Suche</title>
		<base href="/Bibliothek/" />
		<link rel="stylesheet" href="css/styles.css">
	</head>
	<body>
		<script src="js/checkFieldIsEmpty.js"></script>
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
			<form id="searchform" method="post" action="searchServlet">
				<label>Suche: </label><input name="searchString" id="searchStringId" type="text" maxlength=50 /><br /><br />
				<label>Nach was wollen Sie suchen: </label>
				<select name="searchType">
					<option>Buchtitel</option> 
					<option>Kapiteltitel</option> 
					<option>Kapiteltext</option> 
				</select><br />
				<input type="button" value="Suche starten" id="btn_snd" onclick="checkFieldIsEmpty()"/>
			</form>	
		<br />
		<br />
		</table>
		</div>
	</body>
</html>