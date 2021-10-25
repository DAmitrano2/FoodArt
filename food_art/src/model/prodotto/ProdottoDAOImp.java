package model.prodotto;

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


public class ProdottoDAOImp implements ProdottoDAO {
	
	public ProdottoDAOImp() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/food_art");

		} catch (NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	@Override
	public void doSave(ProdottoBean product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + ProdottoDAOImp.TABLE_NAME
				           + "(titolo, descrizione, unitaMisura, prezzo, quantitaMinimaAcquisto, quantitaDisponibile, cittaProvenienza, provinciaProvenienza, idCategoria, idUtente)"
				           + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			preparedStatement.setInt(9, product.getIdCategoria());
			preparedStatement.setInt(10, product.getIdUtente());

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
		boolean deleted = false ;
		
		String updateSQL = "UPDATE "+ ProdottoDAOImp.TABLE_NAME +" SET quantita = -1 where idProdotto = ?";
		try {
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(updateSQL);
		preparedStatement.setInt(1, idProdotto);
		preparedStatement.executeUpdate();
		deleted = true;
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
		
		return deleted;
	}

	@Override
	public ProdottoBean doRetrieveByKey(int idProdotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ProdottoBean product = new ProdottoBean();
		
		String selectSQL = "SELECT * FROM "+ ProdottoDAOImp.TABLE_NAME +" where idProdotto = ?";
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
	public Collection<ProdottoBean> getProductByIdCategory(int idCategoria) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ProdottoBean> products = new LinkedList<ProdottoBean>();
		
		String selectSQL = "SELECT * FROM "+ ProdottoDAOImp.TABLE_NAME +" where idCategoria = ?";
		try {
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setInt(1, idCategoria);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			ProdottoBean singol_product = new ProdottoBean();
			singol_product.setIdProdotto(rs.getInt("idProdotto"));
			singol_product.setTitolo(rs.getString("titolo"));
			singol_product.setDescrizione(rs.getString("descrizione"));
			singol_product.setUnitaMisura(rs.getString("unitaMisura"));
			singol_product.setPrezzo(rs.getString("prezzo"));
			singol_product.setQuantitaMinima(rs.getInt("quantitaMinimaAcquisto"));
			singol_product.setQuantitaDisponibile(rs.getInt("quantitaDisponibile"));
			singol_product.setCittaProvenienza(rs.getString("cittaProvenienza"));
			singol_product.setProvinciaProvenienza(rs.getString("provinciaProvenienza"));
			singol_product.setIdCategoria(rs.getInt("idCategoria"));
			singol_product.setIdUtente(rs.getInt("idUtente"));
			
			
			products.add(singol_product);
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
	public Collection<ProdottoBean> getProductByIdCategory(int idCategoria, int numeroProdotti, int idProdotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ProdottoBean> products = new LinkedList<ProdottoBean>();
		
		String selectSQL = "SELECT * FROM "+ ProdottoDAOImp.TABLE_NAME +" where idCategoria = ? and idProdotto != "+idProdotto+" limit "+ numeroProdotti;
		try {
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);
		preparedStatement.setInt(1, idCategoria);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			ProdottoBean singol_product = new ProdottoBean();
			singol_product.setIdProdotto(rs.getInt("idProdotto"));
			singol_product.setTitolo(rs.getString("titolo"));
			singol_product.setDescrizione(rs.getString("descrizione"));
			singol_product.setUnitaMisura(rs.getString("unitaMisura"));
			singol_product.setPrezzo(rs.getString("prezzo"));
			singol_product.setQuantitaMinima(rs.getInt("quantitaMinimaAcquisto"));
			singol_product.setQuantitaDisponibile(rs.getInt("quantitaDisponibile"));
			singol_product.setCittaProvenienza(rs.getString("cittaProvenienza"));
			singol_product.setProvinciaProvenienza(rs.getString("provinciaProvenienza"));
			singol_product.setIdCategoria(rs.getInt("idCategoria"));
			singol_product.setIdUtente(rs.getInt("idUtente"));
			
			
			products.add(singol_product);
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
		
		String updateSQL = "UPDATE "+ ProdottoDAOImp.TABLE_NAME +" SET quantitaDisponibile = ? where idProdotto = ?";
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
	public void doUpdate(ProdottoBean product) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "UPDATE " + ProdottoDAOImp.TABLE_NAME
				+ " SET "
				+ "titolo=?, "
				+ "descrizione=?, "
				+ "unitaMisura=?, "
				+ "prezzo=?, "
				+ "quantitaMinimaAcquisto=?, "
				+ "quantitaDisponibile=?, "
				+ "cittaProvenienza=?, "
				+ "provinciaProvenienza=?, "
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
			preparedStatement.setInt(9, product.getIdCategoria());
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

	public Collection<ProdottoBean> getLastArrivals(int numeroProdotti) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ProdottoBean> products = new LinkedList<ProdottoBean>();
		
		String selectSQL = "SELECT * FROM "+ ProdottoDAOImp.TABLE_NAME +" order by idProdotto desc limit "+ numeroProdotti;
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
				ProdottoBean singol_product = new ProdottoBean();
				singol_product.setIdProdotto(rs.getInt("idProdotto"));
				singol_product.setTitolo(rs.getString("titolo"));
				singol_product.setDescrizione(rs.getString("descrizione"));
				singol_product.setUnitaMisura(rs.getString("unitaMisura"));
				singol_product.setPrezzo(rs.getString("prezzo"));
				singol_product.setQuantitaMinima(rs.getInt("quantitaMinimaAcquisto"));
				singol_product.setQuantitaDisponibile(rs.getInt("quantitaDisponibile"));
				singol_product.setCittaProvenienza(rs.getString("cittaProvenienza"));
				singol_product.setProvinciaProvenienza(rs.getString("provinciaProvenienza"));
				singol_product.setIdCategoria(rs.getInt("idCategoria"));
				singol_product.setIdUtente(rs.getInt("idUtente"));
				
				
				products.add(singol_product);
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
	
	public Collection<ProdottoBean> getProductByTitle(String title) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<ProdottoBean> products = new LinkedList<ProdottoBean>();
		
		String selectSQL = "SELECT * FROM "+ ProdottoDAOImp.TABLE_NAME +" where titolo like '%"+title+"%'";
		try {
		connection = ds.getConnection();
		preparedStatement = connection.prepareStatement(selectSQL);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		while (rs.next()) {
			ProdottoBean singol_product = new ProdottoBean();
			singol_product.setIdProdotto(rs.getInt("idProdotto"));
			singol_product.setTitolo(rs.getString("titolo"));
			singol_product.setDescrizione(rs.getString("descrizione"));
			singol_product.setUnitaMisura(rs.getString("unitaMisura"));
			singol_product.setPrezzo(rs.getString("prezzo"));
			singol_product.setQuantitaMinima(rs.getInt("quantitaMinimaAcquisto"));
			singol_product.setQuantitaDisponibile(rs.getInt("quantitaDisponibile"));
			singol_product.setCittaProvenienza(rs.getString("cittaProvenienza"));
			singol_product.setProvinciaProvenienza(rs.getString("provinciaProvenienza"));
			singol_product.setIdCategoria(rs.getInt("idCategoria"));
			singol_product.setIdUtente(rs.getInt("idUtente"));
			
			
			products.add(singol_product);
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
	
	private static final String TABLE_NAME = "prodotto";
	
	private DataSource ds;
}
