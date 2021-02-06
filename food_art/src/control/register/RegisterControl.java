package control.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.rivenditore.RivenditoreDAOImp;
import model.utente.UtenteBean;
import model.utente.UtenteDAOImp;

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
		
		Cookie[] cookies = request.getCookies();
		for(int i=0; cookies !=null && i<cookies.length; i++)
		{
		   if(cookies[i].getName().equals("email"))
		   {
			   request.setAttribute("cookieEmail", cookies[i].getValue());
		   }
		   
		   if(cookies[i].getName().equals("password"))
		   {
			   request.setAttribute("cookiePassword", cookies[i].getValue());
		   }
		}
		
		request.setAttribute("page","register");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String rivenditore = request.getParameter("rivenditore");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		
		
		Base64.Encoder enc = Base64.getEncoder();
		String encodedPass = enc.encodeToString(password.getBytes());
		String jsonMessage = null;
		
		try {
			
			if( !modelUser.isEmail(email) ) {
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				//response.setCharacterEncoding("UTF-8");
				response.setStatus(401);
				
				Gson json = new Gson();
				
				jsonMessage = "{\"message\":\"Email non esistente\"}";
				String jsonString = json.toJson(jsonMessage);
				
				out.print(jsonString);
				out.flush();
				return;
			}
			UtenteBean user = modelUser.doRetrieveByKey(email, encodedPass);
			
			if( user == null ) {
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				//response.setCharacterEncoding("UTF-8");
				response.setStatus(401);
				
				Gson json = new Gson();
				
				jsonMessage = "{\"message\":\"Email e password non coincidono\"}";
				String jsonString = json.toJson(jsonMessage);
				
				out.print(jsonString);
				out.flush();
				
				return;
			}
			if(user!=null) {
				
				if(rivenditore!=null) {
					if( rivenditore.equalsIgnoreCase("remember-me") ) {
						System.out.println("equals");
						Cookie ckEmail = new Cookie ("email",email);
						Cookie ckPassword = new Cookie ("password",password);
						
						response.addCookie(ckEmail);
						response.addCookie(ckPassword);
						
						
					}
				}
				
				request.getSession(true);
				
				request.getSession().setAttribute("user",user);
				response.setStatus(200);
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}

}
