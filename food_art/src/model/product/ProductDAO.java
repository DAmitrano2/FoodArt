package model.product;

import java.sql.SQLException;
import java.util.Collection;



public interface ProductDAO {
	
	/**
	 * Salvataggio dei dati di un prodotto
	 * @param product
	 * @return
	 * @throws SQLException
	 */
	public void doSave(ProductBean product) throws SQLException;

	/**
	 * Rende invendibile un prodotto
	 * @param idProdotto
	 * @return
	 * @throws SQLException
	 */
	public boolean doDelete(int idProdotto) throws SQLException;

	/**
	 * Carica i dati di un prodotto in base al suo identificativo
	 * @param idProdotto
	 * @return un ProdottoBean
	 * @throws SQLException
	 */
	public ProductBean doRetrieveByKey(int idProdotto) throws SQLException;
	
	/**
	 * Ricerca dei prodotti in base all'id di categoria
	 * @param filter
	 * @return collezione di ProdottoBean
	 * @throws SQLException
	 */
	public Collection<ProductBean> getProductByIdCategory(int idCategoria) throws SQLException;
	
	/**
	 * Ricerca dei prodotti in base all'id di categoria e al numero massimo di prodotti da visualizzare tranne un prodotto
	 * @param filter e numero massimo
	 * @return collezione di ProdottoBean
	 * @throws SQLException
	 */
	public Collection<ProductBean> getProductByIdCategory(int idCategoria, int numeroProdotti, int idProdotto) throws SQLException;
	
	/**
	 * Ritorna i prodotti in ordine decrescente di id
	 * @param numero massimo
	 * @return collezione di ProdottoBean
	 * @throws SQLException
	 */
	public Collection<ProductBean> getLastArrivals(int numeroProdotti) throws SQLException;
	
	/**
	 * Modifica la quantità di un prodotto in base al suo identificativo
	 * @param idProdotto, quantita
	 * @return
	 * @throws SQLException
	 */
	public boolean updateQuantita(int idProdotto, int quantita) throws SQLException;
	
	/**
	 * Modifica i dati di un prodotto 
	 * @param ProdottoBean
	 * @return
	 * @throws SQLException
	 */
	public void doUpdate(ProductBean product) throws SQLException;

	/**
	 * Ricerca dei prodotti in base al titolo
	 * @param filter
	 * @return collezione di ProdottoBean
	 * @throws SQLException
	 */
	Collection<ProductBean> getProductByTitle(String title) throws SQLException;

}
