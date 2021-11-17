package test.unit;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import model.dealer.DealerBean;

class TestRivenditore extends TestCase {
	DealerBean dealerBean;
	Calendar calendar;
	java.sql.Date dataNascita;
	
	@BeforeEach
	public void setUp() throws Exception {
		dealerBean = new DealerBean();
		calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Rome"),Locale.ITALY);
	}

	@AfterEach
	public void tearDown() throws Exception {
		
	}
	
	@Test
	public void TestRivenditoreCorretto() throws SQLException{
		calendar.set(1940, 3, 25);
		
		java.util.Date utilDataNascita = calendar.getTime();
		dataNascita = new java.sql.Date(utilDataNascita.getTime());
		
		dealerBean.setDataNascita(dataNascita);
		dealerBean.setCitta("Milano");
		dealerBean.setProvincia("MI");
		dealerBean.setCodiceFiscale("PCNLAX40D25F205K");
		dealerBean.setRagioneSociale("La Bottega Del Padrino");
		dealerBean.setProvinciaSedeLegale("MI");
		dealerBean.setCittaSedeLegale("Milano");
		dealerBean.setCapSedeLegale("20019");
		dealerBean.setViaSedeLegale("Via Desiderio");
		dealerBean.setNumeroCivicoSedeLegale("14");
		dealerBean.setNumeroPartitaIva("12345678910");
		
		assertEquals(true, DealerBean.matches(dealerBean));
	}
	
	@Test
	public void TestRivenditoreDataSbagliata() throws SQLException{
		calendar.set(2004, 3, 25);
		
		java.util.Date utilDataNascita = calendar.getTime();
		dataNascita = new java.sql.Date(utilDataNascita.getTime());
		
		dealerBean.setDataNascita(dataNascita);
		dealerBean.setCitta("Milano");
		dealerBean.setProvincia("MI");
		dealerBean.setCodiceFiscale("PCNLAX40D25F205K");
		dealerBean.setRagioneSociale("La Bottega Del Padrino");
		dealerBean.setProvinciaSedeLegale("MI");
		dealerBean.setCittaSedeLegale("Milano");
		dealerBean.setCapSedeLegale("20019");
		dealerBean.setViaSedeLegale("Via Desiderio");
		dealerBean.setNumeroCivicoSedeLegale("14");
		dealerBean.setNumeroPartitaIva("12345678910");
		
		assertEquals(false, DealerBean.matches(dealerBean));
	}
	
	@Test
	public void TestRivenditoreCittaSbagliata() throws SQLException{
		calendar.set(1940, 3, 25);
		
		java.util.Date utilDataNascita = calendar.getTime();
		dataNascita = new java.sql.Date(utilDataNascita.getTime());
		
		dealerBean.setDataNascita(dataNascita);
		dealerBean.setCitta("1234");
		dealerBean.setProvincia("MI");
		dealerBean.setCodiceFiscale("PCNLAX40D25F205K");
		dealerBean.setRagioneSociale("La Bottega Del Padrino");
		dealerBean.setProvinciaSedeLegale("MI");
		dealerBean.setCittaSedeLegale("Milano");
		dealerBean.setCapSedeLegale("20019");
		dealerBean.setViaSedeLegale("Via Desiderio");
		dealerBean.setNumeroCivicoSedeLegale("14");
		dealerBean.setNumeroPartitaIva("12345678910");
		
		assertEquals(false, DealerBean.matches(dealerBean));
	}
	
	@Test
	public void TestRivenditoreProvinciaSbagliata() throws SQLException{
		calendar.set(1940, 3, 25);
		
		java.util.Date utilDataNascita = calendar.getTime();
		dataNascita = new java.sql.Date(utilDataNascita.getTime());
		
		dealerBean.setDataNascita(dataNascita);
		dealerBean.setCitta("Milano");
		dealerBean.setProvincia("Milano");
		dealerBean.setCodiceFiscale("PCNLAX40D25F205K");
		dealerBean.setRagioneSociale("La Bottega Del Padrino");
		dealerBean.setProvinciaSedeLegale("MI");
		dealerBean.setCittaSedeLegale("Milano");
		dealerBean.setCapSedeLegale("20019");
		dealerBean.setViaSedeLegale("Via Desiderio");
		dealerBean.setNumeroCivicoSedeLegale("14");
		dealerBean.setNumeroPartitaIva("12345678910");
		
		assertEquals(false, DealerBean.matches(dealerBean));
	}
	
	@Test
	public void TestRivenditoreFormatoCodiceFiscaleSbagliato() throws SQLException{
		calendar.set(1940, 3, 25);
		
		java.util.Date utilDataNascita = calendar.getTime();
		dataNascita = new java.sql.Date(utilDataNascita.getTime());
		
		dealerBean.setDataNascita(dataNascita);
		dealerBean.setCitta("Milano");
		dealerBean.setProvincia("MI");
		dealerBean.setCodiceFiscale("PCNLAX");
		dealerBean.setRagioneSociale("La Bottega Del Padrino");
		dealerBean.setProvinciaSedeLegale("MI");
		dealerBean.setCittaSedeLegale("Milano");
		dealerBean.setCapSedeLegale("20019");
		dealerBean.setViaSedeLegale("Via Desiderio");
		dealerBean.setNumeroCivicoSedeLegale("14");
		dealerBean.setNumeroPartitaIva("12345678910");
		
		assertEquals(false, DealerBean.matches(dealerBean));
	}
	
