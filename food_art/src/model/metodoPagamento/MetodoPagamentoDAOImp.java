package model.metodoPagamento;

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

public class MetodoPagamentoDAOImp implements MetodoPagamentoDAO {
	
	public MetodoPagamentoDAOImp() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/food_art");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	@Override
	public boolean cartaEsistente(String nCarta) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT * FROM " + MetodoPagamentoDAOImp.TABLE_NAME+ " WHERE nCarta = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, nCarta);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				return true;				
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
		return false;
	}

	@Override
	public boolean pagamentoPossibile(String nCarta, float spesa) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String selectSQL = "SELECT saldo FROM " + MetodoPagamentoDAOImp.TABLE_NAME+ " WHERE nCarta = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, nCarta);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				float saldo = rs.getFloat("saldo");
				if( saldo>=spesa ) {
					return true;
				}				
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
		return false;
	}

	@Override
	public void effettuaPagamento(String nCarta, float spesa) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL = "UPDATE " + MetodoPagamentoDAOImp.TABLE_NAME+ " SET saldo=saldo-? WHERE nCarta=?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setFloat(1,spesa);
			preparedStatement.setString(2,nCarta);

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
	public Collection<MetodoPagamentoBean> getMetodoPagamentoByIdUser(int idUser) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<MetodoPagamentoBean> metodoPagamento = new LinkedList<MetodoPagamentoBean>();

		String selectSQL = "SELECT * FROM " + MetodoPagamentoDAOImp.TABLE_NAME+ " WHERE idUtente= ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idUser);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				MetodoPagamentoBean bean = new MetodoPagamentoBean();
				bean.setNumeroCarta(rs.getString("nCarta"));
				bean.setIntestatario(rs.getString("intestatario"));
				bean.setDataScadenza(rs.getDate("dataScadenza"));
				bean.setCvv(rs.getString("cvv"));
				metodoPagamento.add(bean);
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
		
		return metodoPagamento;
		
	}

	@Override
	public MetodoPagamentoBean getMetodoPagamentoByCard(String card) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		MetodoPagamentoBean bean = new MetodoPagamentoBean();

		String selectSQL = "SELECT * FROM " + MetodoPagamentoDAOImp.TABLE_NAME +" WHERE nCarta = ? ";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, card);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setNumeroCarta(rs.getString("nCarta"));
				bean.setIntestatario(rs.getString("intestatario"));
				bean.setDataScadenza(rs.getDate("dataScadenza"));
				bean.setCvv(rs.getString("cvv"));
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
	
	private static final String TABLE_NAME = "metodopagamento";
	private DataSource ds;
}
