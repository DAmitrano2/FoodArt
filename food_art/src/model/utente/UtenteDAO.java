package model.utente;

import java.sql.SQLException;
import java.util.Collection;

import model.utente.UtenteBean;

public interface UtenteDAO {
	
	/**
	 * Salva i dati di un utente
	 * @param user
	 * @return null
	 * @throws SQLException
	 */
    public int doSave(UtenteBean user) throws SQLException;
	
	/**
	 * Controlla se esiste un utente con una determinata email
	 * @param email
	 * @return true se esiste già un utente con una determinata email, false altrimenti
	 * @throws SQLException
	 */
	public boolean isEmail(String email) throws SQLException;

	/**
	 * Carica i dati idi un singolo utente in base all'email e alla password
	 * @param email e password
	 * @return un user se email e password corrispondono ad un utente presente nel database, null altrimenti
	 * @throws SQLException
	 */
	public UtenteBean doRetrieveByKey(String email, String password) throws SQLException;
	
	/**
	 * Carica i dati di tutti gli utenti 
	 * @param 
	 * @return una collezione di user
	 * @throws SQLException
	 */	
	public Collection<UtenteBean> doRetrieveAll() throws SQLException;
	
	/**
	 * Blocca un utente settando a true il suo specifico parametro
	 * @param user
	 * @return null
	 * @throws SQLException
	 */
    public void banned(int idUtente) throws SQLException;
    
    /**
	 * Controlla se un utente è amministratore
	 * @param idUtente
	 * @return true se l'utente è amministratore, false altrimenti
	 * @throws SQLException
	 */
	public boolean isAmministratore(int idUtente) throws SQLException;
	
	 /**
		 * Controlla se un utente è rivenditore
		 * @param idUtente
		 * @return true se l'utente è rivenditore, false altrimenti
		 * @throws SQLException
		 */
	public boolean isRivenditore(int idUtente) throws SQLException;
    

}
