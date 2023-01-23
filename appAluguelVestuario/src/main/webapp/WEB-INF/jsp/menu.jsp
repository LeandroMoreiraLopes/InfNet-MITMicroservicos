<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">AppAluguelDeRoupas</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="collapsibleNavbar">
	      <ul class="navbar-nav">
	        <li class="nav-item">
	          <a class="nav-link" href="/">Home</a>
	        </li>
	        
	        <c:if test="${not empty user}">
		        <li class="nav-item">
		          <a class="nav-link" href="/usuario/lista">Usuário</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/roupa/lista">Roupa</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/calcado/lista">Calçado</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/acessorio/lista">Acessório</a>
		        </li>  
		        <li class="nav-item dropdown">
		          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Servicos</a>
		          <ul class="dropdown-menu">
		            <li><a class="dropdown-item" href="/aluguel/lista">Aluguel</a></li>
		            <li><a class="dropdown-item" href="/vestuario/lista">Vestuario</a></li>
		            <li><a class="dropdown-item" href="/cliente/lista">Cliente</a></li>
		          </ul>
	        	</li>
        	</c:if>
	      
	      </ul>
	      
	      <ul class="navbar-nav justify-content-end ms-auto">
	        <c:if test="${empty user}">
		        <li class="nav-item">
		          <a class="nav-link" href="/usuario">Signup</a>
		        </li>
		        <li class="nav-item">
		          <a class="nav-link" href="/login">Login</a>
		        </li>
		    </c:if>
		        
	        <c:if test="${not empty user}">
		        <li class="nav-item">
		          <a class="nav-link" href="/logout">Logout, ${user.nome}</a>
		        </li>
	        </c:if>
	      </ul>
	    </div>
	  </div>
	</nav>