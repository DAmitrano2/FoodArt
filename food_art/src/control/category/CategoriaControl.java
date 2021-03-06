package control.category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/categoria")
public class CategoriaControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int idCategoria;
    
    public CategoriaControl() {
        super();
        idCategoria=0;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		idCategoria=Integer.parseInt(request.getParameter("idCategoria"));
		request.setAttribute("idCategoria", idCategoria);
		
		request.setAttribute("page","categoria");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/category.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
