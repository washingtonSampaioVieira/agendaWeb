<%@page import="br.senai.sp.cfp127.model.Contato"%>
<%@page import="br.senai.sp.cfp127.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	Usuario usuario = new Usuario();
	usuario = (Usuario) session.getAttribute("usuario");

	Contato contato = new Contato();
	contato = (Contato) session.getAttribute("contato");

	if (usuario == null) {
		response.sendRedirect("login.html");
	} else {
%>


<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css">
<meta charset="utf-8">
<title>Criar Contato</title>
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
				<!-- incluir abaixo a pagina  -->
				<%@ include file="painelUsuario.jsp"%>

				<%@ include file="menu.html"%>
			</div>
			<div class="col-md-8">
				<div class="card">
					<div class="card-header bg-info text-white">
						<!-- cabeçalho -->
						<h5>
							<img src="imagens/editar.png">Atualizar Contato
						</h5>
					</div>

					<div class="card-body">


						<div class="card">


							<form id="contato" action="AtualizarContato" method="post">
								<div class="card-header">
									<h2>Atualizar contato</h2>
								</div>
								<div class="card-body">

									<div class="alert-warning text-danger">
										<ul id="mensagens-erro">

										</ul>
									</div>
									<!-- corpo -->
									<div class="row">
										<!-- linha 01 -->
										<div class="col-md-12">
											<!-- coluna total/12 -->
											<h6 class="text-primary mb-4">Dados Do Contato:</h6>
										</div>
									</div>

									<div class="row form-group">
										<!-- linha 02 -->
										<div class="col-md-4">
											<!-- coluna 01 -->
											<input type="text" name="txt-cod" hidden="hidden"
												value="<%=contato.getCodContato()%>"> <label
												for="txt-nome"> Nome: </label> <input class="form-control"
												type="text" name="nome" id="nome"
												value="<%=contato.getNome()%>">
										</div>
										<div class="col-md-8">
											<!-- coluna 02 -->
											<label for="txt-nascimento"> Email: </label> <input
												class="form-control" type="email" name="email" id="email"
												value="<%=contato.getEmail()%>">
										</div>

									</div>


									<div class="row form-group">
										<!-- linha 04 -->
										<div class="col-md-5">
											<!-- coluna 01 -->
											<label for="txt-email"> Telefone: </label> <input
												class="form-control" type="text" name="telefone"
												id="telefone" value="<%=contato.getTelefone()%>">
										</div>
										<div class="col-md-7">
											<!-- coluna 02 -->
											<label for="txt-senha1"> Endereço: </label> <input
												class="form-control" type="text" name="endereco"
												id="endereco" value="<%=contato.getEndereco()%>">
										</div>

									</div>
								</div>
								<div class="card-footer">
									<!-- rodapé -->
									<button class="btn btn-success" id="bt-criar">Atualizar
										Contato</button>
									<a href="index.jsp" class="btn btn-dark"> Cancelar </a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>

	



	<script src="js/validarContato.js"></script>
</body>

</html>
<%
	}
%>