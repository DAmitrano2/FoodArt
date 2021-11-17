package control.content;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.image.ImageDAOImp;

@WebServlet("/getProductImage")
public class ImageProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageProductControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idProdotto = Integer.parseInt(request.getParameter("idProdotto"));
		try {
			byte[] bytes;
			ImageDAOImp modelImmagine = new ImageDAOImp();
			bytes = modelImmagine.doRetrieveByKeyProdotto(idProdotto);
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
