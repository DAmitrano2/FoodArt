package model.product;

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

public class ProductDAOImp implements ProductDAO {
	
	public ProductDAOImp() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/food_art");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
	
	@Override
	public void doSave(ProductBean product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + ProductDAOImp.TABLE_NAME
				           + "(titolo, descrizione, unitaMisura, prezzo, quantitaMinimaAcquisto, quantitaDisponibile, cittaProvenienza, provinciaProvenienza, valutazione, idCategoria, idUtente)"
				           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getTitolo());
			preparedStatement.setString(2, product.getDescrizione());
			preparedStatement.setString(3, product.getUnitaMisura());
			preparedStatement.setString(4, product.getPrezzo());
			preparedStatement.setInt(5, product.getQuantitaMinima());
			preparedStatement.setInt(6, product.getQuantitaDisponibile());
			preparedStatement.setString(7, product.getCittaProvenienza());
			preparedStatement.setString(8, product.getProvinciaProvenienza());
			preparedStatement.setFloat(9, product.getValutazione());
			preparedStatement.setInt(10, product.getIdCategoria());
			preparedStatement.setInt(11, product.getIdUtente());

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
	public boolean doDelete(int idProdotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "UPDATE "+ProductDAOImp.TABLE_NAME+" SET quantitaDisponibile = '0' WHERE idProdotto = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, idProdotto);

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
	public ProductBean doRetrieveByKey(int idProdotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ProductBean product = new ProductBean();
		
		String selectSQL = "SELECT * FROM "+ ProductDAOImp.TABLE_NAME +" where idProdotto = ? and quantitaDisponibile > 0";
		try {
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setInt(1, idProdotto);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		boolean flag=false;
		
		while (rs.next()) {
			product.setIdProdotto(rs.getInt("idProdotto"));
			product.setTitolo(rs.getString("titolo"));
			product.setDescrizione(rs.getString("descrizione"));
			product.setUnitaMisura(rs.getString("unitaMisura"));
			product.setPrezzo(rs.getString("prezzo"));
			product.setQuantitaMinima(rs.getInt("quantitaMinimaAcquisto"));
			product.setQuantitaDisponibile(rs.getInt("quantitaDisponibile"));
			product.setCittaProvenienza(rs.getString("cittaProvenienza"));
			product.setProvinciaProvenienza(rs.getString("provinciaProvenienza"));
			product.setvalutazione(rs.getFloat("valutazione"));
			product.setIdCategoria(rs.getInt("idCategoria"));
			product.setIdUtente(rs.getInt("idUtente"));
			
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
		return product;
	}

	@Override
	public Collection<ProductBean> getProductByIdCategory(int idCategoria) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ProductBean> products = new LinkedList<ProductBean>();
		
		String selectSQL = "SELECT * FROM "+ ProductDAOImp.TABLE_NAME +" where idCategoria = ? and quantitaDisponibile > 0";
		try {
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setInt(1, idCategoria);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			ProductBean product = new ProductBean();
			product.setIdProdotto(rs.getInt("idProdotto"));
			product.setTitolo(rs.getString("titolo"));
			product.setDescrizione(rs.getString("descrizione"));
			product.setUnitaMisura(rs.getString("unitaMisura"));
			product.setPrezzo(rs.getString("prezzo"));
			product.setQuantitaMinima(rs.getInt("quantitaMinimaAcquisto"));
			product.setQuantitaDisponibile(rs.getInt("quantitaDisponibile"));
			product.setCittaProvenienza(rs.getString("cittaProvenienza"));
			product.setProvinciaProvenienza(rs.getString("provinciaProvenienza"));
			product.setvalutazione(rs.getFloat("valutazione"));
			product.setIdCategoria(rs.getInt("idCategoria"));
			product.setIdUtente(rs.getInt("idUtente"));
			
			
			products.add(product);
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
		return products;
	}
	
	@Override
	public Collection<ProductBean> getProductByIdCategory(int idCategoria, int numeroProdotti, int idProdotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ProductBean> products = new LinkedList<ProductBean>();
		
		String selectSQL = "SELECT * FROM "+ ProductDAOImp.TABLE_NAME +" where idCategoria = ? and quantitaDisponibile > 0 and idProdotto != "+idProdotto+" limit "+ numeroProdotti;
		try {
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setInt(1, idCategoria);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			ProductBean product = new ProductBean();
			product.setIdProdotto(rs.getInt("idProdotto"));
			product.setTitolo(rs.getString("titolo"));
			product.setDescrizione(rs.getString("descrizione"));
			product.setUnitaMisura(rs.getString("unitaMisura"));
			product.setPrezzo(rs.getString("prezzo"));
			product.setQuantitaMinima(rs.getInt("quantitaMinimaAcquisto"));
			product.setQuantitaDisponibile(rs.getInt("quantitaDisponibile"));
			product.setCittaProvenienza(rs.getString("cittaProvenienza"));
			product.setProvinciaProvenienza(rs.getString("provinciaProvenienza"));
			product.setvalutazione(rs.getFloat("valutazione"));
			product.setIdCategoria(rs.getInt("idCategoria"));
			product.setIdUtente(rs.getInt("idUtente"));
			
			
			products.add(product);
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
		return products;
	}

	@Override
	public boolean updateQuantita(int idProdotto, int quantita) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean update = false ;
		
		String updateSQL = "UPDATE "+ ProductDAOImp.TABLE_NAME +" SET quantitaDisponibile = ? where idProdotto = ?";
		try {
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(updateSQL);
		preparedStatement.setInt(1, quantita);
		preparedStatement.setInt(2, idProdotto);
		preparedStatement.executeUpdate();
		update = true;
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
		
		return update;
		
	}

	@Override
	public void doUpdate(ProductBean product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE " + ProductDAOImp.TABLE_NAME
				+ " SET "
				+ "titolo=?, "
				+ "descrizione=?, "
				+ "unitaMisura=?, "
				+ "prezzo=?, "
				+ "quantitaMinimaAcquisto=?, "
				+ "quantitaDisponibile=?, "
				+ "cittaProvenienza=?, "
				+ "provinciaProvenienza=?, "
				+ "valutazione=?, "
				+ "idCategoria=?, "
				+ "WHERE idProdotto=?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getTitolo());
			preparedStatement.setString(2, product.getDescrizione());
			preparedStatement.setString(3, product.getUnitaMisura());
			preparedStatement.setString(4, product.getPrezzo());
			preparedStatement.setInt(5, product.getQuantitaMinima());
			preparedStatement.setInt(6, product.getQuantitaDisponibile());
			preparedStatement.setString(7, product.getCittaProvenienza());
			preparedStatement.setString(8, product.getProvinciaProvenienza());
			preparedStatement.setFloat(9, product.getValutazione());
			preparedStatement.setInt(10, product.getIdCategoria());
			preparedStatement.setInt(11, product.getIdUtente());
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

	public Collection<ProductBean> getLastArrivals(int numeroProdotti) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ProductBean> products = new LinkedList<ProductBean>();
		
		String selectSQL = "SELECT * FROM "+ ProductDAOImp.TABLE_NAME +" where quantitaDisponibile > 0 order by idProdotto desc limit "+ numeroProdotti;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				ProductBean product = new ProductBean();
				product.setIdProdotto(rs.getInt("idProdotto"));
				product.setTitolo(rs.getString("titolo"));
				product.setDescrizione(rs.getString("descrizione"));
				product.setUnitaMisura(rs.getString("unitaMisura"));
				product.setPrezzo(rs.getString("prezzo"));
				product.setQuantitaMinima(rs.getInt("quantitaMinimaAcquisto"));
				product.setQuantitaDisponibile(rs.getInt("quantitaDisponibile"));
				product.setCittaProvenienza(rs.getString("cittaProvenienza"));
				product.setProvinciaProvenienza(rs.getString("provinciaProvenienza"));
				product.setvalutazione(rs.getFloat("valutazione"));
				product.setIdCategoria(rs.getInt("idCategoria"));
				product.setIdUtente(rs.getInt("idUtente"));
				
				
				products.add(product);
			}
			connection.commit();
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
		return products;
	}
	
	public Collection<ProductBean> getProductByTitle(String title) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ProductBean> products = new LinkedList<ProductBean>();
		
		String selectSQL = "SELECT * FROM "+ ProductDAOImp.TABLE_NAME +" where quantitaDisponibile > 0 and titolo like '%"+title+"%'";
		try {
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			ProductBean product = new ProductBean();
			product.setIdProdotto(rs.getInt("idProdotto"));
			product.setTitolo(rs.getString("titolo"));
			product.setDescrizione(rs.getString("descrizione"));
			product.setUnitaMisura(rs.getString("unitaMisura"));
			product.setPrezzo(rs.getString("prezzo"));
			product.setQuantitaMinima(rs.getInt("quantitaMinimaAcquisto"));
			product.setQuantitaDisponibile(rs.getInt("quantitaDisponibile"));
			product.setCittaProvenienza(rs.getString("cittaProvenienza"));
			product.setProvinciaProvenienza(rs.getString("provinciaProvenienza"));
			product.setvalutazione(rs.getFloat("valutazione"));
			product.setIdCategoria(rs.getInt("idCategoria"));
			product.setIdUtente(rs.getInt("idUtente"));
			
			
			products.add(product);
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
		return products;
	}

	@Override
	public boolean updateRating(int idProdotto, float valutazione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean flush = false ;
		
		String updateSQL = "UPDATE "+ ProductDAOImp.TABLE_NAME +" SET valutazione = "+valutazione+" where idProdotto = ?";

		try {
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(updateSQL);
		preparedStatement.setInt(1, idProdotto);
		preparedStatement.executeUpdate();
		flush = true;
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
		
		return flush;
	}
	
	@Override
	public Collection<ProductBean> getProductByIdUser(int idUser) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ProductBean> products = new LinkedList<ProductBean>();
		
		String selectSQL = "SELECT * FROM "+ ProductDAOImp.TABLE_NAME +" where idUtente = ? and quantitaDisponibile > 0";
		try {
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setInt(1, idUser);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			ProductBean product = new ProductBean();
			product.setIdProdotto(rs.getInt("idProdotto"));
			product.setTitolo(rs.getString("titolo"));
			product.setDescrizione(rs.getString("descrizione"));
			product.setUnitaMisura(rs.getString("unitaMisura"));
			product.setPrezzo(rs.getString("prezzo"));
			product.setQuantitaMinima(rs.getInt("quantitaMinimaAcquisto"));
			product.setQuantitaDisponibile(rs.getInt("quantitaDisponibile"));
			product.setCittaProvenienza(rs.getString("cittaProvenienza"));
			product.setProvinciaProvenienza(rs.getString("provinciaProvenienza"));
			product.setvalutazione(rs.getFloat("valutazione"));
			product.setIdCategoria(rs.getInt("idCategoria"));
			product.setIdUtente(rs.getInt("idUtente"));
			
			products.add(product);
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
		return products;
	}
	
	@Override
	public int getNumProductByIdUser(int idUser) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int numProduct = 0;
		
		String selectSQL = "SELECT COUNT('idProdotto') FROM "+ ProductDAOImp.TABLE_NAME +" where idUtente = ?";;

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idUser);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				numProduct = rs.getInt(1);
			}
		}catch(SQLException e) {
			return 0;
		}finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return numProduct;
	}
	
	@Override
	public Collection<ProductBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<ProductBean> products = new LinkedList<ProductBean>();

		String selectSQL = "SELECT * FROM " + ProductDAOImp.TABLE_NAME +" where quantitaDisponibile > 0";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProductBean product = new ProductBean();
				product.setIdProdotto(rs.getInt("idProdotto"));
				product.setTitolo(rs.getString("titolo"));
				product.setDescrizione(rs.getString("descrizione"));
				product.setUnitaMisura(rs.getString("unitaMisura"));
				product.setPrezzo(rs.getString("prezzo"));
				product.setQuantitaMinima(rs.getInt("quantitaMinimaAcquisto"));
				product.setQuantitaDisponibile(rs.getInt("quantitaDisponibile"));
				product.setCittaProvenienza(rs.getString("cittaProvenienza"));
				product.setProvinciaProvenienza(rs.getString("provinciaProvenienza"));
				product.setvalutazione(rs.getFloat("valutazione"));
				product.setIdCategoria(rs.getInt("idCategoria"));
				product.setIdUtente(rs.getInt("idUtente"));
				
				products.add(product);
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
		return products;
	}
	
	private static final String TABLE_NAME = "prodotto";
	
	private DataSource ds;

}
