<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter un Test PCR</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
</head>
<body>

<form class="ext-center"  action="MainServlet" method="post">

 <input type="hidden" name="cas" value="${cas }"/>
  <input type="hidden" name="id_cas" value="${cas.id_cas }"/>
 
 <div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">ID cas</span> 
  </div>
  <input type="text" disabled name="idcas" class="form-control" placeholder="${ cas.id_cas}" aria-label="id_cas" aria-describedby="basic-addon1">
</div> 

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Jour : </span>
  </div>
  <input type="text" name="jour" class="form-control" placeholder="Jour" aria-label="jour" aria-describedby="basic-addon1">
</div>
 
 
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Mois : </span>
  </div>
  <input type="text" name="mois" class="form-control" placeholder="Mois" aria-label="mois" aria-describedby="basic-addon1">
</div>

 <div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Annee : </span>
  </div>
  <input type="text" name="annee" class="form-control" placeholder="Annee" aria-label="annee" aria-describedby="basic-addon1">
</div>

 <div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Resultat : </span>
  </div>
  <input type="text" name="resultat" class="form-control" placeholder="Resultat" aria-label="resultat" aria-describedby="basic-addon1">
</div> 

 <input type="hidden" name="action" value="ajoutTest"/>


<input type="submit" class="btn btn-primary" value="Valider" /> &nbsp; &nbsp;
</form>

<form class="ext-center"  action="MainServlet" method="post">
 <input type="hidden" name="action" value="goToDetail"/>
 <input type="hidden" name="id_cas" value="${cas.id_cas }"/>
  <input type="submit" class="btn btn-primary" value="Retour"/>&nbsp; &nbsp;
</form>

</body>
</html>