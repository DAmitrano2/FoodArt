package control.register;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.rivenditore.RivenditoreBean;
import model.rivenditore.RivenditoreDAOImp;
import model.utente.UtenteBean;
import model.utente.UtenteDAOImp;

@WebServlet("/register")
@MultipartConfig(maxFileSize = 50000000)
public class RegisterControl extends HttpServlet {


	private static final long serialVersionUID = 1L;
	private UtenteDAOImp modelUser;
	private RivenditoreDAOImp modelSeller;

    public RegisterControl() {
        super();
        this.modelUser = new UtenteDAOImp();
        this.modelSeller = new RivenditoreDAOImp();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("page","register");
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=0;
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String nome = request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String rivenditore = request.getParameter("rivenditore");
		
		UtenteBean user = new UtenteBean();
		
		//Codifica della password
		Base64.Encoder enc = Base64.getEncoder();
		String encodedPass = enc.encodeToString(password.getBytes());
		
		user.setEmail(email);
		user.setPassword(encodedPass);
		user.setNome(nome);
		user.setCognome(cognome);
		
		RivenditoreBean seller = new RivenditoreBean();
			
		if( rivenditore.equalsIgnoreCase("rivenditore-check") ) {
					
			user.setRivenditore(true);
			
			String data = request.getParameter("data");
			String sesso = request.getParameter("sesso");
			String citta = request.getParameter("citta");
			String provincia = request.getParameter("provincia");
			String codiceFiscale = request.getParameter("codiceFiscale");
			String ragioneSociale = request.getParameter("ragioneSociale");
			String provinciaSedeLegale = request.getParameter("provinciaSedeLegale");
			String cittaSedeLegale = request.getParameter("cittaSedeLegale");
			String viaSedeLegale = request.getParameter("viaSedeLegale");
			String capSedeLegale = request.getParameter("capSedeLegale");
			String nCivicoSedeLegale = request.getParameter("nCivicoSedeLegale");
			String nPartitaIVA = request.getParameter("nPartitaIVA");
			
//			String contentType = request.getContentType();
//		    
//		    if ((contentType != null) && (contentType.indexOf("multipart/form-data") >= 0)) {
//		        DataInputStream in = new DataInputStream(request.getInputStream());
//		        
//		        int formDataLength = request.getContentLength();
//		        byte dataBytes[] = new byte[formDataLength];
//		        int byteRead = 0;
//		        int totalBytesRead = 0;
//		        
//		        while (totalBytesRead < formDataLength) {
//		            byteRead = in.read(dataBytes, totalBytesRead, formDataLength);
//		            totalBytesRead += byteRead;
//		        }
//
//		        String file = new String(dataBytes);
//		        //for saving the file name
//		        String saveFile = file.substring(file.indexOf("filename=\"") + 10);
//		        saveFile = saveFile.substring(0, saveFile.indexOf("\n"));
//		        saveFile = saveFile.substring(saveFile.lastIndexOf("\\") + 1, saveFile.indexOf("\""));
//		        int lastIndex = contentType.lastIndexOf("=");
//		        String boundary = contentType.substring(lastIndex + 1, contentType.length());
//		        int pos;
//		        //extracting the index of file 
//		        pos = file.indexOf("filename=\"");
//		        pos = file.indexOf("\n", pos) + 1;
//		        pos = file.indexOf("\n", pos) + 1;
//		        pos = file.indexOf("\n", pos) + 1;
//		        int boundaryLocation = file.indexOf(boundary, pos) - 4;
//		        int startPos = ((file.substring(0, pos)).getBytes()).length;
//		        int endPos = ((file.substring(0, boundaryLocation)).getBytes()).length;
//		        // creating a new file with the same name and writing the content in new file
//                FileOutputStream fileOut = new FileOutputStream(saveFile);
//                fileOut.write(dataBytes, startPos, (endPos - startPos));
//                fileOut.flush();
//                fileOut.close();

			//InputStream fPartitaIVA = new FileInputStream(request.getRealPath("fPartitaIVA"));
			//File fCartaIdentita = new File(request.getRealPath("fCartaIdentita"));
			
			
			Date date=new Date(0);
			date=Date.valueOf(data);
			
			seller.setDataNascita(date);
			seller.setSesso(sesso);
			seller.setCitta(citta);
			seller.setProvincia(provincia);
			seller.setCodiceFiscale(codiceFiscale);
			seller.setRagioneSociale(ragioneSociale);
			seller.setProvinciaSedeLegale(provinciaSedeLegale);
			seller.setCittaSedeLegale(cittaSedeLegale);
			seller.setViaSedeLegale(viaSedeLegale);
			seller.setCapSedeLegale(capSedeLegale);
			seller.setNumeroCivicoSedeLegale(nCivicoSedeLegale);
			seller.setNumeroPartitaIva(nPartitaIVA);
			
			byte[] bytes = null;
			
		    Part filePart = request.getPart("fPartitaIVA");
		    //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
		    //InputStream fileContent = filePart.getInputStream();
		    
			
//			File fPartitaIVA = new File(request.getRealPath(request.getParameter("fPartitaIVA")));
//			bytes = Files.readAllBytes(fPartitaIVA.toPath());
		    bytes = filePart.getInputStream().readAllBytes();
			seller.setFilePartitaIva(bytes);
			
			bytes = null;
//			bytes = Files.readAllBytes(fCartaIdentita.toPath());
			filePart = request.getPart("fCartaIdentita");
			bytes = filePart.getInputStream().readAllBytes();
			seller.setFileDocumentoIdentita(bytes);
		}

		try {
			if(user!=null) {
				id=modelUser.doSave(user);
				request.getSession(true);
				request.getSession().setAttribute("user",user);
				response.setStatus(200);
			}
			if(seller!=null) {
				seller.setIdUtente(id);
				modelSeller.doSave(seller);
				request.getSession(true);
				request.getSession().setAttribute("seller",seller);
				response.setStatus(200);
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			System.out.println("Error: "+e.getMessage());
			return;
		}
	}

}
