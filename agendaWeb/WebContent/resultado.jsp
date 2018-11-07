<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!-- Tudo que é escrito aqui é código Java -->
<%
	String email = request.getParameter("txt-email");
	String senha = request.getParameter("txt-senha1");
	String nome = request.getParameter("txt-nome");

%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>resulado.jsp</title>
</head>
<body>
	<h1><%= email %> </h1><br>
		<%= senha %><br>
		<%= nome %>
</body>
</html>