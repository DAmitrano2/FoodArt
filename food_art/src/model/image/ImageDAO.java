package model.image;

import java.sql.SQLException;
import java.util.Collection;

public interface ImageDAO {
	
	/**
	 * Salva i dati di un immagine 	
	 * @param image
	 * @return 
	 * @throws SQLException
	 */
	public void doSave(ImageBean image) throws SQLException;

	/**
	 * Elimina i dati di un immagine
	 * @param id
	 * @return true se l'eliminazione è andata a buon fine, false altrimenti
	 * @throws SQLException
	 */
	public boolean doDelete(int id) throws SQLException;

	/**
	 * Restituisce un immagine in base al suo identificativo
	 * @param idImmagine
	 * @return ImmagineBean
	 * @throws SQLException
	 */
	public ImageBean doRetrieveByKey(int idImmagine) throws SQLException;

	/**
	 * Restituisce un immagine in base all'identificativo del prodotto
	 * @param idProdotto
	 * @return ImmagineBean
	 * @throws SQLException
	 */
	public byte[] doRetrieveByKeyProdotto(int idProdotto) throws SQLException;

	/**
	 * Restituisce una collezione di immagini in base all'identificativo del prodotto che rappresentano 
	 * @param idProdotto
	 * @return Collezione di ImmagineBean
	 * @throws SQLException
	 */
	public ImageBean getImagesByProdotto(int idProdotto) throws SQLException;

}
