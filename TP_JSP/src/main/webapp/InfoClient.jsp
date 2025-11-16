<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page errorPage="erreur.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>infos</title>
</head>
<body>
<h2 align='center'>Infos</h2>
<table align='center'>
<tr>
<td>Type mime de la requête :</td>
<td><%=request.getContentType() %></td>
</tr>

<tr>
<td>Protocole de la requête :</td>
<td><%=request.getProtocol() %></td>
</tr>

<tr>
<td>Adresse IP du client :</td>
<td><%=request.getRemoteAddr() %></td>
</tr>

<tr>
<td>Nom du client :</td>
<td><%=request.getRemoteHost() %></td>
</tr>

<tr>
<td>Nom du serveur qui a reçu la requête :</td>
<td><%=request.getServerName() %></td>
</tr>

<tr>
<td>Port du serveur qui a reçu la requête :</td>
<td><%=request.getServerPort() %></td>
</tr>

<tr>
<td>scheme :</td>
<td><%=request.getScheme() %></td>
</tr>

<tr>
<td colspan=2>Liste des parametres </td>
</tr>
<%
for(Enumeration<String> paramList= request.getParameterNames();paramList.hasMoreElements();) {
	String param = paramList.nextElement();
	out.println("<tr>");
    out.println("<td>"  +param+ ":</td>");
    out.println("<td>"  + request.getParameter(param) +"</td>");
    out.println("</tr>");
}
%>

</table>


</body>
</html>