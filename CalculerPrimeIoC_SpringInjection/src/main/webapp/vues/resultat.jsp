<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Bienvenue ${pm.nom} ${pm.prenom}</h2>
<p align="center">La prime : <font color = "blue">${pm.prime}</font><br>
<a href="<%=request.getContextPath()%>/acceuil.php">Retour</a>
</p>



</body>
</html>