package control.cart;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.prodotto.ProdottoBean;
import model.prodotto.ProdottoDAOImp;
import service.ProductItem;
import service.ShoppingCart;

@SuppressWarnings("serial")
@WebServlet(name = "CartControl", urlPatterns = "/cart")
public class CartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProdottoDAOImp model;
    
    public CartControl() {
        super();
        this.model = new ProdottoDAOImp();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String page = (String) request.getParameter("page");
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		
		if(cart == null) {
			cart = new ShoppingCart();
			request.getSession().setAttribute("cart", cart);
		}
		
		String action = request.getParameter("action");
		
		try (PrintWriter out = response.getWriter()){
			if (action != null) {
				if (action.equalsIgnoreCase("add")) {
					int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
					ProdottoBean bean = (ProdottoBean) model.doRetrieveByKey(idProdotto);
					ProductItem prod = new ProductItem(bean);
					if( !cart.addProductItem(prod) ) {
			    		response.setStatus(400);
			    	}
					request.getSession().setAttribute("cart", cart);
					request.setAttribute("cart", cart);

			        response.sendRedirect(page);
				}
				else if (action.equalsIgnoreCase("delete")) {
					
					int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
					
			    	cart.removeProductItem(idProdotto);
			    	request.getSession().setAttribute("cart", cart);
					request.setAttribute("cart", cart);

			        response.sendRedirect("shopping_cart");
				}
				else if (action.equalsIgnoreCase("set")) {
					int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
					int quantita = Integer.parseInt(request.getParameter("quantita"));
					ProdottoBean bean = (ProdottoBean) model.doRetrieveByKey(idProdotto);
					ProductItem prod = new ProductItem(bean);
					if( !cart.addQuantityProductItem(prod, quantita) ) {
			    		response.setStatus(400);
			    	}
					request.getSession().setAttribute("cart", cart);
					request.setAttribute("cart", cart);

			        response.sendRedirect(page);
				}
			}
		} catch (SQLException e) {
			response.setStatus(400);
		}
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
