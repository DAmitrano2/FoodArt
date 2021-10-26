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

import model.indirizzoConsegna.IndirizzoConsegnaBean;
import model.indirizzoConsegna.IndirizzoConsegnaDAOImp;
import model.metodoPagamento.MetodoPagamentoBean;
import model.metodoPagamento.MetodoPagamentoDAOImp;
import model.ordine.OrdineBean;
import model.ordine.OrdineDAOImp;
import model.prodotto.ProdottoDAOImp;
import model.utente.UtenteBean;
import model.voce.VoceBean;
import model.voce.VoceDAOImp;
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
		
		UtenteBean user = (UtenteBean) request.getSession(false).getAttribute("user");
		ShoppingCart cart = (ShoppingCart) request.getSession().getAttribute("cart");
		int idIndirizzoConsegna = Integer.parseInt(request.getParameter("address"));
		String nCarta = request.getParameter("card");
		
		IndirizzoConsegnaDAOImp addressDAO = new IndirizzoConsegnaDAOImp();
		MetodoPagamentoDAOImp cardDAO = new MetodoPagamentoDAOImp();
		IndirizzoConsegnaBean addressBean = new IndirizzoConsegnaBean();
		MetodoPagamentoBean cardBean = new MetodoPagamentoBean();
		
		try {
			addressBean = addressDAO.doRetriveByKey(idIndirizzoConsegna);
			cardBean = cardDAO.getMetodoPagamentoByCard(nCarta);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Date dataOra = new java.sql.Date(System.currentTimeMillis());
		
		OrdineDAOImp orderDAO = new OrdineDAOImp();
		
		try {
			OrdineBean orderBean = new OrdineBean();
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
		
		VoceDAOImp voceDAO = new VoceDAOImp();
		VoceBean voceBean = new VoceBean();
		ProdottoDAOImp productDAO = new ProdottoDAOImp();
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