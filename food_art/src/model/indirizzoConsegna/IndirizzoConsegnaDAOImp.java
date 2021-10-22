package model.indirizzoConsegna;

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

public class IndirizzoConsegnaDAOImp implements IndirizzoConsegnaDAO {

	public IndirizzoConsegnaDAOImp() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/food_art");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	@Override
	public synchronized void doSave(IndirizzoConsegnaBean indirizzo) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + IndirizzoConsegnaDAOImp.TABLE_NAME
				+ " (nome, cognome, nTelefono, via, nCivico, citta, provincia, cap, descrizione, idUtente)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, indirizzo.getNome());
			preparedStatement.setString(2, indirizzo.getCognome());
			preparedStatement.setString(3, indirizzo.getNumeroTelefono());
			preparedStatement.setString(4, indirizzo.getVia());
			preparedStatement.setString(5, indirizzo.getNumeroCivico());
			preparedStatement.setString(6, indirizzo.getCitta());
			preparedStatement.setString(7, indirizzo.getProvincia());
			preparedStatement.setString(8, indirizzo.getCap());
			preparedStatement.setString(9, indirizzo.getDescrizione());
			preparedStatement.setInt(10, indirizzo.getIdUtente());

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
	
	public Collection<IndirizzoConsegnaBean> getIndirizzoByIdUser(int idUser) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<IndirizzoConsegnaBean> indirizzo = new LinkedList<IndirizzoConsegnaBean>();

		String selectSQL = "SELECT * FROM " + IndirizzoConsegnaDAOImp.TABLE_NAME+ " WHERE idUtente= ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idUser);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				IndirizzoConsegnaBean bean = new IndirizzoConsegnaBean();
				bean.setIdIndirizzoConsegna(rs.getInt("idIndirizzoConsegna"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setNumeroTelefono(rs.getString("nTelefono"));
				bean.setVia(rs.getString("via"));
				bean.setNumeroCivico(rs.getString("nCivico"));
				bean.setCitta(rs.getString("citta"));
				bean.setProvincia(rs.getString("provincia"));
				bean.setCap(rs.getString("cap"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setIdUtente(rs.getInt("idUtente"));
				indirizzo.add(bean);
			}

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
		
		return indirizzo;
		
	}
	
	@Override
	public synchronized boolean doDelete(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + IndirizzoConsegnaDAOImp.TABLE_NAME + " WHERE idIndirizzoConsegna = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, code);

			result = preparedStatement.executeUpdate();
			
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
		return (result != 0);
	}

	@Override
	public IndirizzoConsegnaBean doRetriveByKey(int code) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		IndirizzoConsegnaBean bean = new IndirizzoConsegnaBean();

		String selectSQL = "SELECT * FROM " + IndirizzoConsegnaDAOImp.TABLE_NAME +" WHERE idIndirizzoConsegna=? ";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, code);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setIdIndirizzoConsegna(rs.getInt("idIndirizzoConsegna"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setNumeroTelefono(rs.getString("nTelefono"));
				bean.setVia(rs.getString("via"));
				bean.setNumeroCivico(rs.getString("nCivico"));
				bean.setCitta(rs.getString("citta"));
				bean.setProvincia(rs.getString("provincia"));
				bean.setCap(rs.getString("cap"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setIdUtente(rs.getInt("idUtente"));
			}

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
		
		return bean;
	}
	
	private static final String TABLE_NAME = "indirizzoconsegna";
	
	private DataSource ds;
	
}
