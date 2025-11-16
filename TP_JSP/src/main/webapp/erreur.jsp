<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Erreur</title>
</head>
<body>
 <h2>Une erreur est survenue :</h2>
    <p style="color:red">
        <%= exception %>
    </p>
</body>
</html>