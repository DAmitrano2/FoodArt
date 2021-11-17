package model.voce;

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


public class VoceDAOImp implements VoceDAO {
	
	public VoceDAOImp() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/food_art");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	@Override
	public void doSave(VoceBean voce) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + VoceDAOImp.TABLE_NAME
				+ " (idOrdine, idProdotto, quantita, prezzo)"
				+ " VALUES (?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, voce.getIdOrdine());
			preparedStatement.setInt(2, voce.getIdProdotto());
			preparedStatement.setFloat(3, voce.getQuantita());
			preparedStatement.setFloat(4, voce.getPrezzo());

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
	public Collection<VoceBean> doRetrieveByOrderKey(int idOrdine) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<VoceBean> composti = new LinkedList<VoceBean>();

		String selectSQL = "SELECT * FROM " + VoceDAOImp.TABLE_NAME + " WHERE idOrdine = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1,idOrdine);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				VoceBean bean = new VoceBean();
				bean.setIdOrdine( rs.getInt("idOrdine") );
				bean.setIdProdotto( rs.getInt("idProdotto") );
				bean.setQuantita( rs.getInt("quantita") );
				bean.setPrezzo( rs.getFloat("prezzo") );
				composti.add( bean );
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
		return composti;
	}

	private static final String TABLE_NAME = "voce";
	
	private DataSource ds;
}
