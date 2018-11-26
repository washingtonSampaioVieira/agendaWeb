//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.mysql.cj.x.protobuf.MysqlxNotice.SessionStateChanged;
//
//import br.senai.sp.cfp127.dao.CompromissoDao;
//import br.senai.sp.cfp127.model.Compromisso;
//import br.senai.sp.cfp127.model.Usuario;
//
//
//@WebServlet(description = "servlet responsavel por fazer o filtro do status", urlPatterns = { "/FiltroDeCompromissosServlet" })
//public class FiltroDeCompromissosServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    
//    public FiltroDeCompromissosServlet() {
//        super();
//        
//    }
//
//	
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		CompromissoDao dao = new CompromissoDao();
//		ArrayList<Compromisso> compromissos = new ArrayList<>();
//		Usuario u = new Usuario();
//		
//		u = (Usuario) request.getSession().getAttribute("usuario");
//		
//		String sql="";
//		if(request.getParameter("filtro")==null) {
//			 sql="SELECT * FROM tbl_compromisso WHERE cod_usuario ="+u.getClass();
//		}else {
//			int tipo =Integer.parseInt(request.getParameter("filtro"));
//			 sql="SELECT * FROM tbl_compromisso WHERE cod_usuario ="+u.getClass()+" AND status="+tipo;
//		}
//
////		compromissos = dao.getCompromissosFiltro(sql);
////		HttpSession sessao = request.getSession();
////		
////		request.getSession().setAttribute("compromissos", Compromisso );
////		
////		
////		
////		
////		
////		ArrayList<Compromisso>  compromissos  = (ArrayList) session.getAttribute("compromissos");
////		
////		
////		response.sendRedirect("compromissos.jsp");
//		
//			
//		
//		
//		
//	}
//
//}
