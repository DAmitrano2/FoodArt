package control.feedback;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.feedback.FeedbackBean;
import model.feedback.FeedbackDAOImp;
import model.user.UserBean;

@WebServlet("/feedback")
public class FeedbackControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private FeedbackDAOImp modelFeedback;
	
    public FeedbackControl() {
        super();
        this.modelFeedback = new FeedbackDAOImp();
    }

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean user = (UserBean) request.getSession().getAttribute("user");
		
		float rating = Float.parseFloat(request.getParameter("rating"));
		String titolo = request.getParameter("title");
		String commento = request.getParameter("comment");
		int idProdotto = Integer.parseInt(request.getParameter("idProd"));
		int idRivenditore = Integer.parseInt(request.getParameter("idUser"));
		
		try {
			FeedbackBean fb = new FeedbackBean();
			
			fb.setTitolo(titolo);
			fb.setCommento(commento);
			fb.setValutazione(rating);
			fb.setIdCommentatore(user.getIdUtente());
			fb.setIdProdotto(idProdotto);
			
			if(fb == null ) {
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.setStatus(401);
				
				request.setAttribute("errorMessage", "Dati non corretti");
				
				request.setAttribute("page", "index");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
			if(fb != null) {
				modelFeedback.doSave(fb);
				response.setStatus(200);
				
				request.setAttribute("page","index");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			request.setAttribute("errorMessage", "Dati non corretti");
			request.setAttribute("page", "index");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
			System.out.println("Error: "+e.getMessage());
			return;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
