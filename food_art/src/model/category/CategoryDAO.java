package model.category;

import java.sql.SQLException;
import java.util.Collection;

public interface CategoryDAO {
	
	/**
	 * Salva i dati di una categoria
	 * @param category
	 * @return null
	 * @throws SQLException
	 */	
	public void doSave(CategoryBean category) throws SQLException;
	
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
	public CategoryBean doRetrieveByKey(int idCategoria) throws SQLException;
	
	/**
	 * Restituisce i dati di tutte le categorie
	 * @param idCategoria
	 * @return collezione di CategoriaBean
	 * @throws SQLException
	 */	
	public Collection<CategoryBean> doRetrieveAll() throws SQLException;
	
	/**
	 * Restituisce l'immagine della categoria in base all'id
	 * @param idCategoria
	 * @return CategoriaBean
	 * @throws SQLException
	 */
	public byte[] doRetrieveByKeyCategoria(int idCategoria) throws SQLException;

}
