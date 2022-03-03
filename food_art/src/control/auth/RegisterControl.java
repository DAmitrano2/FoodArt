package control.auth;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.dealer.DealerBean;
import model.dealer.DealerDAOImp;
import model.user.UserBean;
import model.user.UserDAOImp;

@WebServlet("/register")
@MultipartConfig(maxFileSize = 50000000)
public class RegisterControl extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private UserDAOImp modelUser;
	private DealerDAOImp modelSeller;

    public RegisterControl() {
        super();
        this.modelUser = new UserDAOImp();
        this.modelSeller = new DealerDAOImp();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page","register");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=0;
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String rivenditore = request.getParameter("rivenditore");
		
		UserBean user = new UserBean();
		
		//Codifica della password
		Base64.Encoder enc = Base64.getEncoder();
		String encodedPass = enc.encodeToString(password.getBytes());
		
		
		
		boolean bool = false;
		DealerBean dealer = new DealerBean();
		if(rivenditore != null) {	
			if( rivenditore.equalsIgnoreCase("rivenditore-check") ) {
				user.setEmail(email);
				user.setPassword(encodedPass);
				user.setNome(nome);
				user.setCognome(cognome);
				
				byte[] bytes = null;
				
			    Part filePart = request.getPart("fProfilo");
	
			    bytes = filePart.getInputStream().readAllBytes();
				user.setPathName(bytes);
				
				user.setRivenditore(true);
				
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
				
				Date date=new Date(0);
				date=Date.valueOf(data);
				
				dealer.setDataNascita(date);
				dealer.setSesso(sesso);
				dealer.setCitta(citta);
				dealer.setProvincia(provincia);
				dealer.setCodiceFiscale(codiceFiscale);
				dealer.setRagioneSociale(ragioneSociale);
				dealer.setProvinciaSedeLegale(provinciaSedeLegale);
				dealer.setCittaSedeLegale(cittaSedeLegale);
				dealer.setViaSedeLegale(viaSedeLegale);
				dealer.setCapSedeLegale(capSedeLegale);
				dealer.setNumeroCivicoSedeLegale(nCivicoSedeLegale);
				dealer.setNumeroPartitaIva(nPartitaIVA);
				
				bytes = null;
				
			    filePart = request.getPart("fPartitaIVA");
	
			    bytes = filePart.getInputStream().readAllBytes();
				dealer.setFilePartitaIva(bytes);
				
				bytes = null;
				filePart = request.getPart("fCartaIdentita");
				bytes = filePart.getInputStream().readAllBytes();
				dealer.setFileDocumentoIdentita(bytes);
				
				bool = true;
			}
		}else {
			user.setEmail(email);
			user.setPassword(encodedPass);
			user.setNome(nome);
			user.setCognome(cognome);
			
			byte[] bytes = null;
			
		    Part filePart = request.getPart("fProfilo");

		    bytes = filePart.getInputStream().readAllBytes();
			user.setPathName(bytes);
		}

		try {
			if(user != null && UserBean.matches(user)) {
				id=modelUser.doSave(user);
				request.getSession(true);
				request.getSession().setAttribute("user", user);
				response.setStatus(200);
			}
			if(bool && DealerBean.matches(dealer)) {
				dealer.setIdUtente(id);
				modelSeller.doSave(dealer);
				request.getSession(true);
				request.getSession().setAttribute("seller", dealer);
				response.setStatus(200);
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
			return;
		}
	}

}
