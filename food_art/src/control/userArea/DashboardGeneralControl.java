package control.userArea;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dashboard/dashboard_general")
public class DashboardGeneralControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DashboardGeneralControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "dashboard_general");
		String title = String.valueOf(request.getParameter("title"));

		request.setAttribute("title", title);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dashboard_general.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}