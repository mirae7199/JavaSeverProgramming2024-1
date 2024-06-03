package producteg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductControllerTest
 */
@WebServlet("/pcontrollerTest")
public class ProductControllerTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductServiceTest service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductControllerTest() {
        super();
        service = new ProductServiceTest();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String view = "";
		
		if(request.getParameter("action") == null) {
			getServletContext().getRequestDispatcher("/pcontrollerTest?action=list").forward(request, response);
		}else {
			switch(action) {
			case "list" : view = list(request, response); break;
			case "info" : view = info(request, response); break;
			}
			
			getServletContext().getRequestDispatcher(view).forward(request, response);
			
		}
	}
	
	private String info(HttpServletRequest request, HttpServletResponse response) {
		// 보낼 데이터 지정
		request.setAttribute("p", service.findById(request.getParameter("id"))); // ("key", "value")
		return "/productInfoTest.jsp";
	}
	
	private String list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("products", service.findAll());
		return "/productListTest.jsp";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
