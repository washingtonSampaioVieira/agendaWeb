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

	int status= 0;
	
	if(request.getParameter("status")!=null){
		status = Integer.parseInt(request.getParameter("status"));
	}
	
	
	
	
	ArrayList<Compromisso> compromissos = new ArrayList<>();
	CompromissoDao compromissoDao = new CompromissoDao();
	compromissos = compromissoDao.getCompromissos(usuario.getCod(), status);

	//compromisso = (Compromisso) session.getAttribute("compromisso");

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
								<a href="criarCompromisso.jsp" class="btn btn-success">Novo
									Compromisso</a>
							</div>
	
						</div>
					</div>

					<div class="card-body">
						<table class="table table-hover table-sm">
						<form id="buscar" action="FiltroDeCompromissosServlet" method="post" >
					
							<select name="filtro" id="filtro" onchange="scriptStatus()">
								<option value="0" <%= status==0? "selected":"" %>>Em andamento</option>
								<option value="1" <%= status==1? "selected":"" %>>Cancelado</option>
								<option value="2" <%= status==2? "selected":"" %>>Concluido</option>
							</select>&nbsp
							
								<input type="button" value="buscar" name="btnFilto" id="btnFiltro">
							</form>
							<thead class="bg-secondary text-white">
								<tr>

									<th scope="col">Cód.</th>
									<th scope="col">Titulo</th>
									<th scope="col">Data</th>
									<th scope="col">Status</th>
									<th scope="col">&nbsp</th>
								</tr>
							</thead>
							<tbody>


								<%
									for (Compromisso compromissoDaArray : compromissos) {
								%>



								<tr>
									<td scope="row"><%=  String.format("%06d",compromissoDaArray.getCod_compromisso())%>
									</td>
									<td><a href="BuscarCompromissoServlet?cod_compromisso=<%= compromissoDaArray.getCod_compromisso()%>"><%=compromissoDaArray.getTitulo()%></a></td>
									<td><%=compromissoDaArray.getData()%></td>
									<td>
										<%
											String status1 = "";
													if (compromissoDaArray.getStatus() == 0) {
														status1 = "Em andamento";
													} else if (compromissoDaArray.getStatus() == 1) {
														status1 = "Cancelado";
													} else {
														status1 = "Concluído";
													}
										%> <%=status1%>
									</td>
									<td>
										<a href="MudarStatusServlet?cod_compromisso=<%=compromissoDaArray.getCod_compromisso()%>&status=1"><img src="imagens/x.png" "></a>&nbsp
										<a href="MudarStatusServlet?cod_compromisso=<%=compromissoDaArray.getCod_compromisso()%>&status=2"><img src="imagens/y.png" "></a>&nbsp
										<a href="MudarStatusServlet?cod_compromisso=<%=compromissoDaArray.getCod_compromisso()%>&status=0"><img src="imagens/emAndamento.png"></a>&nbsp
									</td>

								</tr>


								<%
									}
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
	<script>
	function scriptStatus(){
	    var select = document.getElementById("filtro");
	    
	    if(select.value==0){
	        window.location.href="compromissos.jsp?status=0";
	    } else if(select.value==1){
	        window.location.href="compromissos.jsp?status=1";
	    }else{
	        window.location.href="compromissos.jsp?status=2";
	    }
	    
	}
	
	</script>

	<script src="js/bootstrap.js"></script>
</body>
</html>
<%
	}
%>