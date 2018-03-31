<%
if (session.getAttribute("username") != null)
{
	response.sendRedirect(request.getContextPath() + "/bibliothekForUserServlet");
	return;
}
else
{
	response.sendRedirect(request.getContextPath() + "/bibliothekNoUserServlet");
}
%>

