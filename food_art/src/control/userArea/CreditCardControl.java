package control.userArea;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.card.CardBean;
import model.card.CardDAOImp;
import model.user.UserBean;


@WebServlet("/dashboard/dashboard_general/add_credit_card")
public class CreditCardControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private CardDAOImp modelCard;
       
    public CreditCardControl() {
        super();
        this.modelCard = new CardDAOImp();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "add_credit_card");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/add_credit_card.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		
		String nome = request.getParameter("name");
		String nCarta = request.getParameter("nCard");
		String data = request.getParameter("date");
		String cvv = request.getParameter("cvv");
		nCarta = nCarta.replaceAll(" ", "");
		data = data.replaceAll(" ", "");
		String m = (String) data.subSequence(0, data.indexOf("/"));
		String y = (String) data.subSequence(data.indexOf("/")+1, data.length());
		
		Timestamp ts = Timestamp.valueOf(y+"-"+m+"-01 00:00:00.0000");
        
		Date date = new Date(ts.getTime());
        
		
		try {
			CardBean card = new CardBean();
			card.setIntestatario(nome);
			card.setNumeroCarta(nCarta);
			card.setDataScadenza(date);
			card.setCvv(cvv);
			card.setIdUtente(user.getIdUtente());
			
			if(card == null ) {
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.setStatus(401);
				
				request.setAttribute("errorMessage", "Dati non corretti");
				
				request.setAttribute("page", "add_credit_card");
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/add_credit_card.jsp");
				dispatcher.forward(request, response);
			}
			if(card != null) {
				modelCard.doSave(card);
				response.setStatus(200);
				
				request.setAttribute("page","dashboard");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dashboard.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("errorMessage", "Dati non corretti");
			request.setAttribute("page", "add_credit_card");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/add_credit_card.jsp");
			dispatcher.forward(request, response);
			System.out.println("Error: "+e.getMessage());
			return;
		}
	}

}
