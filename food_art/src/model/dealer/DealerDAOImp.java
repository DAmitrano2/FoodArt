package model.dealer;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DealerDAOImp implements DealerDAO {

	public DealerDAOImp() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/food_art");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	@Override
	public void doSave(DealerBean dealer) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + DealerDAOImp.TABLE_NAME
				+ " (idUtente, dataNascita, citta, provincia, sesso, codiceFiscale, numeroPartitaIva, filePartitaIva, fileDocumentoIdentita,"
				+ " ragioneSociale, provinciaSedeLegale, cittaSedeLegale, viaSedeLegale, nCivicoSedeLegale, capSedeLegale) "
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(insertSQL);
		
		try {
		preparedStatement.setInt(1, dealer.getIdUtente());
		preparedStatement.setDate(2, dealer.getDataNascita());
		preparedStatement.setString(3, dealer.getCitta());
		preparedStatement.setString(4, dealer.getProvincia());
		preparedStatement.setString(5, dealer.getSesso());
		preparedStatement.setString(6, dealer.getCodiceFiscale());
		preparedStatement.setString(7, dealer.getNumeroPartitaIva());
		preparedStatement.setBytes(8, dealer.getFilePartitaIva());
		preparedStatement.setBytes(9, dealer.getFileDocumentoIdentita());
		preparedStatement.setString(10, dealer.getRagioneSociale());
		preparedStatement.setString(11, dealer.getProvinciaSedeLegale());
		preparedStatement.setString(12, dealer.getCittaSedeLegale());
		preparedStatement.setString(13, dealer.getViaSedeLegale());
		preparedStatement.setString(14, dealer.getNumeroCivicoSedeLegale());
		preparedStatement.setString(15, dealer.getCapSedeLegale());
		
		preparedStatement.executeUpdate();

		connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		
	}

	@Override
	public DealerBean doRetriveById(int idUtente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		DealerBean bean = new DealerBean();

		String selectSQL = "SELECT * FROM "+ DealerDAOImp.TABLE_NAME +" where idUtente = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idUtente);
			ResultSet rs = preparedStatement.executeQuery();
			
			boolean flag=false;
			while (rs.next()) {
				bean.setIdUtente(rs.getInt("idUtente"));
				bean.setDataNascita(rs.getDate("dataNascita"));
				bean.setCitta(rs.getString("citta"));
				bean.setProvincia(rs.getString("provincia"));
				bean.setSesso(rs.getString("sesso"));
				bean.setCodiceFiscale(rs.getString("codiceFiscale"));
				bean.setNumeroPartitaIva(rs.getString("numeropartitaIva"));
				bean.setFilePartitaIva(rs.getBytes("filePartitaIva"));
				bean.setFileDocumentoIdentita(rs.getBytes("fileDocumentoIdentita"));
				bean.setRagioneSociale(rs.getString("ragioneSociale"));
				bean.setProvinciaSedeLegale(rs.getString("provinciaSedeLegale"));
				bean.setCittaSedeLegale(rs.getString("cittaSedeLegale"));
				bean.setViaSedeLegale(rs.getString("viaSedeLegale"));
				bean.setNumeroCivicoSedeLegale(rs.getString("nCivicoSedeLegale"));
				bean.setCapSedeLegale(rs.getString("CapSedeLegale"));
				flag=true;
			}
			
		if( !flag ) {
			return null;
		}
		
	}catch(SQLException e) {
		return null;
	}finally {
		try {
			if (preparedStatement != null)
				preparedStatement.close();
		}finally {
			if (connection != null)
				connection.close();
		}
	}
	return bean;
}

	@Override
	public Collection<DealerBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<DealerBean> dealers = new LinkedList<DealerBean>();

		String selectSQL = "SELECT * FROM " + DealerDAOImp.TABLE_NAME;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				DealerBean bean = new DealerBean();
				int idUtente = rs.getInt("idUtente");
				bean.setIdUtente(idUtente);
			    bean.setDataNascita(rs.getDate("dataNascita"));
			    bean.setCitta(rs.getString("citta"));
			    bean.setProvincia(rs.getString("provincia"));
				bean.setSesso(rs.getString("sesso"));
				bean.setCodiceFiscale(rs.getString("codiceFiscale"));
				bean.setNumeroPartitaIva(rs.getString("numeropartitaIva"));
				bean.setFilePartitaIva(rs.getBytes("filePartitaIva"));
				bean.setFileDocumentoIdentita(rs.getBytes("fileDocumentoIdentita"));
				bean.setRagioneSociale(rs.getString("ragioneSociale"));
				bean.setProvinciaSedeLegale(rs.getString("provinciaSedeLegale"));
				bean.setCittaSedeLegale(rs.getString("cittaSedeLegale"));
				bean.setViaSedeLegale(rs.getString("viaSedeLegale"));
				bean.setNumeroCivicoSedeLegale(rs.getString("nCivicoSedeLegale"));
				bean.setCapSedeLegale(rs.getString("CapSedeLegale"));
				dealers.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return dealers;
	}

	@Override
	public String doRetriveNameById(int idUtente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String nome = "";

		String selectSQL = "SELECT ragioneSociale FROM "+ DealerDAOImp.TABLE_NAME +" where idUtente = ? ";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idUtente);
			ResultSet rs = preparedStatement.executeQuery();

			boolean flag = false;
		
			while (rs.next()) {
				nome = rs.getString("ragioneSociale");

				flag=true;
			}
			
			if( !flag ) {
				return null;
			}
			
		}
		catch(SQLException e) {
			return null;
		}
		finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return nome;
	}
	private static final String TABLE_NAME = "rivenditore";

	private DataSource ds;
}
