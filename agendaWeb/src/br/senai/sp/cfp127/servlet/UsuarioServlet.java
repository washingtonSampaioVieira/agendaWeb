package br.senai.sp.cfp127.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.senai.sp.cfp127.dao.UsuarioDao;
import br.senai.sp.cfp127.model.Usuario;

@WebServlet("/UsuarioServlet")
public class UsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UsuarioServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario u = new Usuario();
		u.setNome(request.getParameter("txt-nome"));
		u.setEmail(request.getParameter("txt-email"));
		u.setSenha(request.getParameter("txt-senha1"));
		u.setDtNascimento(request.getParameter("txt-nascimento"));
		u.setSexo(request.getParameter("txt-sexo").substring(0, 1));
		if (request.getParameter("txt-cod").length() > 0) {
			u.setCod(Integer.parseInt(request.getParameter("txt-cod")));
		}

		UsuarioDao dao = new UsuarioDao();
		dao.setUsuario(u);

		request.getRequestURL();
		if (u.getCod() == 0) {
			if (dao.gravar()) {
				response.sendRedirect("sucesso.html");
			} else {
				response.sendRedirect("novo-usuario.html");
			}
		} else if (dao.atualizar()) {
			HttpSession sessao = request.getSession();
			sessao.setAttribute("usuario", u);
			response.sendRedirect("index.jsp");
		} 
		//else{
		//response.sendRedirect("editarUsuario.jsp");
//		}

	}

}
