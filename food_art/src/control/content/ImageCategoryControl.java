package control.content;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.category.CategoryDAOImp;

@WebServlet("/getCategoryImage")
public class ImageCategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImageCategoryControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
		try {
			byte[] bytes;
			CategoryDAOImp modelImmagine = new CategoryDAOImp();
			bytes = modelImmagine.doRetrieveByKeyCategoria(idCategoria);
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
