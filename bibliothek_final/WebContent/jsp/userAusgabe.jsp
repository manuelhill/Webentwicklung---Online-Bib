<%-- Author: Lukas Schütte --%>
<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<user>
<c:forEach var="userid" items="${userid}" varStatus="counter">
	<userid><c:out value="${userid}" /></userid>
	<username><c:out value="${username[counter.index]}" /></username>
	<vorname><c:out value="${vorname[counter.index]}" /></vorname>
	<nachname><c:out value="${nachname[counter.index]}" /></nachname>
	<passoword><c:out value="${password[counter.index]}" /></password>
	<admin><c:out value="${admin[counter.index]}" /></admin>
</c:forEach>
</user>