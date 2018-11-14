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


@WebServlet("/CadastrarContatoServlet")
public class CadastrarContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CadastrarContatoServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario u = new Usuario();
		u =	(Usuario) request.getSession().getAttribute("usuario");
		
		Contato c = new Contato();
		c.setEmail(request.getParameter("email"));
		c.setEndereco(request.getParameter("endereco"));
		c.setNome(request.getParameter("nome"));
		c.setUsuario(u);
		c.setTelefone(request.getParameter("telefone"));
		
		ContatoDao dao = new ContatoDao();
		if(dao.gravar(c)) {
			response.sendRedirect("contatos.jsp");
		}else {
			response.sendRedirect("CriarContato.jsp");
		}
	}

}
