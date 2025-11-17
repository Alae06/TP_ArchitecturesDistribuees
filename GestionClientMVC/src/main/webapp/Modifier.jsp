<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.estn.model.Client"%>

<%

Client c = (Client) request.getAttribute("client");

if (c == null) {
    response.sendRedirect("Liste.php");
    return;
}
%>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Modifier Client</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5 d-flex justify-content-center">
    <div class="card border-primary w-75">
        <div class="card-header bg-primary text-white py-2">
            <strong class="fs-4">Modifier le client</strong>
        </div>
        <div class="card-body">
            <form method="POST" action="Modifier.php?id=<%= c.getId() %>">
                <div class="mb-3">
                    <label class="form-label">Nom :</label>
                    <input type="text" name="nom" class="form-control" value="<%= c.getNom() %>" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Prénom :</label>
                    <input type="text" name="prenom" class="form-control" value="<%= c.getPrenom() %>" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Âge :</label>
                    <input type="number" name="age" class="form-control" value="<%= c.getAge() %>" required>
                </div>
                <button type="submit" class="btn btn-primary">Modifier</button>
                <a href="Liste.php" class="btn btn-secondary ms-2">Retour à la liste</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>




