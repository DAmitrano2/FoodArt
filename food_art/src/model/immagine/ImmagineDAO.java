package model.immagine;

import java.sql.SQLException;
import java.util.Collection;

public interface ImmagineDAO {
	
	/**
	 * Salva i dati di un immagine 	
	 * @param image
	 * @return 
	 * @throws SQLException
	 */
	public void doSave(ImmagineBean image) throws SQLException;

	/**
	 * Elimina i dati di un immagine
	 * @param id
	 * @return true se l'eliminazione � andata a buon fine, false altrimenti
	 * @throws SQLException
	 */
	public boolean doDelete(int id) throws SQLException;

	/**
	 * Restituisce un immagine in base al suo identificativo
	 * @param idImmagine
	 * @return ImmagineBean
	 * @throws SQLException
	 */
	public ImmagineBean doRetrieveByKey(int idImmagine) throws SQLException;

	/**
	 * Restituisce una collezione di immagini in base all'identificativo del prodotto che rappresentano 
	 * @param idProdotto
	 * @return Collezione di ImmagineBean
	 * @throws SQLException
	 */
	public Collection<ImmagineBean> getImagesByProdotto(int idProdotto) throws SQLException;

}
