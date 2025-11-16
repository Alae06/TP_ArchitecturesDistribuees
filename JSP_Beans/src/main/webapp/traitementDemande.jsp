<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Traitement de la demande</title>
</head>
<body>
<jsp:useBean id="etudiant" class="beans.Etudiant" scope="request">
    <jsp:setProperty name="etudiant" property="nom" param="nom"/>
    <jsp:setProperty name="etudiant" property="prenom" param="prenom"/>
</jsp:useBean>

<jsp:forward page="TraitementServlet"/>
</body>
</html>