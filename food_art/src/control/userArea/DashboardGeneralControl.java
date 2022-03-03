package control.userArea;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.address.AddressDAOImp;
import model.card.CardDAOImp;
import model.product.ProductDAOImp;

@WebServlet("/dashboard/dashboard_general")
public class DashboardGeneralControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DashboardGeneralControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "dashboard_general");
		String title = String.valueOf(request.getParameter("title"));

		String action = request.getParameter("action");
		
		try {
			if (action != null) {
				if (action.equalsIgnoreCase("delete")) {
					if(title.equals("Indirizzi")) {
						int idIndirizzo = Integer.parseInt(request.getParameter("id"));
						
						AddressDAOImp addressDao = new AddressDAOImp();
						addressDao.doDelete(idIndirizzo);
					}else if(title.equals("I miei pagamenti")) {
						String nCarta = request.getParameter("id");
						
						CardDAOImp cardDao = new CardDAOImp();
						cardDao.doDelete(nCarta);
					}else if(title.equals("I miei prodotti")) {
						int idProdotto = Integer.parseInt(request.getParameter("id"));
						
						ProductDAOImp productDao = new ProductDAOImp();
						productDao.doDelete(idProdotto);
					}
				}
			}
		} catch (SQLException e) {
			response.setStatus(400);
		}
		request.setAttribute("title", title);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dashboard_general.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}