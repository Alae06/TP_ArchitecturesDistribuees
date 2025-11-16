<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">

<title>Insert title here</title>

</head>
<body>
<div class= "container"> 
  <div class="card" >
    <h5 class="card-header text-bg-primary">Nouveau Client</h5> 
    <div class= "card-body"> 
      <form class="row g-3" action="ajouterClient.do" method="post"> 
        
                <div class="mb-3">
                    <label class="form-label">Nom :</label>
                    <input type="text" name="nom" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Prénom :</label>
                    <input type="text" name="prenom" class="form-control" required>
                </div>
                <div class="mb-3">
                    <label class="form-label">Âge :</label>
                    <input type="number" name="age" class="form-control" required>
                </div>
       <div class= "col-auto"> 
       <button type="submit" class="btn btn-warning mb-3">
       Ajouter</button> 
       </div>
       
       
      </form> 
      
      

  </div>
</div>
</div>

</body>
</html>