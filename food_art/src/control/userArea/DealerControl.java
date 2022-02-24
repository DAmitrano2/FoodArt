package control.userArea;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dealer_info")
public class DealerControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int idDealer;
       
    public DealerControl() {
        super();
        idDealer=0;
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "dealer_info");
		
		idDealer = Integer.parseInt(request.getParameter("idDealer"));
		request.setAttribute("idDealer", idDealer);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dealer_info.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}