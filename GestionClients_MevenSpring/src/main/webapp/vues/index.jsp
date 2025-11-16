<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>
<div class= "container"> 
  <div class="card" >
    <h5 class="card-header text-bg-primary">Liste des Clients</h5> 
    <div class= "card-body"> 
      <form class="row g-3" action="accueil.do" method="post"> 
        <div class="col-auto"> 
        <div class="input-group ">
         <label for="client" class="label-control me-3" >Client</label> 
         <input type= "text" class= "form-control" id="client" name= "motCle" value="${rm.motCle}"> 
        </div>
        </div>
       <div class= "col-auto"> 
       <button type="submit" class="btn btn-warning mb-3">
       Rechercher</button> 
       </div>
       
       <div class= "col-auto ms-5"> 
       <a href="nouveauClient.do" class="btn btn-primary  mb-3">
       Nouveau Client</a> 
       </div>
      </form> 
      
      <table class="table table-striped mt-5">
  <thead>
    <tr>
      <th scope="col">id</th>
      <th scope="col">nom</th>
      <th scope="col">prenom</th>
      <th scope="col">age</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
   <c:forEach items="${rm.clients}" var="client">
   <tr>
      <td>${client.id}</td>
      <td>${client.nom}</td>
      <td>${client.prenom}</td>
      <td>${client.age}</td>
      <td><a href="editer.do?id=${client.id}" class="btn btn-success  mb-3">
       Editer</a>
       <a href="supprimer.do?id=${client.id}" class="btn btn-danger  mb-3" onclick="return confirm('Etes-vous sùr?')">
       Supprimer</a>
        </td>
      
   
   </tr>
   </c:forEach>
  </tbody>
</table>

  </div>
</div>
</div>

</body>
</html>