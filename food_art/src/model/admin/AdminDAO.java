package model.admin;

import java.sql.SQLException;
import java.util.Collection;

public interface AdminDAO {
	
	/**
	 * Salva i dati di un amministratore
	 * @param admin
	 * @return null
	 * @throws SQLException
	 */
	public void doSave(AdminBean admin) throws SQLException;
	
	/**
	 * Carica i dati di un singolo amministratore in base al codice identificativo utente.
	 * @param idUtente
	 * @return un amministratore se l'identificativo utente è realmente corrispondente ad un amministratore, null altrimenti
	 * @throws SQLException
	 */	
	public AdminBean doRetriveById(int idUtente) throws SQLException;
	
	/**
	 * Carica i dati di tutti gli amministratori
	 * @param 
	 * @return una collezione di amministratori
	 * @throws SQLException
	 */	
	public Collection<AdminBean> doRetrieveAll() throws SQLException;
	
	
}
