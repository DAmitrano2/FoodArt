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

import model.dealer.DealerDAOImp;
import model.feedback.FeedbackDAOImp;
import model.product.ProductDAOImp;
import model.user.UserBean;
import model.user.UserDAOImp;

@WebServlet("/admin_dashboard")
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
				
		request.setAttribute("page", "admin_dashboard");

		try {
			Collection<UserBean> users = modelUser.doRetrieveAll();

			request.setAttribute("utenti", users);

		} catch (SQLException e) {
			response.setStatus(400);
			response.getWriter().append("Errore "+e);
			return;
		}
		
		String type = request.getParameter("type");
		String action = request.getParameter("action");
		
		try {
			if (action != null) {
				if(type.equals("Prodotto")) {
					if (action.equalsIgnoreCase("delete")) {
						
						int id = Integer.parseInt(request.getParameter("id"));
						
						ProductDAOImp productDao = new ProductDAOImp();
						productDao.doDelete(id);
					}
				}else if(type.equals("Rivenditore")) {
					if (action.equalsIgnoreCase("delete")) {
						
						int id = Integer.parseInt(request.getParameter("id"));

						DealerDAOImp dealerDao = new DealerDAOImp();
						dealerDao.doDelete(id);
					}
				}else if(type.equals("Commento")) {
					if (action.equalsIgnoreCase("delete")) {
						
						int id = Integer.parseInt(request.getParameter("id"));
 
						FeedbackDAOImp feedbackDao = new FeedbackDAOImp();
						feedbackDao.doDelete(id);
					}
				}
			}
		} catch (SQLException e) {
			response.setStatus(400);
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin_dashboard.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private UserDAOImp modelUser;

}
