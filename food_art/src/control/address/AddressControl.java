package control.address;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.indirizzoConsegna.IndirizzoConsegnaBean;
import model.indirizzoConsegna.IndirizzoConsegnaDAOImp;

@WebServlet("/address")
public class AddressControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddressControl() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = (String) request.getParameter("page");
		response.sendRedirect(page);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
