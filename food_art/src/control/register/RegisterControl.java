package control.register;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.rivenditore.RivenditoreBean;
import model.rivenditore.RivenditoreDAOImp;
import model.utente.UtenteBean;
import model.utente.UtenteDAOImp;

@SuppressWarnings("serial")
@WebServlet("/register")
public class RegisterControl extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private UtenteDAOImp modelUser;
	private RivenditoreDAOImp modelSeller;

    public RegisterControl() {
        super();
        this.modelUser = new UtenteDAOImp();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("page","register");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("sesso");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String rivenditore = request.getParameter("rivenditore");
		
		if(rivenditore!=null) {
			if( rivenditore.equalsIgnoreCase("rivenditore-check") ) {
				String data = request.getParameter("data");
				String sesso = request.getParameter("sesso");
				String citta = request.getParameter("citta");
				String provincia = request.getParameter("provincia");
				String codiceFiscale = request.getParameter("codiceFiscale");
				String ragioneSociale = request.getParameter("ragioneSociale");
				String provinciaSedeLegale = request.getParameter("provinciaSedeLegale");
				String cittaSedeLegale = request.getParameter("cittaSedeLegale");
				String viaSedeLegale = request.getParameter("viaSedeLegale");
				String capSedeLegale = request.getParameter("capSedeLegale");
				String nCivicoSedeLegale = request.getParameter("nCivicoSedeLegale");
				String nPartitaIVA = request.getParameter("nPartitaIVA");
				String fPartitaIVA = request.getParameter("fPartitaIVA");
				String fCartaIdentita = request.getParameter("fCartaIdentita");
				System.out.println("sesso: "+ sesso);
			}
		}
		
		UtenteBean user = new UtenteBean();
		RivenditoreBean seller = new RivenditoreBean();
		
		Base64.Encoder enc = Base64.getEncoder();
		String encodedPass = enc.encodeToString(password.getBytes());
		String jsonMessage = null;
		
		try {
			if(user!=null) {
				modelUser.doSave(user);
				request.getSession(true);
				request.getSession().setAttribute("user",user);
				response.setStatus(200);
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
			if(seller!=null) {
				modelSeller.doSave(seller);
				request.getSession(true);
				request.getSession().setAttribute("seller",seller);
				response.setStatus(200);
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
			return;
		}
	}

}
