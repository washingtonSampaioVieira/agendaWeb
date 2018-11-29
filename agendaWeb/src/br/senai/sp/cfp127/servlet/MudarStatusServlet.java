package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cfp127.dao.CompromissoDao;

/**
 * Servlet implementation class MudarStatusServlet
 */
@WebServlet("/MudarStatusServlet")
public class MudarStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MudarStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cod=Integer.parseInt( request.getParameter("cod_compromisso"));
		int status =Integer.parseInt(request.getParameter("status"));
		
		CompromissoDao dao = new CompromissoDao();
		if(dao.atulizarStatus(cod, status)) {
			response.sendRedirect("compromissos.jsp");
			
		}else {
			System.out.println("deu atualizar na servlet errado");
		}
	}

}
