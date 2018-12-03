<%@page import="br.senai.sp.cfp127.dao.CompromissoDao"%>
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
					<h1>Agenda Eletr�nica</h1>
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
					<div class="card-header bg-danger  text-white ">
						<!-- cabe�alho -->
						<div class="row">
							<div class="col-md-12">
								<h4>Deseja Excluir</h4>
							</div>
						</div>
					</div>

					<div class="card-body">
						<div class="alert alert-danger text-dark">
							<h5>
								O contato
								<%=request.getParameter("cod_contato")%>
								<%=request.getParameter("nome")%>
								ser� excluido.

							</h5>
							<br>
							<div class="font-weight text-primary">Obs. Est� a��o n�o
								poder� ser desfeita.</div>

						</div>

						<a href="contatos.jsp"><button class="btn btn-warning">Cancelar</button></a>
					<a href="ExcluirContatoServlet?cod_contato=<%=request.getParameter("cod_contato")%>"><button
								class="btn btn-danger">Excluir</button></a>
					</div>

					<div class="card-footer">
						<!-- rodap� -->

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