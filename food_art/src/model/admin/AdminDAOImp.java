package model.amministratore;

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


public class AmministratoreDAOImp implements AmministratoreDAO {
	
	public AmministratoreDAOImp() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/food_art");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	@Override
	public void doSave(AmministratoreBean admin) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + AmministratoreDAOImp.TABLE_NAME
				+ " (idUtente, ruolo)"
				+ " VALUES (?, ?)";
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(insertSQL);
		
		try {
		preparedStatement.setInt(1, admin.getIdUtente());
		preparedStatement.setString(2, admin.getRuolo());
		
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
	public AmministratoreBean doRetriveById(int idUtente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		AmministratoreBean bean = new AmministratoreBean();

		String selectSQL = "SELECT * FROM" + AmministratoreDAOImp.TABLE_NAME +"where idUtente = ? ";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idUtente);
			ResultSet rs = preparedStatement.executeQuery();

			boolean flag=false;
		
		while (rs.next()) {
			bean.setIdUtente(rs.getInt("idUtente"));
			bean.setRuolo(rs.getString("ruolo"));
			
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
	return bean;
	}

	@Override
	public Collection<AmministratoreBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<AmministratoreBean> admins = new LinkedList<AmministratoreBean>();

		String selectSQL = "SELECT * FROM " + AmministratoreDAOImp.TABLE_NAME;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				AmministratoreBean bean = new AmministratoreBean();
				bean.setIdUtente(rs.getInt("idUtente"));
				bean.setRuolo(rs.getString("ruolo"));
				admins.add(bean);
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
		return admins;
	}

    private static final String TABLE_NAME = "amministratore";
	
	private DataSource ds;
}
