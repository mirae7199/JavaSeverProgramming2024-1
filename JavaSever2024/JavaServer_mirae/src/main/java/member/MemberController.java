package member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/mcontroller")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	MemberDAO dao;
       

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		String view = "";
		if(action == null) {
			getServletContext().getRequestDispatcher("/mcontroller?action=list").forward(req, resp);
		}else {
			switch(action) {
			case "list": view = list(req, resp); break;
			case "insert": view = insert(req, resp); break;
			}
			getServletContext().getRequestDispatcher(view).forward(req, resp);
		}
		
		
	}
	
	private String list(HttpServletRequest req, HttpServletResponse resp) {
		req.setAttribute("memberList", dao.getAll());
		return "/memberInfo.jsp";
	}
	
	private String insert(HttpServletRequest req, HttpServletResponse resp) {
		Member m = new Member();
		m.setUserName(req.getParameter("userName"));
		m.setCompany(req.getParameter("company"));
		//m.setBirthday(req.getParameter("birthday"));
		m.setEmail(req.getParameter("email"));
		dao.insert(m);
		return list(req, resp);
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = new MemberDAO();
	}
    
	
}
