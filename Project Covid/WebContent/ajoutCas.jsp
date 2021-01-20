<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajouter Cas</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">
</head>
<body>

<form class="ext-center"  action="MainServlet" method="post">
 
 <div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">ID</span>
  </div>
  <input type="text" disabled name="id" class="form-control" placeholder="ID" aria-label="id" aria-describedby="basic-addon1">
</div> 

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Nom Complet : </span>
  </div>
  <input type="text" name="nomComplet" class="form-control" placeholder="Nom Complet" value="<c:catch var="exception"></c:catch>
<c:if test="${exception==null}"><c:out value = "${cas.nom_complet }"/></c:if>" aria-label="nomComplet" aria-describedby="basic-addon1">
<c:catch var="exception"></c:catch>
<c:if test="${exception==null}"><c:out value = "${erreur_nomcomplet }"/></c:if>
</div>
 
 
<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Adresse : </span>
  </div>
  <input type="text" name="adresse" class="form-control" placeholder="Adresse" value="<c:catch var="exception"></c:catch>
<c:if test="${exception==null}"><c:out value = "${cas.adresse }"/></c:if>" aria-label="Adresse" aria-describedby="basic-addon1">
  <c:catch var="exception"></c:catch>
<c:if test="${exception==null}"><c:out value = "${erreur_adresse }"/></c:if>
</div>

 <div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Code Postale : </span>
  </div>
  <input type="text" name="codePostale" class="form-control" placeholder="Code Postale" value="<c:catch var="exception"></c:catch>
<c:if test="${exception==null}"><c:out value = "${cas.code_postale }"/></c:if>" aria-label="codePostale" aria-describedby="basic-addon1">
<c:catch var="exception"></c:catch>
<c:if test="${exception==null}"><c:out value = "${erreur_code_postale}"/></c:if>
</div>

 <div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Telephone : </span>
  </div>
  <input type="text" name="telephone" class="form-control" placeholder="Telephone" value="<c:catch var="exception"></c:catch>
<c:if test="${exception==null}"><c:out value = "${cas.telephone }"/></c:if>" aria-label="telephone" aria-describedby="basic-addon1">
<c:catch var="exception"></c:catch>
<c:if test="${exception==null}"><c:out value = "${erreur_telephone }"/></c:if>
</div> 

 
 <div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Etat : </span>
  </div>
  <input type="text" name="etat" class="form-control"  aria-label="etat" value="<c:catch var="exception"></c:catch>
<c:if test="${exception==null}"><c:out value = "${cas.etat }"/></c:if>" aria-describedby="basic-addon1">
  <c:catch var="exception"></c:catch>
<c:if test="${exception==null}"><c:out value = "${erreur_etat }"/></c:if>
</div> 


 <input type="hidden" name="action" value="ajouter"/>
 <input type="submit" class="btn btn-primary" value="Valider"/> &nbsp; &nbsp;
</form>
<form class="ext-center"  action="MainServlet" method="post">
 <input type="hidden" name="action" value="goToGestion"/>
  <input type="submit" class="btn btn-primary" value="Retour"/>&nbsp; &nbsp;
</form>

</body>
</html>