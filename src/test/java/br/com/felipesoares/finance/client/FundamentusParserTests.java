package br.com.felipesoares.finance.client;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.felipesoares.finance.TestObjects;
import br.com.felipesoares.finance.client.FundamentusParser;
import br.com.felipesoares.finance.domain.Stock;

public class FundamentusParserTests {

	@Test
	public void test_get_PETR4_VPA() {
		FundamentusParser fundamentus = new FundamentusParser(TestObjects.getHtmlList());
		String[] stocknames = {"PETR4", "GETI4"};
		List<Stock> stocks = fundamentus.getStocks(stocknames);
		
		Assert.assertFalse("O sistema deveria retornar algumas ações.", stocks.isEmpty());
		Assert.assertEquals("O código do papel deveria ser PETR4, mas o retornado foi " + stocks.get(0).getCode(), "PETR4", stocks.get(0).getCode());
		Assert.assertTrue("O VPA esperado era 22.8, mas o retornado foi " + stocks.get(0).getVpa(), 22.8f  == stocks.get(0).getVpa());
	}
	
	@Test
	public void test_get_GETI4_ROIC() {
		FundamentusParser fundamentus = new FundamentusParser(TestObjects.getHtmlList());
		String[] stocknames = {"PETR4", "GETI4"};
		List<Stock> stocks = fundamentus.getStocks(stocknames);
		
		Assert.assertFalse("O sistema deveria retornar algumas ações.", stocks.isEmpty());
		Assert.assertEquals("O código do papel deveria ser GETI4, mas o retornado foi " + stocks.get(1).getCode(), "GETI4", stocks.get(1).getCode());
		Assert.assertTrue("O ROIC esperado era 75.2, mas o retornado foi " + stocks.get(1).getRoic(), 75.2f  == stocks.get(1).getRoic());
	}
	
	@Test
	public void test_parse_stock_with_missing_data() {
		FundamentusParser parser = new FundamentusParser();
		
		try {
			Stock stock = parser.parseHtml(TestObjects.getHtmlWithMissingData().get(0));
			Assert.assertNull("O sistema deveria retornar o valor nulo.", stock);
		} catch(Exception e) {
			
		}
	}
	
	@Test
	public void test_get_stock_with_mission_data() {
		FundamentusParser parser = new FundamentusParser(TestObjects.getHtmlWithMissingData());
		
		try {
			String[] stockcodes = {"ABCB4"};
			List<Stock> stocks = parser.getStocks(stockcodes);
			Assert.assertTrue("O sistema deveria retornar uma lista vazia.", stocks.isEmpty());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
