<%@page import="br.senai.sp.cfp127.model.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%  
    
    Usuario usuario = new Usuario();
    usuario = (Usuario) session.getAttribute("usuario");
    
    if(usuario == null){
  		response.sendRedirect("login.html");  	
    }else{
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
							<div class="col-md-4">
								<%@ include file ="painelUsuario.jsp" %>
				
								<%@ include file ="menu.html" %>
							</div>
							<div class="col-md-8">
								<div class="card">
									<div class="card-header bg-info text-white">
										<!-- cabeçalho -->
										<h5>Bem-vindo</h5>
									</div>
				
									<div class="card-body">
										
									</div>
				
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