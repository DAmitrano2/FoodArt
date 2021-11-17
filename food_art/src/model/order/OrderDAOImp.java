package model.ordine;

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

import model.rivenditore.RivenditoreDAOImp;


public class OrdineDAOImp implements OrdineDAO {

	public OrdineDAOImp() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/food_art");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	@Override
	public void doSave(OrdineBean order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + OrdineDAOImp.TABLE_NAME
				+ " (dataOra, via, nCivico, citta, provincia, cap, nCarta, stato, descrizione, idUtente)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setDate(1, order.getDataOra());
			preparedStatement.setString(2, order.getVia());
			preparedStatement.setString(3, order.getNumeroCivico());
			preparedStatement.setString(4, order.getCitta());
			preparedStatement.setString(5, order.getProvincia());
			preparedStatement.setString(6, order.getCap());
			preparedStatement.setString(7, order.getNumeroCarta());
			preparedStatement.setString(8, order.getStato());
			preparedStatement.setString(9, order.getDescrizione());
			preparedStatement.setInt(10, order.getIdUtente());


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
	public OrdineBean doRetrieveSingleOrder(int idOrdine) throws SQLException {
			Connection connection = null;
			PreparedStatement preparedStatement = null;

			OrdineBean bean = new OrdineBean();

			String selectSQL = "SELECT * FROM " + OrdineDAOImp.TABLE_NAME + " WHERE idOrdine = ?";

			try {
				connection = ds.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setInt(1, idOrdine);

				ResultSet rs = preparedStatement.executeQuery();

				while (rs.next()) {
					bean.setIdOrdine(rs.getInt("idOrdine"));
					bean.setDataOra(rs.getDate("dataOra"));
					bean.setVia(rs.getString("via"));
					bean.setNumeroCivico(rs.getString("nCivico"));
					bean.setCitta(rs.getString("citta"));
					bean.setProvincia(rs.getString("provincia"));
					bean.setCap(rs.getString("cap"));
					bean.setNumeroCarta(rs.getString("nCarta"));
					bean.setStato(rs.getString("stato"));
					bean.setDescrizione(rs.getString("descrizione"));
					bean.setIdUtente(rs.getInt("idUtente"));
					
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
			return bean;
	}
	
	
	public int doRetrieveLastOrder(int idUtente) throws SQLException {
	
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		int idOrd = 0;
		
		String selectSQL = "SELECT * FROM " + OrdineDAOImp.TABLE_NAME + " WHERE idUtente = ? order by idOrdine desc limit 1";
		
		try {
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idUtente);
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				idOrd = rs.getInt("idOrdine");
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
		return idOrd;
	}

	@Override
	public Collection<OrdineBean> doRetrieveAll(int idUtente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdineBean> user_orders = new LinkedList<OrdineBean>();

		String selectSQL = "SELECT * FROM " + OrdineDAOImp.TABLE_NAME + " WHERE idUtente = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idUtente);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean = new OrdineBean();
				
				bean.setIdOrdine(rs.getInt("idOrdine"));
				bean.setDataOra(rs.getDate("dataOra"));
				bean.setVia(rs.getString("via"));
				bean.setNumeroCivico(rs.getString("nCivico"));
				bean.setCitta(rs.getString("citta"));
				bean.setProvincia(rs.getString("provincia"));
				bean.setCap(rs.getString("cap"));
				bean.setNumeroCarta(rs.getString("nCarta"));
				bean.setStato(rs.getString("stato"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setIdUtente(rs.getInt("idUtente"));
				
				user_orders.add(bean);
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
		return user_orders;
	}

	@Override
	public Collection<OrdineBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<OrdineBean> all_orders = new LinkedList<OrdineBean>();

		String selectSQL = "SELECT * FROM " + OrdineDAOImp.TABLE_NAME;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean = new OrdineBean();
				
				bean.setIdOrdine(rs.getInt("idOrdine"));
				bean.setDataOra(rs.getDate("dataOra"));
				bean.setVia(rs.getString("via"));
				bean.setNumeroCivico(rs.getString("nCivico"));
				bean.setCitta(rs.getString("citta"));
				bean.setProvincia(rs.getString("provincia"));
				bean.setCap(rs.getString("cap"));
				bean.setNumeroCarta(rs.getString("nCarta"));
				bean.setStato(rs.getString("stato"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setIdUtente(rs.getInt("idUtente"));
				
				all_orders.add(bean);
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
		return all_orders;

	}
	
	private static final String TABLE_NAME = "ordine";
	
	private DataSource ds;

}