	@Test
	public void TestRivenditoreRagioneSocialeSbagliata() throws SQLException{
		calendar.set(1940, 3, 25);
		
		java.util.Date utilDataNascita = calendar.getTime();
		dataNascita = new java.sql.Date(utilDataNascita.getTime());
		
		dealerBean.setDataNascita(dataNascita);
		dealerBean.setCitta("Milano");
		dealerBean.setProvincia("MI");
		dealerBean.setCodiceFiscale("PCNLAX40D25F205K");
		dealerBean.setRagioneSociale("");
		dealerBean.setProvinciaSedeLegale("MI");
		dealerBean.setCittaSedeLegale("Milano");
		dealerBean.setCapSedeLegale("20019");
		dealerBean.setViaSedeLegale("Via Desiderio");
		dealerBean.setNumeroCivicoSedeLegale("14");
		dealerBean.setNumeroPartitaIva("12345678910");
		
		assertEquals(false, DealerBean.matches(dealerBean));
	}
	
	@Test
	public void TestRivenditoreViaSedeLegaleSbagliata() throws SQLException{
		calendar.set(1940, 3, 25);
		
		java.util.Date utilDataNascita = calendar.getTime();
		dataNascita = new java.sql.Date(utilDataNascita.getTime());
		
		dealerBean.setDataNascita(dataNascita);
		dealerBean.setCitta("Milano");
		dealerBean.setProvincia("MI");
		dealerBean.setCodiceFiscale("PCNLAX40D25F205K");
		dealerBean.setRagioneSociale("La Bottega Del Padrino");
		dealerBean.setProvinciaSedeLegale("MI");
		dealerBean.setCittaSedeLegale("Milano");
		dealerBean.setCapSedeLegale("20019");
		dealerBean.setViaSedeLegale("1234");
		dealerBean.setNumeroCivicoSedeLegale("14");
		dealerBean.setNumeroPartitaIva("12345678910");
		
		assertEquals(false, DealerBean.matches(dealerBean));
	}
	
	@Test
	public void TestRivenditoreNumeroCivicoRagioneSocialeSbagliata() throws SQLException{
		calendar.set(1940, 3, 25);
		
		java.util.Date utilDataNascita = calendar.getTime();
		dataNascita = new java.sql.Date(utilDataNascita.getTime());
		
		dealerBean.setDataNascita(dataNascita);
		dealerBean.setCitta("Milano");
		dealerBean.setProvincia("MI");
		dealerBean.setCodiceFiscale("PCNLAX40D25F205K");
		dealerBean.setRagioneSociale("La Bottega Del Padrino");
		dealerBean.setProvinciaSedeLegale("MI");
		dealerBean.setCittaSedeLegale("Milano");
		dealerBean.setCapSedeLegale("20019");
		dealerBean.setViaSedeLegale("Via Desiderio");
		dealerBean.setNumeroCivicoSedeLegale("Quattordici");
		dealerBean.setNumeroPartitaIva("12345678910");
		
		assertEquals(false, DealerBean.matches(dealerBean));
	}
	
	@Test
	public void TestRivenditoreNumeroPartitaIvaSbagliato() throws SQLException{
		calendar.set(1940, 3, 25);
		
		java.util.Date utilDataNascita = calendar.getTime();
		dataNascita = new java.sql.Date(utilDataNascita.getTime());
		
		dealerBean.setDataNascita(dataNascita);
		dealerBean.setCitta("Milano");
		dealerBean.setProvincia("MI");
		dealerBean.setCodiceFiscale("PCNLAX40D25F205K");
		dealerBean.setRagioneSociale("La Bottega Del Padrino");
		dealerBean.setProvinciaSedeLegale("MI");
		dealerBean.setCittaSedeLegale("Milano");
		dealerBean.setCapSedeLegale("20019");
		dealerBean.setViaSedeLegale("Via Desiderio");
		dealerBean.setNumeroCivicoSedeLegale("14");
		dealerBean.setNumeroPartitaIva("1234");
		
		assertEquals(false, DealerBean.matches(dealerBean));
	}
	
	@Test
	public void TestRivenditoreCapSedeLegaleSbagliato() throws SQLException{
		calendar.set(1940, 3, 25);
		
		java.util.Date utilDataNascita = calendar.getTime();
		dataNascita = new java.sql.Date(utilDataNascita.getTime());
		
		dealerBean.setDataNascita(dataNascita);
		dealerBean.setCitta("Milano");
		dealerBean.setProvincia("MI");
		dealerBean.setCodiceFiscale("PCNLAX40D25F205K");
		dealerBean.setRagioneSociale("La Bottega Del Padrino");
		dealerBean.setProvinciaSedeLegale("MI");
		dealerBean.setCittaSedeLegale("Milano");
		dealerBean.setCapSedeLegale("200191234");
		dealerBean.setViaSedeLegale("Via Desiderio");
		dealerBean.setNumeroCivicoSedeLegale("14");
		dealerBean.setNumeroPartitaIva("12345678910");
		
		assertEquals(false, DealerBean.matches(dealerBean));
	}
}
