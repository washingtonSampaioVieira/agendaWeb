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
<title>Editar usuario</title>
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
							<img src="imagens/editar.png">Editar usuario
						</h5>
					</div>

					<div class="card-body">


						<div class="card">
							<form id="usuario" action="UsuarioServlet" method="post">
								<div class="card-header">Edite</div>
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
											<h6 class="text-primary mb-4">Dados Pessoais:</h6>
										</div>
									</div>

									<div class="row form-group">
										<!-- linha 02 -->
										<div class="col-md-5">
											<!-- coluna 01 -->
											<input type="text" name="txt-cod"
												value="<%=usuario.getCod()%>" hidden="hidden"> <label
												for="txt-nome"> Nome: </label> <input class="form-control"
												type="text" name="txt-nome" id="txt-nome"
												value="<%=usuario.getNome()%>">
										</div>
										<div class="col-md-4">
											<!-- coluna 02 -->
											<label for="txt-nascimento"> Dt. Nascimento: </label> <input
												class="form-control" type="date" name="txt-nascimento"
												id="txt-nascimento" value="<%=usuario.getDtNascimento()%>">
										</div>
										<div class="col-md-3">
											<!-- coluna 03 -->
											<label for="txt-sexo"> Sexo: </label> <select
												class="form-control" name="txt-sexo" id="txt-sexo">

												<option>Selecione...</option>
												<option <%=usuario.getSexo().equals("F") ? "selected" : ""%>>Feminino</option>
												<option <%=usuario.getSexo().equals("M") ? "selected" : ""%>>Masculino</option>
											</select>
										</div>
									</div>

									<div class="row">
										<!-- linha 03 -->
										<div class="col-md-12">
											<!-- coluna total/12 -->
											<h6 class="text-primary mb-4">Dados de Acesso:</h6>
										</div>
									</div>

									<div class="row form-group">
										<!-- linha 04 -->
										<div class="col-md-5">
											<!-- coluna 01 -->
											<label for="txt-email"> E-mail: </label> <input
												class="form-control" type="email" name="txt-email"
												id="txt-email" value="<%=usuario.getEmail()%>">
										</div>
										<div class="col-md-3">
											<!-- coluna 02 -->
											<label for="txt-senha1"> Senha: </label> <input
												class="form-control" type="password" name="txt-senha1"
												id="txt-senha1">
										</div>
										<div class="col-md-4">
											<!-- coluna 03 -->
											<label for="txt-senha2"> Confirmação da Senha: </label> <input
												class="form-control" type="password" name="txt-senha2"
												id="txt-senha2">
										</div>
									</div>
								</div>
								<div class="card-footer">
									<!-- rodapé -->
									<button class="btn btn-success" id="bt-criar">Atualizar
										Dados</button>
									<a href="index.jsp" class="btn btn-dark"> Cancelar </a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>

	</div>
	<script src="js/valida.js"></script>
	<script src="js/erros.js"></script>
</body>

</html>
<%
	}
%>