package model.image;

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


public class ImageDAOImp implements ImageDAO {
	
	public ImageDAOImp() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/food_art");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	@Override
	public void doSave(ImageBean image) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ImageDAOImp.TABLE_NAME
				+ " (pathname, idProdotto)"
				+ " VALUES (?, ?)";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setBytes(1, image.getPathName());
			preparedStatement.setInt(2, image.getIdProdotto());

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
	public boolean doDelete(int id) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ImageDAOImp.TABLE_NAME + " WHERE idImmagine = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1,id);

			result = preparedStatement.executeUpdate();

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
	public ImageBean doRetrieveByKey(int idImmagine) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ImageBean bean = new ImageBean();

		String selectSQL = "SELECT * FROM " + ImageDAOImp.TABLE_NAME + " WHERE idImmagine = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idImmagine);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setIdImmagine(rs.getInt("idImmagine"));
				bean.setPathName(rs.getBytes("pathName"));
				bean.setIdProdotto(rs.getInt("idProdotto"));
				
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

	@Override
	public ImageBean getImagesByProdotto(int idProdotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ImageBean bean = new ImageBean();

		String selectSQL = "SELECT * FROM "+ ImageDAOImp.TABLE_NAME +" WHERE idProdotto = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1,idProdotto);

			ResultSet rs = preparedStatement.executeQuery();

			boolean flag = false;
			
			while (rs.next()) {
				bean.setIdImmagine(rs.getInt("idImmagine"));
				bean.setPathName(rs.getBytes("pathname"));
				bean.setIdProdotto(rs.getInt("idProdotto"));

				flag=true;
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
		return bean;
	}
	
	private static final String TABLE_NAME = "immagine";
	
	private DataSource ds;

	@Override
	public byte[] doRetrieveByKeyProdotto(int idProdotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		byte[] path = null;

		String selectSQL = "SELECT * FROM " + ImageDAOImp.TABLE_NAME + " WHERE idProdotto = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idProdotto);

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


}
