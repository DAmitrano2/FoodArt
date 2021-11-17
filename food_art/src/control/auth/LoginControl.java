package control.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.google.gson.*;

import model.utente.UtenteBean;
import model.utente.UtenteDAOImp;

@WebServlet("/login")
public class LoginControl extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UtenteDAOImp model;

	public LoginControl() {
		super();
		this.model = new UtenteDAOImp();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
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
		
		request.setAttribute("page", "login");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String remember = request.getParameter("remember");
		
		Base64.Encoder enc = Base64.getEncoder();
		String encodedPass = enc.encodeToString(password.getBytes());
		String jsonMessage = null;
		
		try {
			if( !model.isEmail(email) ) {
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.setStatus(401);
				
				request.setAttribute("errorMessage", "email non esistente");
				
				Gson json = new Gson();
				jsonMessage = "{\"message\":\"Email non esistente\"}";
				String jsonString = json.toJson(jsonMessage);
				
				out.print(jsonString);
				out.flush();
				return;
			}
			UtenteBean user = model.doRetrieveByKey(email, encodedPass);
			
			if( user == null ) {
				PrintWriter out = response.getWriter();
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.setStatus(401);
				
				request.setAttribute("errorMessage", "email e password non coincidono");
				
				Gson json = new Gson();
				
				jsonMessage = "{\"message\":\"Email e password non coincidono\"}";
				String jsonString = json.toJson(jsonMessage);
				
				out.print(jsonString);
				out.flush();
				
				return;
			}
			if(user!=null) {
				
				if(remember!=null) {
					if( remember.equalsIgnoreCase("remember-me") ) {
						Cookie ckEmail = new Cookie ("email",email);
						Cookie ckPassword = new Cookie ("password",password);
						
						response.addCookie(ckEmail);
						response.addCookie(ckPassword);
					}
				}
				
				request.getSession(true);
				
				request.getSession().setAttribute("user", user);
				response.setStatus(200);
				
				request.setAttribute("errorMessage", "Login va");
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
		}
	}
}