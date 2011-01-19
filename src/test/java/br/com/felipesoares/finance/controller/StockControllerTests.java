package br.com.felipesoares.finance.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ModelMap;

import br.com.felipesoares.finance.TestObjects;
import br.com.felipesoares.finance.dao.hibernate.StockDaoImpl;
import br.com.felipesoares.finance.domain.Stock;

public class StockControllerTests {

	private StockController stockController;
	
	@Before
	public void setup() {
		stockController = new StockController();
		stockController.stockDao = mock(StockDaoImpl.class);
	}

	@Test
	public void test_list() {
		List<Stock> stockList = new ArrayList<Stock>();
		stockList.add(TestObjects.createSampleStock());
		
		when(stockController.stockDao.findAll()).thenReturn(stockList);
		
		ModelMap modelMap = stockController.list();
		
		verify(stockController.stockDao).findAll();
		
		assertNotNull(modelMap.get("stockList"));

		assertTrue(((List<Stock>) modelMap.get("stockList")).size() == 1);
	}
	
	@Test
	public void test_show() {
		String id = "ABCD1";
		
		when(stockController.stockDao.findById(id)).thenReturn(TestObjects.createSampleStock());
		
		ModelMap modelMap = stockController.show(id);
		
		verify(stockController.stockDao).findById(id);
		
		assertNotNull(modelMap.get("stock"));
	}

}
