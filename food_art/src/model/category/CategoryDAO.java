package model.categoria;

import java.sql.SQLException;
import java.util.Collection;

public interface CategoriaDAO {
	
	/**
	 * Salva i dati di una categoria
	 * @param category
	 * @return null
	 * @throws SQLException
	 */	
	public void doSave(CategoriaBean category) throws SQLException;
	
	/**
	 * Modifica i dati di una categoria in base al suo identificativo
	 * @param idCategoria
	 * @return null
	 * @throws SQLException
	 */	
	public void update(int idCategoria, String NewName) throws SQLException;

	/**
	 * Elimina i dati di una categoria in base al suo identificativo
	 * @param idCategoria
	 * @return null
	 * @throws SQLException
	 */	
	public boolean doDelete(int idCatoria) throws SQLException;

	/**
	 * Restituisce i dati di una categoria in base al suo identificativo
	 * @param idCategoria
	 * @return CategoriaBean
	 * @throws SQLException
	 */	
	public CategoriaBean doRetrieveByKey(int idCategoria) throws SQLException;
	
	/**
	 * Restituisce i dati di tutte le categorie
	 * @param idCategoria
	 * @return collezione di CategoriaBean
	 * @throws SQLException
	 */	
	public Collection<CategoriaBean> doRetrieveAll() throws SQLException;
	
	/**
	 * Restituisce l'immagine della categoria in base all'id
	 * @param idCategoria
	 * @return CategoriaBean
	 * @throws SQLException
	 */
	public byte[] doRetrieveByKeyCategoria(int idCategoria) throws SQLException;

}
