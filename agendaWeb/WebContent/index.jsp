<%@page import="br.senai.sp.cfp127.model.Compromisso"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senai.sp.cfp127.dao.CompromissoDao"%>
<%@page import="br.senai.sp.cfp127.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	Usuario usuario = new Usuario();
	usuario = (Usuario) session.getAttribute("usuario");

	
	ArrayList<Compromisso> compromissos = new ArrayList<>();
	CompromissoDao compromissoDao = new CompromissoDao();
	compromissos = compromissoDao.getCompromissos3(usuario.getCod());
	
	
	if (usuario == null) {
		response.sendRedirect("login.html");
	} else {
%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<meta charset="utf-8">
<title>Novo usuário</title>
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
			<div class="col-md-3">
				<%@ include file="painelUsuario.jsp"%>

				<%@ include file="menu.html"%>
			</div>
			<div class="col-md-9">
				<div class="card">
					<div class="card-header bg-info text-white">
						<!-- cabeçalho -->
						<h5>Bem-vindo</h5>
					</div>

					<div class="card-body card-deck">

						<%
							for (Compromisso compromissoDaArray : compromissos) {
						%>

						<div class="card text-white bg-danger mb-3"
							style="max-width: 18rem;">
							<a href="BuscarCompromissoServlet?cod_compromisso=<%= compromissoDaArray.getCod_compromisso()%>"><div class="card-header text-white"><%= compromissoDaArray.getTitulo() %></div></a>
							<div class="card-body">
								<h5 class="card-title">
								<%= compromissoDaArray.getDescricao() %></h5>
								<p class="card-text"> <%=compromissoDaArray.getData() %></p>
							</div>
						</div>
						
						<% }%>

						<div class="card-footer">
							<!-- rodapé -->

						</div>
					</div>
				</div>
			</div>

		</div>
</body>
</html>
<%
	}
%>