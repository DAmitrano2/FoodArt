package control.image;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.categoria.CategoriaDAOImp;

@WebServlet("/getCategoryImage")
public class ImmagineCategoryControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ImmagineCategoryControl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCategoria = Integer.parseInt(request.getParameter("idCategoria"));
		try {
			byte[] bytes;
			CategoriaDAOImp modelImmagine = new CategoriaDAOImp();
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
