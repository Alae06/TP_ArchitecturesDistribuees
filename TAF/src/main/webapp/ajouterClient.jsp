<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.estn.ClientDAO, com.estn.Client" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String nom = request.getParameter("nom");
    String prenom = request.getParameter("prenom");
    int age = Integer.parseInt(request.getParameter("age"));

    Client client = new Client(0, nom, prenom, age);
    ClientDAO dao = new ClientDAO();
    dao.ajouterClient(client);

    response.sendRedirect("index.jsp");
%>
</body>
</html>