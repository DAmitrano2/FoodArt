package control.admin;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.user.UserBean;
import model.user.UserDAOImp;

@WebServlet("/admin/dashboard")
public class UserAdminControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserAdminControl() {
        super();
        this.modelUser = new UserDAOImp();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Controllo se ci sono i permessi di amministrazione
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		
		if( user==null ) {
			String redirectedPage = "/401.jsp";
			response.sendRedirect(request.getContextPath() + redirectedPage);
			return;
		}
		else if( !user.isAmministratore() ) {
			String redirectedPage = "/401.jsp";
			response.sendRedirect(request.getContextPath() + redirectedPage);
			return;
		}
				
		request.setAttribute("pageControl", "utenti");

		try {
				Collection<UserBean> users = (Collection<UserBean>) modelUser.doRetrieveAll();


				request.setAttribute("utenti", users);

		} catch (SQLException e) {
			response.setStatus(400);
			response.getWriter().append("Errore "+e);
			return;
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/dashboard/users.jsp");
		dispatcher.forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private UserDAOImp modelUser;

}
