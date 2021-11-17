package model.categoria;

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

import model.immagine.ImmagineDAOImp;


public class CategoriaDAOImp implements CategoriaDAO {

	public CategoriaDAOImp() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/food_art");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
	@Override
	public void doSave(CategoriaBean category) throws SQLException {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + CategoriaDAOImp.TABLE_NAME +" (nome) "+
		"VALUES ( ? )";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, category.getNome());
			preparedStatement.setBytes(2, category.getPathName());
			
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
	public boolean doDelete(int idCategoria) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String deleteSQL = "DELETE FROM " + CategoriaDAOImp.TABLE_NAME +" where idCategoria = ? ";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, idCategoria);
			
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
		return false;
	}

	@Override
	public CategoriaBean doRetrieveByKey(int idCategoria) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		CategoriaBean categoria = new CategoriaBean();

		String selectSQL = "SELECT * FROM " + CategoriaDAOImp.TABLE_NAME +" where idCategoria = ? ";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idCategoria);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			boolean flag = false;
			
			while(rs.next()) {
				categoria.setNome(rs.getString("nome"));
				categoria.setPathName(rs.getBytes("pathName"));
				
				flag = true;
			}
			
			if( !flag ) {
				return null;
			}

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
		return categoria;
	}


	public Collection<CategoriaBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<CategoriaBean> all_categories = new LinkedList<CategoriaBean>();

		String selectSQL = "SELECT * FROM " + CategoriaDAOImp.TABLE_NAME;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			ResultSet rs = preparedStatement.executeQuery();
									
			while(rs.next()) {
				CategoriaBean categoria = new CategoriaBean();
				categoria.setIdCategoria(rs.getInt("idCategoria"));
				categoria.setNome(rs.getString("nome"));
				categoria.setPathName(rs.getBytes("pathname"));
				
				all_categories.add(categoria);
			}
			
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
		return all_categories;
	}

	@Override
	public void update(int idCategoria, String NewName) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE FROM " + CategoriaDAOImp.TABLE_NAME +" SET nome = ? where idCategoria = ?";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, NewName);
			preparedStatement.setInt(2,idCategoria);
			
			
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
	public byte[] doRetrieveByKeyCategoria(int idCategoria) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		byte[] path = null;

		String selectSQL = "SELECT * FROM " + CategoriaDAOImp.TABLE_NAME + " WHERE idCategoria = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idCategoria);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				path = rs.getBytes("pathname");
				continue;
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
		return path;
	}
	
	private static final String TABLE_NAME = "categoria";
	
	private DataSource ds;
}
