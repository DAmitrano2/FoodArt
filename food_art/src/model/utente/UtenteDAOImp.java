package model.utente;

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



public class UtenteDAOImp implements UtenteDAO {
	
	public UtenteDAOImp() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/food_art");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
	@Override
	public int doSave(UtenteBean user) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + UtenteDAOImp.TABLE_NAME
				+ " (nome, cognome, email, password,amministratore, rivenditore, bloccato)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getNome());
			preparedStatement.setString(2, user.getCognome());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setBoolean(5, user.isAmministratore());
			preparedStatement.setBoolean(6, user.isRivenditore());
			preparedStatement.setBoolean(7, user.isBloccato());

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
		if(user.isRivenditore()) {
		connection = null;
		preparedStatement = null;

		int id=0;

		String selectSQL = "SELECT * FROM " + UtenteDAOImp.TABLE_NAME + " WHERE email = ? ";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1,user.getEmail());

			ResultSet rs = preparedStatement.executeQuery();

			boolean flag=false;
			
			while (rs.next()) {
				id=rs.getInt("idUtente");
				
				flag=true;
			}
			
			if( !flag ) {
				return -1;
			}
			
		}
		catch(SQLException e) {
			System.out.println(e);
			return -1;
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
		return id;
		}
	return -1;
	}

	@Override
	public UtenteBean doRetrieveByKey(String email, String password) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		UtenteBean bean = new UtenteBean();

		String selectSQL = "SELECT * FROM " + UtenteDAOImp.TABLE_NAME + " WHERE email = ? AND password = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,password);

			ResultSet rs = preparedStatement.executeQuery();

			boolean flag=false;
			
			while (rs.next()) {
				bean.setIdUtente(rs.getInt("idUtente"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setAmministratore(rs.getBoolean("amministratore"));
				bean.setRivenditore(rs.getBoolean("rivenditore"));
				bean.setBloccato(rs.getBoolean("bloccato"));
				
				flag=true;
			}
			
			if( !flag ) {
				return null;
			}
			
		}
		catch(SQLException e) {
			System.out.println(e);
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
	public Collection<UtenteBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<UtenteBean> users = new LinkedList<UtenteBean>();

		String selectSQL = "SELECT * FROM " + UtenteDAOImp.TABLE_NAME;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				UtenteBean bean = new UtenteBean();
				bean.setIdUtente(rs.getInt("idUtente"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setAmministratore(rs.getBoolean("amministratore"));
				bean.setRivenditore(rs.getBoolean("rivenditore"));
				users.add(bean);
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
		return users;
	}
	
	@Override
	public UtenteBean doRetrieveById(int idUtente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		UtenteBean bean = new UtenteBean();

		String selectSQL = "SELECT * FROM " + UtenteDAOImp.TABLE_NAME + " WHERE idUtente = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idUtente);

			ResultSet rs = preparedStatement.executeQuery();

			boolean flag=false;
			
			while (rs.next()) {
				bean.setIdUtente(rs.getInt("idUtente"));
				bean.setNome(rs.getString("nome"));
				bean.setCognome(rs.getString("cognome"));
				bean.setEmail(rs.getString("email"));
				bean.setPassword(rs.getString("password"));
				bean.setAmministratore(rs.getBoolean("amministratore"));
				bean.setRivenditore(rs.getBoolean("rivenditore"));
				bean.setBloccato(rs.getBoolean("bloccato"));
				
				flag=true;
			}
			
			if( !flag ) {
				return null;
			}
			
		}
		catch(SQLException e) {
			System.out.println(e);
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
	public boolean isEmail(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT email FROM " + UtenteDAOImp.TABLE_NAME + " WHERE email = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1,email);

			ResultSet rs = preparedStatement.executeQuery();

			boolean existEmail = false;
			while(rs.next()) { 
				existEmail = true;
			}
			
			return existEmail;
			
		}
		catch(SQLException e) {
			return false;
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
	}
	
	@Override
	public void banned(int idUtente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE "+TABLE_NAME +" SET bloccato=1 WHERE idUtente=?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setInt(1, idUtente);
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
	public boolean isAmministratore(int idUtente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT * FROM " + UtenteDAOImp.TABLE_NAME + " WHERE idUtente = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idUtente);

			ResultSet rs = preparedStatement.executeQuery();

			boolean isAmministratore = false;
			while(rs.next()) { 
				isAmministratore = true;
			}
			
			return isAmministratore;
			
		}
		catch(SQLException e) {
			return false;
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
	}

	@Override
	public boolean isRivenditore(int idUtente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String selectSQL = "SELECT * FROM " + UtenteDAOImp.TABLE_NAME + " WHERE idUtente = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idUtente);

			ResultSet rs = preparedStatement.executeQuery();

			boolean isRivenditore = false;
			while(rs.next()) { 
				isRivenditore = true;
			}
			
			return isRivenditore;
			
		}
		catch(SQLException e) {
			return false;
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
	}
	
	private static final String TABLE_NAME = "utente";
	
	private DataSource ds;

}
