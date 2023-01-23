<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>AppAluguelVestuario</title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
  		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	</head>
	<body>
	
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
		<h2>Projeto de Gestão de Vestuário</h2>
		<p>Aluguel de roupas, calçados e acessórios</p>
		
		<h3>Classe: Aluguel</h3>
		
		<h4><a href="/aluguel">Novo</a></h4>
		
		<table class="table">
			<thead>
				<tr>
					<th>ID</th>
					<th>Item alugado</th>
					<th>Valor total</th>
					<th>Data do Evento</th>
					<th>Cliente</th>
					<th>Quantidade de vestuários</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${listagem}">
				<tr class="success">
					<td>${a.id}</td>
					<td>${a.itemAlugado}</td>
					<td>${a.valorTotal}</td>
					<td>${a.dataEvento}</td>
					<td>${a.cliente.nome}</td>
					<td>${a.listaVestuario.size()}</td>
					<td><a href="/aluguel/${a.id}/excluir">excluir</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

</body>
</html>