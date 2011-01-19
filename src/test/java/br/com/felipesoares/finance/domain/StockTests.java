package br.com.felipesoares.finance.domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.com.felipesoares.finance.TestObjects;

public class StockTests {

	private Stock stock;
	
	@Before
	public void setUp() {
		stock = TestObjects.createSampleStock();
	}
	
	@Test
	public void test_get_Ebit_Over_Net_Assets() {
		assertEquals(0.09084f, stock.getEbitOverNetAssets(), 0.00001f);
	}

	@Test
	public void test_get_Ebit_Over_Enterprise_Value() {
		assertEquals(0.05051f, stock.getEbitOverEnterpriseValue(), 0.00001f);
	}
}
