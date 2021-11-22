package control.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/single_product")
public class SingleProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int idProdotto;

    public SingleProductControl() {
        super();
        idProdotto=0;
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		idProdotto=Integer.parseInt(request.getParameter("idProdotto"));
		request.setAttribute("idProdotto", idProdotto);
		
		request.setAttribute("page","single_product");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/single_product.jsp");
		dispatcher.forward(request, response);		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
