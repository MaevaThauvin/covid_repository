<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Cas</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">

</head>
<body>

<table  class="table">
	<thead> 
		<tr><th>Id</th>
			<th>Nom_complet</th>
			<th>Adresse</th>
			<th>Code Postale</th>
			<th>Telephone</th>
			<th>Etat</th>
			<th>Test PCR</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="a" items="${ listCas }">
			<tr>
				<td>${a.id_cas}</td>
				<td>${a.nom_complet}</td>
				<td>${a.adresse}</td>
				<td>${a.code_postale}</td>
				<td>${a.telephone}</td>
				<td><c:if test = "${a.etat != 0}">
        			 <c:out value = "${a.etat}"/>
     			 </c:if></td>	
				<td>
				<c:url value="MainServlet" var="getTestPCR">
				<c:param name="id_cas" value="${a.id_cas }"></c:param>
				<c:param name="action" value="detailTestPCR"></c:param></c:url>
				<a href="${getTestPCR }">Test P.C.R. </a>	
				</td>			
			</tr>
		</c:forEach>
	</tbody>
</table>
<form action="MainServlet" method="post">
<input name="action" type="hidden" value="goToAjout">
<input type="submit" class="btn btn-primary" value="Ajouter un nouveau cas"/>&nbsp; &nbsp;
</form>

</body>
</html>