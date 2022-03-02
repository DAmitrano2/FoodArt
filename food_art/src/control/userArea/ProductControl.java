package control.userArea;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.image.ImageBean;
import model.image.ImageDAOImp;
import model.product.ProductBean;
import model.product.ProductDAOImp;
import model.user.UserBean;


@WebServlet("/dashboard/dashboard_general/add_product")
@MultipartConfig(maxFileSize = 50000000)
public class ProductControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ProductDAOImp modelProduct;
	
    public ProductControl() {
        super();
        this.modelProduct = new ProductDAOImp();
    }
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("page", "add_product");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/add_product.jsp");
		dispatcher.forward(request, response);
	}

	@SuppressWarnings("unused")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		System.out.println("sto dentro: "+user.getIdUtente());
		
		ProductDAOImp productDao = new ProductDAOImp();
		ImageDAOImp imageDao = new ImageDAOImp();
		System.out.println("title: "+request.getParameter("productName")+" categoria: "+request.getParameter("category")+" desc: "+request.getParameter("exampleFormControlTextarea1")+" price: "+request.getParameter("price")+" quant disp: "+request.getParameter("qtydisp"));
		String descrizione = request.getParameter("exampleFormControlTextarea1");
		System.out.println("descrizione: "+descrizione);
		String prezzo = request.getParameter("price");
		System.out.println("prezzo: "+prezzo);
		String uMisura = request.getParameter("unmeasure");
		System.out.println("uMisura: "+uMisura);
		int quantitaMin = Integer.parseInt(request.getParameter("qtymin"));
		System.out.println("quantitaMin: "+quantitaMin);
		int quantitaDisponibile = Integer.parseInt(request.getParameter("qtydisp"));
		System.out.println("quantitaDisponibile: "+quantitaDisponibile);
		
		String titolo = request.getParameter("productName");
		int categoria = Integer.parseInt(request.getParameter("category"));
		System.out.println("categoria: "+categoria);
		
		byte[] bytes = null;
		
	    Part filePart = request.getPart("fProduct");

	    bytes = filePart.getInputStream().readAllBytes();
		
		try {
			ProductBean product = new ProductBean();
			product.setTitolo(titolo);
			product.setIdCategoria(categoria);
			product.setPrezzo(prezzo);
			product.setDescrizione(descrizione);
			product.setUnitaMisura(uMisura);
			product.setQuantitaMinima(quantitaMin);
			product.setQuantitaDisponibile(quantitaDisponibile);
			product.setIdUtente(user.getIdUtente());
			
			if(product == null ) {
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.setStatus(401);
				
				request.setAttribute("errorMessage", "Dati non corretti");
				
				request.setAttribute("page", "add_product");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/add_product.jsp");
				dispatcher.forward(request, response);
			}
			if(product != null) {
				modelProduct.doSave(product);
				response.setStatus(200);
				
				ImageBean img = new ImageBean();
				ImageDAOImp modelImg = new ImageDAOImp();
				img.setPathName(bytes);
				
				Collection<ProductBean> lastProd = modelProduct.getLastArrivals(1);
				if (lastProd != null && lastProd.size() != 0) {
         			for(ProductBean prod: lastProd) {
						img.setIdProdotto(prod.getIdProdotto());
         			}
				}
				
				modelImg.doSave(img);
				
				request.setAttribute("page", "dashboard");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/dashboard.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("errorMessage", "Error: "+e.getMessage());
			request.setAttribute("page", "add_product");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/add_product.jsp");
			dispatcher.forward(request, response);
			return;
		}
	}
	
}

