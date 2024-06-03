package productegTest;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductControllerTest2
 */
@WebServlet("/pcontrollerTest2")
public class ProductControllerTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductServiceTest service;
	
	public ProductControllerTest2() {
		service = new ProductServiceTest();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String view = "";
		
		if(request.getParameter("action") == null) {
			getServletContext().getRequestDispatcher("/pcontrollerTest2?action=list").forward(request, response);
		}else {
			switch(action) {
			case "list": view = list(request, response); break;
			case "info": view = info(request, response); break;
			}
			getServletContext().getRequestDispatcher(view).forward(request, response);
		}
	}
	
	private String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("products", service.findAll());
		return "/productListTest.jsp";
	}

	private String info(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("p", service.findById(request.getParameter("id")));
		return "/productInfoTest.jsp";
	}
}
