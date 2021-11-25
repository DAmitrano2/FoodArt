package control.content;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.user.UserDAOImp;

@WebServlet("/getUserImage")
public class ImageUserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageUserControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUtente = Integer.parseInt(request.getParameter("idUtente"));
		try {
			byte[] bytes;
			UserDAOImp modelImmagine = new UserDAOImp();
			bytes = modelImmagine.doRetrieveImageByKey(idUtente);
			ServletOutputStream out = response.getOutputStream();
			if(bytes != null)
			{
				out.write(bytes);
				response.setContentType("image");
			}
			out.close();
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
