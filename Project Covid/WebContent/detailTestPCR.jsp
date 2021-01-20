<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detail Test PCR</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">

</head>
<body class="mx-auto">

	<div class="container">
		<form action="MainServlet" method="post">

			<h1>${cas.nom_complet }
				<c:if test="${empty listTest}">
			n'a pas encore passé de test
		</c:if>
			</h1>
			<div class="row">
				<div class="col-2 ">
					<label for="type">ID :</label>
				</div>
				<div class="col-4 ">${ cas.id_cas}</div>
			</div>
			<div class="row">
				<div class="col-2 ">
					<label for="level">Nom complet :</label>
				</div>
				<div class="col-4 ">${cas.nom_complet }</div>
			</div>
			<div class="row">
				<div class="col-2 ">
					<label for="level">Adresse :</label>
				</div>
				<div class="col-4 ">${cas.adresse }</div>
			</div>
			<div class="row">
				<div class="col-2 ">
					<label for="level">Code Postal :</label>
				</div>
				<div class="col-4 ">${ cas.code_postale}</div>
			</div>
			<div class="row">
				<div class="col-2 ">
					<label for="level">Telephone :</label>
				</div>
				<div class="col-4 ">${ cas.telephone }</div>
			</div>
			<div class="row">
				<div class="col-2 ">
					<label for="level">Etat :</label>
				</div>
				<div class="col-4 "><c:if test="${ cas.etat != 0 }"><c:out value = "${ cas.etat }"/></c:if>$</div>
			</div>


			<c:if test="${not empty listTest}">
				<table class="table">
					<thead>
						<tr>
							<th>Id test PCR</th>
							<th>Date</th>
							<th>Resultat</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="a" items="${ listTest }">
							<tr>
								<td>${a.id_testPcr}</td>
								<td>${a.jour}/0${a.mois }/${a.annee }</td>
								<td>${a.resultat}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</c:if>
			
			
			<input type="hidden" name="action" value="testPCR"> <input
				type="hidden" name="id_cas" value="${ cas.id_cas }"> <input
				type="submit" class="btn btn-primary" value="Nouveau Test PCR" />
		</form>

		<form class="ext-center" action="MainServlet" method="post">
			<input type="hidden" name="action" value="goToGestion" /> <input
				type="hidden" name="id_cas" value="${cas.id_cas }" /> <input
				type="submit" class="btn btn-primary" value="Retour" />&nbsp;
			&nbsp;
		</form>
	</div>
</body>
</html>