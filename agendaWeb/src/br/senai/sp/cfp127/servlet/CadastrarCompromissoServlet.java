package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.senai.sp.cfp127.dao.CompromissoDao;
import br.senai.sp.cfp127.model.Compromisso;
import br.senai.sp.cfp127.model.Usuario;


@WebServlet(description = "cadastra um compromisso no banco.", urlPatterns = { "/CadastrarCompromissoServlet" })
public class CadastrarCompromissoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public  CadastrarCompromissoServlet() {
		super();
	}
   
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Compromisso c = new Compromisso();
		c.setTitulo(request.getParameter("titulo"));
		c.setData(request.getParameter("data"));
		c.setHoraFim( request.getParameter("horaFim"));
		c.setHoraInicio(request.getParameter("horaInicio"));
		c.setPrioridade(Integer.parseInt(request.getParameter("prioridade")));
		c.setDescricao(request.getParameter("descricao"));
		
		Usuario u = new Usuario();
		u = (Usuario) request.getSession().getAttribute("usuario");
		c.setUsuario(u );
		
		CompromissoDao  compromissoDao= new CompromissoDao();
		if(compromissoDao.gravar(c)) {
			response.sendRedirect("compromissos.jsp");
		}else {
			response.sendRedirect("criarCompromisso.jsp");
		}
		
		
	}

}
