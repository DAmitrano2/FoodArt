package control.auth;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout")
public class LogoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LogoutControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		if(request.getSession().getAttribute("user") != null) {
			request.getSession().removeAttribute("user");
			request.getSession().invalidate();
			dispatcher = getServletContext().getRequestDispatcher("/login");
		}else if (request.getSession().getAttribute("user") == null) {
			dispatcher = getServletContext().getRequestDispatcher("/index");
		}
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
