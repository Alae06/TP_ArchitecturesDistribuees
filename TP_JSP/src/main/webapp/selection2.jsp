<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="erreur.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="POST" action="selection2.jsp">
			Choisissez une couleur
			<p>
				<input type="radio" name="couleur" value="rouge" />Rouge<br />
				<input type="radio" name="couleur" value="bleu" />Bleu<br />
				<input type="radio" name="couleur" value="vert" />Vert<br />
				<input type="radio" name="couleur" value="orange" />Orange<br />
			</p>
			<input type="submit" value="Envoyer">
		</form>
		<%
		String couleur = request.getParameter("couleur");
		if (couleur != null && couleur.equals("orange")){
			throw new Exception("Cette couleur n'est pas belle");
		}else{
			out.println("<h3>Vous avez choisi la couleur "+ request.getParameter("couleur")+ "</h3>");
		}
		%>
		
		
		
</body>
</html>