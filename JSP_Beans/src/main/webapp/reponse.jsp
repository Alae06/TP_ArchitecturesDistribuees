<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Résultat - Informations Étudiant</title>

</head>
<body>
<jsp:useBean id="etudiant" type="beans.Etudiant" scope="request"/>

<h2 align="center">Résultat - Informations de l'Étudiant</h2>

<div class="info-container" align="center">
    <div class="info-row">
        <span class="label">Nom :</span>
        <span class="value"><jsp:getProperty name="etudiant" property="nom" /></span>
    </div>
    
    <div class="info-row">
        <span class="label">Prénom :</span>
        <span class="value"><jsp:getProperty name="etudiant" property="prenom"/></span>
    </div>
    
    <div class="info-row">
        <span class="label">Note :</span>
        <span class="value"><jsp:getProperty name="etudiant" property="note"/></span>
    </div>
</div>

</body>
</html>