package control.feedback;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.feedback.FeedbackDAOImp;

@WebServlet("/getFeedback")
public class FeedbackControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public FeedbackControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idProdotto=Integer.parseInt(request.getParameter("idProdotto"));
		FeedbackDAOImp fbImp = new FeedbackDAOImp();
		try {
			request.setAttribute("collectionFb", fbImp.doRetriveByProduct(idProdotto));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
