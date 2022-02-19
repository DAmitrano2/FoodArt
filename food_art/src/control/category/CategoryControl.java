package control.category;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/category")
public class CategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int idCategoria;
    
    public CategoryControl() {
        super();
        idCategoria=0;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page","category");
		
		idCategoria=Integer.parseInt(request.getParameter("idCategoria"));
		request.setAttribute("idCategoria", idCategoria);
		
		if(idCategoria>0) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/category.jsp");
			dispatcher.forward(request, response);
		}
		else if(idCategoria==0) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/all_category.jsp");
			dispatcher.forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
