<%@page import="br.senai.sp.cfp127.model.Compromisso"%>
<%@page import="br.senai.sp.cfp127.model.Contato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senai.sp.cfp127.dao.ContatoDao"%>
<%@page import="br.senai.sp.cfp127.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	Usuario usuario = new Usuario();
	usuario = (Usuario) session.getAttribute("usuario");
	
	Compromisso compromisso = new Compromisso();
	compromisso= (Compromisso) session.getAttribute("compromisso");

	if (usuario == null) {
		response.sendRedirect("login.html");
	} else {
%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<meta charset="utf-8">
<title>Compromissos</title>
</head>
<body class="bg-dark">
	<div class="bg-info text-white">
		<div class="container">
			<div class="row">
				<!-- linha -->
				<div class="col-md-1">
					<!-- Coluna 01 -->
					<img src="imagens/agenda64.png">
				</div>
				<div class="col-md-11">
					<!-- Coluna 02 -->
					<h1>Agenda Eletrônica</h1>
					<h6>Contatos e Compromissos</h6>
				</div>
			</div>
		</div>
	</div>

	<div class="container mt-5 fluid">
		<div class="row">
			<div class="col-md-4">

				<%@ include file="painelUsuario.jsp"%>

				<%@ include file="menu.html"%>

			</div>
			<div class="col-md-8">
				<div class="card">
					<div class="card-header bg-info text-white ">
						<!-- cabeçalho -->
						<div class="row">
							<div class="col-md-9">
								<h5>Meus Compromissos</h5>
							</div>
							<div class="col-md-3">
								<a href="CriarContato.jsp" class="btn btn-success">Novo
									Compromisso</a>
							</div>
						</div>
					</div>

					<div class="card-body">
						<table class="table table-hover ">
							<thead class="bg-secondary text-white">
								<tr>

									<th scope="col" >Cód.</th>
									<th scope="col">Titulo</th>
									<th scope="col">Data</th>
									<th scope="col">Grau </th>
									<th scope="col">&nbsp</th>
								</tr>
							</thead>
							<tbody>


								<%
									//for (Contato c : contatos) {
								%>



								<tr>
									<td scope="row"> <%= compromisso.getCod_compromisso()%> codigo do compromisso</td>
									<td>
											<%= compromisso.getTitulo()%>
											titulo compromisso
									</td>
									<td>
									<!-- <%= compromisso.getData()%> a <%= compromisso.getDataFim()%> -->
									data começo e fim </td>
									<td>
											
											<%= compromisso.getStatus()%>Grau de importancia
									</td>

								</tr>


								<%
								//	}
								%>


							</tbody>
						</table>
					</div>

					<div class="card-footer">
						<!-- rodapé -->

					</div>
				</div>
			</div>
		</div>

	</div>
	
	
	<script src="js/bootstrap.js"></script>
</body>
</html>
<%
	}
%>