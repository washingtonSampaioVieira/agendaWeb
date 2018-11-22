package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senai.sp.cfp127.dao.ContatoDao;


@WebServlet("/ExcluirContatoServlet")
public class ExcluirContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContatoDao dao = new ContatoDao();
		int cod_contato = Integer.parseInt( request.getParameter("cod_contato"));
		
		if(dao.excluir(cod_contato)) {
			response.sendRedirect("contatos.jsp");
		}else {
			System.out.println("erro ao excluir o contato (ExcluirContatoServet.java)");
		}
	}

}
