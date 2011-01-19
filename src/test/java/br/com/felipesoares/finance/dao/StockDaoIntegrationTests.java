package br.com.felipesoares.finance.dao;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import br.com.felipesoares.finance.TestObjects;
import br.com.felipesoares.finance.domain.Stock;

@ContextConfiguration(locations = { "classpath*:data-context-test.xml" } )
public class StockDaoIntegrationTests extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private StockDao stockDao;

	@Test
	public void test_save() {
		Integer initialCount = stockDao.count();
		Stock sample = TestObjects.createSampleStock();
		stockDao.save(sample);
		Integer finalCount = stockDao.count();
		
		assertTrue(finalCount == initialCount + 1);
		assertNotNull(stockDao.findById(sample.getCode()));
	}
	
	@Test
	public void test_update() {
		Stock sample = TestObjects.createSampleStock();
		stockDao.save(sample);
		
		sample.setCompanyName("Felipe SA");
		stockDao.save(sample);
		
		Stock stock = stockDao.findById(sample.getCode());
		
		assertNotNull(stock);
		
		assertEquals(sample.getCompanyName(), stock.getCompanyName());
	}
	
	@Test
	public void test_delete() {
		Stock sample = TestObjects.createSampleStock();
		stockDao.save(sample);
		Integer initialCount = stockDao.count();
		
		stockDao.delete(sample);
		Integer finalCount = stockDao.count();
		
		assertTrue(finalCount == initialCount - 1);
		
		assertNull(stockDao.findById(sample.getCode()));
	}
	
}
