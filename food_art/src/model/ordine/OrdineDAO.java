package model.ordine;

import java.sql.SQLException;
import java.util.Collection;


public interface OrdineDAO {
	
	public void doSave(OrdineBean order) throws SQLException;

	/**
	 * Restituisce un ordine in base all'id
	 * @param idOrdine
	 * @return order
	 * @throws SQLException
	 */
	public OrdineBean doRetrieveSingleOrder(int idOrdine) throws SQLException;
	
	/**
	 * Restituisce l'ultimo ordine
	 * @param
	 * @return order
	 * @throws SQLException
	 */
	public int doRetrieveLastOrder(int idUtente) throws SQLException;

	/**
	 * Restituisce tutti gli ordini di un utente
	 * @param idUtente
	 * @return
	 * @throws SQLException
	 */
	public Collection<OrdineBean> doRetrieveAll(int idUtente) throws SQLException;

	/**
	 * Restituisce tutti gli ordini presenti del db
	 * @return
	 * @throws SQLException
	 */
	public Collection<OrdineBean> doRetrieveAll() throws SQLException;
	

}
