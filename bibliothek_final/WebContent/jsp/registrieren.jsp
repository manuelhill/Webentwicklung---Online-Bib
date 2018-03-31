<%-- Author: Manuel Hill --%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrierung</title>
<base href="/Bibliothek/" />
<link rel="stylesheet" href="css/styles.css">
</head>
<body>
	<div id="header">
		<h2>Welcome to our Bibliothek!</h2>
	</div>
	<div id="content">
		<form id="registrationServlet" method="post" action="registrationServlet">
			<fieldset>
				<legend>Registrierung</legend>
				<div>
					<label>Username: </label><br /> 
					<input type="text" name="username" placeholder="Username" required>
				</div>
				<div>
					<label>Vorname: </label><br />
					<input type="text" name="vorname" placeholder="Vorname" required>
				</div>
				<div>
					<label>Nachname: </label><br />
					<input type="text" name="nachname" placeholder="Nachname" required>
				</div>
				<div>
					<label>Passwort: </label><br />
					<input type="password" name="password" placeholder="Passwort (min. 8 Zeichen)" required>
				</div>
				
				<div>
					<button name="buttonRegistration" id="buttonRegistration" type="submit">Registrieren</button>
				</div>
			</fieldset>
		</form>
		<a href="index.jsp">Index</a>
	</div>
</body>
</html>