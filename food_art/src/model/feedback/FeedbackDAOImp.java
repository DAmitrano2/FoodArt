package model.feedback;

import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.product.ProductDAOImp;

public class FeedbackDAOImp implements FeedbackDAO {
	
	public FeedbackDAOImp() {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");

			ds = (DataSource) envCtx.lookup("jdbc/food_art");
		}catch(NamingException e) {
			System.out.println("Error:" + e.getMessage());
		}
	}

	@Override
	public void doSave(FeedbackBean feed) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO "+ FeedbackDAOImp.TABLE_NAME + "(titolo, commento, valutazione, idCommentatore, idProdotto)"+
		"values(?, ?, ?, ?, ?)";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, feed.getTitolo());
			preparedStatement.setString(2, feed.getCommento());
			preparedStatement.setFloat(3, feed.getValutazione());
			preparedStatement.setInt(4, feed.getIdCommentatore());
			preparedStatement.setInt(5, feed.getIdProdotto());
			
			preparedStatement.executeUpdate();

			connection.commit();
			//--------------------------------------------------------------
			connection = null;
			preparedStatement = null;
			
			int idProdotto = feed.getIdProdotto(), i = 0, rating = 0;
			float finalRating = 0;
			
			String selectSQL = "SELECT * FROM " + FeedbackDAOImp.TABLE_NAME +" where idProdotto= ?";
			
			
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idProdotto);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			while(rs.next()) {
				i++;
				rating += rs.getFloat("valutazione");
			}
			finalRating = rating/i;
			ProductDAOImp modelProdotto = new ProductDAOImp();
			modelProdotto.updateRating(idProdotto, finalRating);

			connection.commit();
			
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}

	}

	@Override
	public boolean doDelete(int idFeedback) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + FeedbackDAOImp.TABLE_NAME + " WHERE idFeedback = ?";

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, idFeedback);

			result = preparedStatement.executeUpdate();
			
			connection.commit();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return (result != 0);
	}
	
	@Override
	public Collection<FeedbackBean> doRetriveByUser(int idUtente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<FeedbackBean> feedback = new LinkedList<FeedbackBean>();

		String selectSQL = "SELECT * FROM " + FeedbackDAOImp.TABLE_NAME +" where idCommentatore= ? ";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idUtente);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			boolean flag = false;
			
			while(rs.next()) {
				FeedbackBean feed = new FeedbackBean();
				feed.setIdFeedback(rs.getInt("idFeedback"));
				feed.setTitolo(rs.getString("titolo"));
				feed.setCommento(rs.getString("commento"));
				feed.setValutazione(rs.getFloat("valutazione"));
				feed.setIdCommentatore(rs.getInt("idCommentatore"));
				feed.setIdProdotto(rs.getInt("idProdotto"));
				
				feedback.add(feed);
				flag = true;
			}
			
			if( !flag ) {
				return null;
			}

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return feedback;
	}

	@Override
	public Collection<FeedbackBean> doRetriveByDealer(int idUtenteRivenditore) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<FeedbackBean> feedback = new LinkedList<FeedbackBean>();

		String selectSQL = "SELECT * FROM " + FeedbackDAOImp.TABLE_NAME +" where idRivenditore= ? ";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idUtenteRivenditore);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			boolean flag = false;
			
			while(rs.next()) {
				FeedbackBean feed = new FeedbackBean();
				feed.setIdFeedback(rs.getInt("idFeedback"));
				feed.setTitolo(rs.getString("titolo"));
				feed.setCommento(rs.getString("commento"));
				feed.setValutazione(rs.getFloat("valutazione"));
				feed.setIdCommentatore(rs.getInt("idCommentatore"));
				feed.setIdProdotto(rs.getInt("idProdotto"));
				
				feedback.add(feed);
				flag = true;
			}
			
			if( !flag ) {
				return null;
			}

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return feedback;
	}

	@Override
	public Collection<FeedbackBean> doRetriveByProduct(int idProdotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<FeedbackBean> feedback = new LinkedList<FeedbackBean>();

		String selectSQL = "SELECT * FROM " + FeedbackDAOImp.TABLE_NAME +" where idProdotto= ? ";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idProdotto);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			boolean flag = false;
			
			while(rs.next()) {
				FeedbackBean feed = new FeedbackBean();
				feed.setIdFeedback(rs.getInt("idFeedback"));
				feed.setTitolo(rs.getString("titolo"));
				feed.setCommento(rs.getString("commento"));
				feed.setValutazione(rs.getFloat("valutazione"));
				feed.setIdCommentatore(rs.getInt("idCommentatore"));
				feed.setIdProdotto(rs.getInt("idProdotto"));
				
				feedback.add(feed);
				flag = true;
			}
			
			if( !flag ) {
				return null;
			}

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return feedback;
	}
	
	@Override
	public FeedbackBean doRetriveBestFeedbackByUser(int idUser) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		FeedbackBean feed = new FeedbackBean();

		String selectSQL = "SELECT * FROM " + FeedbackDAOImp.TABLE_NAME + " where idRivenditore = ? group by idRivenditore having max(feedback.valutazione);";
		
		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, idUser);
			
			ResultSet rs = preparedStatement.executeQuery();
			
			boolean flag = false;
			
			while(rs.next()) {
				feed.setIdFeedback(rs.getInt("idFeedback"));
				feed.setTitolo(rs.getString("titolo"));
				feed.setCommento(rs.getString("commento"));
				feed.setValutazione(rs.getFloat("valutazione"));
				feed.setIdCommentatore(rs.getInt("idCommentatore"));
				feed.setIdProdotto(rs.getInt("idProdotto"));
				
				flag = true;
			}
			
			if( !flag ) {
				return null;
			}

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return feed;
	}
	
	@Override
	public Collection<FeedbackBean> doRetrieveAll() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<FeedbackBean> feedback = new LinkedList<FeedbackBean>();

		String selectSQL = "SELECT * FROM " + FeedbackDAOImp.TABLE_NAME;
		

		try {
			connection = ds.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();
			
			boolean flag = false;
			
			while (rs.next()) {
				FeedbackBean feed = new FeedbackBean();
				feed.setIdFeedback(rs.getInt("idFeedback"));
				feed.setTitolo(rs.getString("titolo"));
				feed.setCommento(rs.getString("commento"));
				feed.setValutazione(rs.getFloat("valutazione"));
				feed.setIdCommentatore(rs.getInt("idCommentatore"));
				feed.setIdProdotto(rs.getInt("idProdotto"));
				
				feedback.add(feed);
				flag = true;
			}
			
			if( !flag ) {
				return null;
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				if (connection != null)
					connection.close();
			}
		}
		return feedback;
	}
	
	private static final String TABLE_NAME = "feedback";
	
	private DataSource ds;
}