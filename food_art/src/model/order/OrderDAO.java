package model.order;

import java.sql.SQLException;
import java.util.Collection;


public interface OrderDAO {
	
	public void doSave(OrderBean order) throws SQLException;

	/**
	 * Restituisce un ordine in base all'id
	 * @param idOrdine
	 * @return order
	 * @throws SQLException
	 */
	public OrderBean doRetrieveSingleOrder(int idOrdine) throws SQLException;
	
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
	public Collection<OrderBean> doRetrieveAll(int idUtente) throws SQLException;

	/**
	 * Restituisce tutti gli ordini presenti del db
	 * @return
	 * @throws SQLException
	 */
	public Collection<OrderBean> doRetrieveAll() throws SQLException;
	

}
