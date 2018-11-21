package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cfp127.dao.ContatoDao;
import br.senai.sp.cfp127.model.Contato;
import br.senai.sp.cfp127.model.Usuario;

/**
 * Servlet implementation class AtualizarContato
 */
@WebServlet("/AtualizarContato")
public class AtualizarContato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		Contato c = new Contato();
		c.setCodContato(Integer.parseInt(request.getParameter("txt-cod")));
		c.setEmail(request.getParameter("email"));
		c.setEndereco(request.getParameter("endereco"));
		c.setNome(request.getParameter("nome"));
		c.setTelefone(request.getParameter("telefone"));
		
		ContatoDao dao = new ContatoDao();
		if(dao.atulizar(c)) {
			response.sendRedirect("contatos.jsp");
		}else {
			response.sendRedirect("atualizarContato.jsp");
		}
	}

}
