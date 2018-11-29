package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import br.senai.sp.cfp127.dao.CompromissoDao;
import br.senai.sp.cfp127.dao.ContatoDao;
import br.senai.sp.cfp127.model.Compromisso;
import br.senai.sp.cfp127.model.Contato;
import br.senai.sp.cfp127.model.Usuario;

/**
 * Servlet implementation class BuscarContatoServlet
 */
@WebServlet("/BuscarCompromissoServlet")
public class BuscarCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public BuscarCompromissoServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		
		Compromisso c = new Compromisso();
		
		CompromissoDao dao = new CompromissoDao();
		int cod = Integer.parseInt(request.getParameter("cod_compromisso"));
		c = dao.getCompromisso(cod);
		
		HttpSession sessao = request.getSession();
		sessao.setAttribute("compromisso", c);
		
		response.sendRedirect("editarCompromisso.jsp");
		
			
		
		
		
		
		
	}

}
