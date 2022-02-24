package model.feedback;

import java.sql.SQLException;
import java.util.Collection;

public interface FeedbackDAO {

	/**
	 * Salva i dati di un feedback
	 * @return
	 * @param feed
	 * @throws SQLException
	 */
	public void doSave (FeedbackBean feed) throws SQLException;
	
	/**
	 * Elimina i dati di un feedback
	 * @return 
	 * @param idFeedback
	 * @throws SQLException
	 */
	public boolean doDelete (int idFeedback) throws SQLException;
	
	/**
	 * Restituisce tutti i feedback inseriti da un determinato utente
	 * @param idUtente
	 * @return Collezione di FeedbackBean
	 * @throws SQLException
	 */
	public Collection<FeedbackBean> doRetriveByUser (int idUtente) throws SQLException;
	
	/**
	 * Restituisce tutti i feedback ricevuti da un determinato rivenditore
	 * @param idUtenteRivenditore
	 * @return Collezione di FeedbackBean
	 * @throws SQLException
	 */
	public Collection<FeedbackBean> doRetriveByDealer (int idUtenteRivenditore) throws SQLException;
	
	/**
	 * Restituisce tutti i feedback ricevuti da un determinato prodotto
	 * @param idProdotto
	 * @return Collezione di FeedbackBean
	 * @throws SQLException
	 */
	public Collection<FeedbackBean> doRetriveByProduct (int idProdotto) throws SQLException;

	/**
	 * Restituisce il feedback di valutazione migliore di un determinato rivenditore
	 * @param idUser
	 * @return FeedbackBean
	 * @throws SQLException
	 */
	public FeedbackBean doRetriveBestFeedbackByUser(int idUser) throws SQLException;
	
	/**
	 * Carica i dati di tutti i feedback
	 * @param 
	 * @return una collezione di feedback
	 * @throws SQLException
	 */	
	public Collection<FeedbackBean> doRetrieveAll() throws SQLException;
	
}
