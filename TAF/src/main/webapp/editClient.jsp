<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier Client</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<%@ page import="com.estn.ClientDAO, com.estn.Client, java.util.*" %>
<%
    request.setCharacterEncoding("UTF-8");
    
    // Traitement de la soumission du formulaire (POST)
    if ("POST".equals(request.getMethod())) {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            String nom = request.getParameter("nom");
            String prenom = request.getParameter("prenom");
            int age = Integer.parseInt(request.getParameter("age"));
            
            Client client = new Client(id, nom, prenom, age);
            ClientDAO dao = new ClientDAO();
            dao.modifierClient(client);
            
            if (dao.modifierClient(client)) {
                response.sendRedirect("index.jsp");
                return;
            } else {
                out.println("<div class='alert alert-danger'>Erreur: Impossible de modifier le client. Vérifiez que l'ID existe.</div>");
            }
        } catch (Exception e) {
            out.println("<div class='alert alert-danger'>Erreur lors de la modification: " + e.getMessage() + "</div>");
        }
    }
    
    // Affichage du formulaire (GET)
    int id = Integer.parseInt(request.getParameter("id"));
    ClientDAO dao = new ClientDAO();
    Client client = null;
    for (Client c : dao.listerClients()) {
        if (c.getId() == id) { client = c; break; }
    }
    
    if (client == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>

<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white">
            <h2 class="mb-0">Modifier Client</h2>
        </div>
        <div class="card-body">
            <form method="post" action="editClient.jsp">
                <input type="hidden" name="id" value="<%=client.getId()%>">
                
                <div class="mb-3">
                    <label for="nom" class="form-label">Nom:</label>
                    <input type="text" class="form-control" id="nom" name="nom" value="<%=client.getNom()%>" required>
                </div>
                
                <div class="mb-3">
                    <label for="prenom" class="form-label">Prénom:</label>
                    <input type="text" class="form-control" id="prenom" name="prenom" value="<%=client.getPrenom()%>" required>
                </div>
                
                <div class="mb-3">
                    <label for="age" class="form-label">Âge:</label>
                    <input type="number" class="form-control" id="age" name="age" value="<%=client.getAge()%>" required min="1" max="120">
                </div>
                
                <div class="d-flex gap-2">
                    <button type="submit" class="btn btn-primary">Enregistrer</button>
                    <a href="index.jsp" class="btn btn-secondary">Retour</a>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>