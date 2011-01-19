package br.com.felipesoares.finance;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.felipesoares.finance.GreenblattComparator;
import br.com.felipesoares.finance.domain.Stock;

public class GreenblattComparatorTests {

	@Test
	public void test_compare() {
		List<Stock> stocks = TestObjects.getStocks();
		Collections.sort(stocks, new GreenblattComparator());
		Assert.assertEquals("GETI41", stocks.get(0).getCode());
		Assert.assertEquals("GETI4", stocks.get(1).getCode());
		Assert.assertEquals("PETR4", stocks.get(2).getCode());
		Assert.assertEquals("ECOD3", stocks.get(3).getCode());
	}
	
}
