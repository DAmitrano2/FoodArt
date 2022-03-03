package control.userArea;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.address.AddressBean;
import model.address.AddressDAOImp;
import model.user.UserBean;


@WebServlet("/dashboard/dashboard_general/add_address")
public class AddressControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private AddressDAOImp modelAddress;
	
    public AddressControl() {
        super();
        this.modelAddress = new AddressDAOImp();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "add_address");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/add_address.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		
		String nome = request.getParameter("name");
		String cognome = request.getParameter("surname");
		String via = request.getParameter("road");
		String nCivico = request.getParameter("hnumber");
		String citta = request.getParameter("city");
		String cap = request.getParameter("cap");
		String provincia = request.getParameter("province");
		String nTelefono = request.getParameter("tnumber");
		String info = request.getParameter("addInfo");
		
		try {
			AddressBean address = new AddressBean();
			address.setNome(nome);
			address.setCognome(cognome);
			address.setVia(via);
			address.setNumeroCivico(nCivico);
			address.setCitta(citta);
			address.setCap(cap);
			address.setProvincia(provincia);
			address.setNumeroTelefono(nTelefono);
			address.setDescrizione(info);
			address.setIdUtente(user.getIdUtente());
			
			if(address == null ) {
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.setStatus(401);
				
				request.setAttribute("errorMessage", "Dati non corretti");
				
				request.setAttribute("page", "add_address");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/add_address.jsp");
				dispatcher.forward(request, response);
			}
			if(address != null) {
				
				modelAddress.doSave(address);
				response.setStatus(200);
				
				request.setAttribute("page","dashboard");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dashboard.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("errorMessage", "Dati non corretti");
			request.setAttribute("page", "add_address");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/add_address.jsp");
			dispatcher.forward(request, response);
			System.out.println("Error: "+e.getMessage());
			return;
		}
	}
}
