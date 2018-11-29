package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.sp.cfp127.dao.CompromissoDao;
import br.senai.sp.cfp127.model.Compromisso;
import br.senai.sp.cfp127.model.Usuario;

/**
 * Servlet implementation class AtualizarCompromissoServlet
 */
@WebServlet("/AtualizarCompromissoServlet")
public class AtualizarCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AtualizarCompromissoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Compromisso c = new Compromisso();
		c.setTitulo(request.getParameter("titulo"));
		c.setCod_compromisso(Integer.parseInt(request.getParameter("txt-cod")));
		c.setData(request.getParameter("data"));
		c.setHoraFim( request.getParameter("horaFim"));
		c.setHoraInicio(request.getParameter("horaInicio"));
		c.setPrioridade(Integer.parseInt(request.getParameter("prioridade")));
		c.setDescricao(request.getParameter("descricao"));
		CompromissoDao dao = new CompromissoDao();
		
		if(dao.atulizar(c)) {
			response.sendRedirect("compromissos.jsp");
		}else {
			response.sendRedirect("editarCompromisso.jsp");
		}

	}

}
