package test.unit;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import model.user.UserBean;

class TestCliente extends TestCase {
	UserBean userBean;
	
	@BeforeEach
	public void setUp() throws Exception {
		userBean = new UserBean();
	}

	@AfterEach
	public void tearDown() throws Exception {
	}
	
	@Test
	public void TestClienteCorretto() throws SQLException{
		userBean.setNome("Brad");
		userBean.setCognome("Pitt");
		userBean.setEmail("bradpitt63@gmail.com");
		userBean.setPassword("hollywood18");
		
		assertEquals(true, UserBean.matches(userBean));
	}
	
	@Test
	public void TestClienteNomeSbagliato() throws SQLException {
		userBean.setNome("1234");
		userBean.setCognome("Pitt");
		userBean.setEmail("bradpitt63@gmail.com");
		userBean.setPassword("hollywood18");
		
		assertEquals(false, UserBean.matches(userBean));
	}
	
	@Test
	public void TestClienteCognomeSbagliato() throws SQLException {
		userBean.setNome("Brad");
		userBean.setCognome("1234");
		userBean.setEmail("bradpitt63@gmail.com");
		userBean.setPassword("hollywood18");
		
		assertEquals(false, UserBean.matches(userBean));
	}
	
	@Test
	public void TestClienteEmailSbagliata() throws SQLException {
		userBean.setNome("Brad");
		userBean.setCognome("Pitt");
		userBean.setEmail("bradpitt63gmail.com");
		userBean.setPassword("hollywood18");
		
		assertEquals(false, UserBean.matches(userBean));
	}
	
	@Test
	public void TestClientePasswordSbagliata() throws SQLException {
		userBean.setNome("Brad");
		userBean.setCognome("Pitt");
		userBean.setEmail("bradpitt63@gmail.com");
		userBean.setPassword("hollywo");
		
		assertEquals(false, UserBean.matches(userBean));
	}
}
