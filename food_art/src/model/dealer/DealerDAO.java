package model.dealer;

import java.sql.SQLException;
import java.util.Collection;

public interface DealerDAO {

	/**
	 * Salva i dati di un rivenditore
	 * @param dealer
	 * @return null
	 * @throws SQLException
	 */
	public void doSave(DealerBean dealer) throws SQLException;
	
	/**
	 * Carica il nome di un singolo rivenditore in base al codice identificativo utente.
	 * @param idUtente
	 * @return il nome dell'amministratore se l'identificativo utente è realmente corrispondente ad un rivenditore, null altrimenti
	 * @throws SQLException
	 */	
	public String doRetriveNameById(int idUtente) throws SQLException;
	
	/**
	 * Carica i dati di un singolo rivenditore in base al codice identificativo utente.
	 * @param idUtente
	 * @return un amministratore se l'identificativo utente è realmente corrispondente ad un rivenditore, null altrimenti
	 * @throws SQLException
	 */	
	public DealerBean doRetriveById(int idUtente) throws SQLException;
	
	/**
	 * Carica i dati di tutti i rivenditori
	 * @param 
	 * @return una collezione di rivenditori
	 * @throws SQLException
	 */	
	public Collection<DealerBean> doRetrieveAll() throws SQLException;
	
}
