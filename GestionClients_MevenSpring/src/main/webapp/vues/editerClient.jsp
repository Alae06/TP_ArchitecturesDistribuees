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
    <h5 class="card-header text-bg-primary">Modifier Client</h5> 
    <div class= "card-body"> 
      <form class="row g-3" action="modifierClient.do" method="post"> 
        
                <div class="mb-3">
                    <input id="id" type="hidden" name="id" class="form-control" value="${client.id }" >
                    <label class="form-label">Nom :</label>
                    <input id="nom" type="text" name="nom" class="form-control" value="${client.nom }" >
                </div>
                <div class="mb-3">
                    <label class="form-label">Prénom :</label>
                    <input id="prenom" type="text" name="prenom" class="form-control" value="${client.prenom }" >
                </div>
                <div class="mb-3">
                    <label class="form-label">Âge :</label>
                    <input id="age" type="number" name="age" class="form-control" value="${client.age }" >
                </div>
       <div class= "col-auto"> 
       <button type="submit" class="btn btn-warning mb-3">
       Modifier</button> 
       </div>
       
       
      </form> 
      
      

  </div>
</div>
</div>

</body>
</html>