package control.order;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.address.AddressBean;
import model.address.AddressDAOImp;
import model.card.CardBean;
import model.card.CardDAOImp;
import model.entry.EntryBean;
import model.entry.EntryDAOImp;
import model.order.OrderBean;
import model.order.OrderDAOImp;
import model.product.ProductDAOImp;
import model.user.UserBean;
import service.ProductItem;
import service.ShoppingCart;

@WebServlet("/complete_order")
public class CompleteOrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public CompleteOrderControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("page","complete_order");
		
		UserBean user = (UserBean) request.getSession(false).getAttribute("user");
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		int idIndirizzoConsegna = Integer.parseInt(request.getParameter("address"));
		String nCarta = request.getParameter("card");
		
		AddressDAOImp addressDAO = new AddressDAOImp();
		CardDAOImp cardDAO = new CardDAOImp();
		AddressBean addressBean = new AddressBean();
		CardBean cardBean = new CardBean();
		
		try {
			addressBean = addressDAO.doRetriveByKey(idIndirizzoConsegna);
			cardBean = cardDAO.getMetodoPagamentoByCard(nCarta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Date dataOra = new java.sql.Date(System.currentTimeMillis());
		
		OrderDAOImp orderDAO = new OrderDAOImp();
		
		try {
			OrderBean orderBean = new OrderBean();
			orderBean.setDataOra(dataOra);
			orderBean.setVia(addressBean.getVia());
			orderBean.setNumeroCivico(addressBean.getNumeroCivico());
			orderBean.setCitta(addressBean.getCitta());
			orderBean.setProvincia(addressBean.getProvincia());
			orderBean.setCap(addressBean.getCap());
			orderBean.setNumeroCarta(cardBean.getNumeroCarta());
			orderBean.setStato("In elaborazione");
			orderBean.setIdUtente(user.getIdUtente());
			
			orderDAO.doSave(orderBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int idOrder = 0;
		
		try {
			idOrder = orderDAO.doRetrieveLastOrder(user.getIdUtente());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		EntryDAOImp voceDAO = new EntryDAOImp();
		EntryBean voceBean = new EntryBean();
		ProductDAOImp productDAO = new ProductDAOImp();
		ArrayList<ProductItem> productCart = cart.getProducts();
		
		
		for(ProductItem product: productCart) {
			try {
				voceBean.setIdOrdine(idOrder);
				voceBean.setIdProdotto(product.getIdProdotto());
				voceBean.setQuantita(product.getQuantita());
				voceBean.setPrezzo(Float.parseFloat(product.getPrezzo().replace(",", ".")));

				voceDAO.doSave(voceBean);
				
				productDAO.updateQuantita(product.getIdProdotto(), product.getQuantitaDisponibile()-product.getQuantita());
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		request.getSession().removeAttribute("cart");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/complete_order.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}	
}