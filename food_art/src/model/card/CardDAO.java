package model.card;

import java.sql.SQLException;
import java.util.Collection;

public interface CardDAO {
	
	/**
	 * Controlla se una carta è esistente
	 * @param nCarta
	 * @return true se una carta esiste, false altrimenti
	 * @throws SQLException
	 */
	boolean cartaEsistente(String nCarta) throws SQLException;
	
	/**
	 * Controlla se è possibile effettuare un pagamento
	 * @param nCarta e spesa
	 * @return true se è possibile effetture il pagamento, false altrimenti
	 * @throws SQLException
	 */
	boolean pagamentoPossibile(String nCarta, float spesa) throws SQLException;
	
	/**
	 * Effettua un pagamento
	 * @param nCarta e spesa
	 * @return
	 * @throws SQLException
	 */
	void effettuaPagamento(String nCarta, float spesa) throws SQLException;
	
	/**
	 * Restituisce una collezione di carte collegate a un determinato utente
	 * @param idUser
	 * @return Collezione di MetodoPagamentoBean
	 * @throws SQLException
	 */
	Collection<CardBean> getMetodoPagamentoByIdUser (int idUser) throws SQLException;
	
	/**
	 * Restituisce una collezione di carte collegate a un determinato utente
	 * @param idUser
	 * @return MetodoPagamentoBean
	 * @throws SQLException
	 */
	CardBean getMetodoPagamentoByCard (String card) throws SQLException;

	void doSave(CardBean card) throws SQLException;

	boolean doDelete(String code) throws SQLException;

}
