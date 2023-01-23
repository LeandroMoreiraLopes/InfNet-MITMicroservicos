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
	</head>
	<body>

	<div class="container">
		<h2>Projeto de Gestão de Vestuário</h2>
		<p>Aluguel de roupas, calçados e acessórios</p>
		
		<h3>Classe: Aluguel</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Atributo</th>
					<th>Tipo</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				<tr class="success">
					<td>ItemAlugado</td>
					<td>String</td>
					<td>Item de vestuário que está sendo alugado</td>
				</tr>
				<tr class="info">
					<td>valorTotal</td>
					<td>double</td>
					<td>Valor total do item alugado</td>
				</tr>
				<tr class="warning">
					<td>dataEvento</td>
					<td>LocalDateTime</td>
					<td>Data de realização do evento quando será usando o vestuario</td>
				</tr>
			</tbody>
		</table>
		<br>
		<h3>Classe: Cliente</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Atributo</th>
					<th>Tipo</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				<tr class="success">
					<td>Nome</td>
					<td>String</td>
					<td>Nome do Cliente</td>
				</tr>
				<tr class="info">
					<td>cpf</td>
					<td>String</td>
					<td>Número de Cadastro de Pessoa Física(CPF) do cliente</td>
				</tr>
				<tr class="warning">
					<td>dataNascimento</td>
					<td>LocalDateTime</td>
					<td>Data de nascimento do cliente</td>
				</tr>
			</tbody>
		</table>
		
		<br>
		<h3>Classe: Vestuario</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Atributo</th>
					<th>Tipo</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				<tr class="success">
					<td>nome</td>
					<td>String</td>
					<td>Nome do Vestuário</td>
				</tr>
				<tr class="info">
					<td>valorDoAluguel</td>
					<td>double</td>
					<td>Valor de aluguel da peça</td>
				</tr>
				<tr class="warning">
					<td>reservado</td>
					<td>boolean</td>
					<td>Indicatico se a peça já está reservada</td>
				</tr>
			</tbody>
		</table>
		
		<br>
		<h3>Classe: Roupa</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Atributo</th>
					<th>Tipo</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				<tr class="success">
					<td>tamanho</td>
					<td>String</td>
					<td>Tamanho da roupa (PP, P, M, G, GG)</td>
				</tr>
				<tr class="info">
					<td>tipoDeTecido</td>
					<td>String</td>
					<td>Qual o tipo de tecido da roupa</td>
				</tr>
				<tr class="warning">
					<td>paraNoite</td>
					<td>boolean</td>
					<td>Indicatico de roupa que é indicada apenas para eventos a noite</td>
				</tr>
			</tbody>
		</table>
		
		<br>
		<h3>Classe: Calçado</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Atributo</th>
					<th>Tipo</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				<tr class="success">
					<td>tamanho</td>
					<td>int</td>
					<td>Tamanho do tamanho do calçado</td>
				</tr>
				<tr class="info">
					<td>tipoDeSalto</td>
					<td>String</td>
					<td>Qual o tipo de salto do calçado</td>
				</tr>
				<tr class="warning">
					<td>cor</td>
					<td>String</td>
					<td>Cor do calçado</td>
				</tr>
			</tbody>
		</table>
		
		<br>
		<h3>Classe: Acessório</h3>
		<table class="table">
			<thead>
				<tr>
					<th>Atributo</th>
					<th>Tipo</th>
					<th>Descrição</th>
				</tr>
			</thead>
			<tbody>
				<tr class="success">
					<td>descricao</td>
					<td>String</td>
					<td>Descrição do acessório</td>
				</tr>
				<tr class="info">
					<td>tipo</td>
					<td>String</td>
					<td>Qual o tipo de acessório</td>
				</tr>
				<tr class="warning">
					<td>material</td>
					<td>String</td>
					<td>Qual o material do acessório</td>
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>