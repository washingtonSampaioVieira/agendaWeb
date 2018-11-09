<%@page import="br.senai.sp.cfp127.model.Contato"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.senai.sp.cfp127.dao.ContatoDao"%>
<%@page import="br.senai.sp.cfp127.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	Usuario usuario = new Usuario();
	usuario = (Usuario) session.getAttribute("usuario");

	ContatoDao dao = new ContatoDao();
	ArrayList<Contato> contatos = new ArrayList<>();

	contatos = dao.getContatos(usuario.getCod());

	if (usuario == null) {
		response.sendRedirect("login.html");
	} else {
%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<meta charset="utf-8">
<title>Novo usu�rio</title>
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
					<div class="card-header bg-info text-white">
						<!-- cabe�alho -->
						<h5>Bem-vindo</h5>
					</div>

					<div class="card-body">
						<table class="table table-hover">
							<thead>
								<tr>
									<th scope="col">C�d.</th>
									<th scope="col">Nome</th>
									<th scope="col">Email</th>
								</tr>
							</thead>
							<tbody>


								<%
									for (Contato c : contatos) {
								%>



								<tr>
									<td scope="row"><%=c.getCodContato()%></td>
									<td><%=c.getNome()%></td>
									<td><%=c.getEmail()%></td>
								</tr>


								<%
									}
								%>


							</tbody>
						</table>
					</div>

					<div class="card-footer">
						<!-- rodap� -->

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