package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class encerrarSessaoServlet
 */
@WebServlet("/encerrarSessaoServlet")
public class encerrarSessaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public encerrarSessaoServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getSession().invalidate();
		response.sendRedirect("login.html");
		// invalidando a servlet para nao poder se conectar sem fazer login
		
	}

}
