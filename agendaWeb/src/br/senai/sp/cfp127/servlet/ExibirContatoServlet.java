package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.sp.cfp127.dao.ContatoDao;
import br.senai.sp.cfp127.model.Contato;

/**
 * Servlet implementation class ExibirContatoServlet
 */
@WebServlet("/ExibirContatoServlet")
public class ExibirContatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContatoDao dao = new ContatoDao();
		int codContato = Integer.parseInt( request.getParameter("cod_contato"));
		
		Contato contato = new Contato();
		contato = dao.getContato (codContato );
		
		request.getSession().setAttribute("contato", contato);
			
		response.sendRedirect("exibirContato.jsp");
	
		
		
	}

}
