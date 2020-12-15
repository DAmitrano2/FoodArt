package model.prodotto;

import java.sql.SQLException;
import java.util.Collection;



public interface ProdottoDAO {
	public void doSave(ProdottoBean product) throws SQLException;

	public boolean doDelete(int id) throws SQLException;

	public ProdottoBean doRetrieveByKey(int id) throws SQLException;
	
	/**
	 * Ricerca dei prodotti in base all'id di categoria
	 * @param filter
	 * @return
	 * @throws SQLException
	 */
	public Collection<ProdottoBean> getProductByIdCategory(int idCategory) throws SQLException;
	
	public Collection<ProdottoBean> doRetrieveAll(String order) throws SQLException;
	
	public Collection<ProdottoBean> doRetrieveMostOrder() throws SQLException;
	
	public void updateQuantita(int idOrdine, int quantita) throws SQLException;
	
	public Collection<ProdottoBean> doRetriveGlutine(boolean tipo) throws SQLException;
	
	public Collection<ProdottoBean> doRetriveOfferte() throws SQLException;
	
	public void doUpdate(ProdottoBean product) throws SQLException;

}
