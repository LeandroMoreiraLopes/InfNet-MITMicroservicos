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
	
	<c:set var="ativaBotao" value=""/>
	
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container mt-3">
	  <h2>Cadastro de Alugueis</h2>
	  <form action="/aluguel/incluir" method="post">
	    
	    <div class="mb-3 mt-3">
	      <label>Item alugado:</label>
	      <input type="text" class="form-control" id="itemAlugado" placeholder="Entre com o nome do aluguel" name="itemAlugado">
	    </div>
	    
	    <div class="mb-3">
	      <label>Valor total:</label>
	      <input type="text" class="form-control" id="valorTotal" placeholder="Entre com o valor total do aluguel" name="valorTotal">
	    </div>
	    
	    <div class="mb-3">
	      <c:if test="${not empty clientes}">
		      <label>Cliente:</label>
		      <select name="cliente" class="form-control" id="sel1">
		      	<c:forEach var="c" items="${clientes}">
		      		<option value="${c.id}">${c.nome}</option>
		      	</c:forEach>
		      </select>
		  </c:if>
		  <c:if test="${empty clientes}">
		      <label>Não existem clientes cadastrados!</label>
		      <c:set var="ativaBotao" value="disabled"/>
		  </c:if>
	    </div>
	    
	    <div class="mb-3">
			<c:if test="${not empty listaVestuario}">
		      <label>Itens de vestuario:</label>
		      <c:forEach var="v" items="${listaVestuario}">
			      <div class="checkbox">
			      	<label> <input type="checkbox" name="listaVestuario" value="${v.id}">${v.nome}</label>
			      </div>
		      </c:forEach>
			</c:if>
			<c:if test="${empty listaVestuario}">
		      <label>Não existem itens de vestuario cadastrados!</label>
		      <c:set var="ativaBotao" value="disabled"/>
			</c:if>
	    </div>
	    
	    <button ${ativaBotao} type="submit" class="btn btn-primary">Incluir</button>
	  </form>
	</div>

</body>
</html>