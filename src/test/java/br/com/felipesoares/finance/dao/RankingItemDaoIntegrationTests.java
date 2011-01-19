package br.com.felipesoares.finance.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import br.com.felipesoares.finance.TestObjects;
import br.com.felipesoares.finance.domain.RankingItem;

@ContextConfiguration(locations = { "classpath*:data-context-test.xml" } )
public class RankingItemDaoIntegrationTests extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private RankingItemDao rankingItemDao;
	
	@Autowired
	private RankingDao rankingDao;
	
	@Autowired
	private StockDao stockDao;
	
	@Test
	public void test_save() {
		Integer initialCount = rankingItemDao.count();
		RankingItem sample = TestObjects.createSampleRankingItem();
		rankingDao.save(sample.getRanking());
		stockDao.save(sample.getStock());
		rankingItemDao.save(sample);
		Integer finalCount = rankingItemDao.count();
		
		assertTrue(finalCount == initialCount + 1);
		
		RankingItem assertionSample = new RankingItem();
		assertionSample.setRankingPosition(sample.getRankingPosition());
		
		assertNotNull(rankingItemDao.findByExample(assertionSample));
	}

	@Test
	public void test_save_all() {
		Integer initialCount = rankingItemDao.count();
		
		List<RankingItem> rankingItems = new ArrayList<RankingItem>();
		RankingItem sample = TestObjects.createSampleRankingItem();
		rankingDao.save(sample.getRanking());
		stockDao.save(sample.getStock());
		rankingItems.add(sample);
		rankingItemDao.saveAll(rankingItems);
		
		Integer finalCount = rankingItemDao.count();
		
		assertTrue(finalCount == initialCount + 1);
		
		RankingItem assertionSample = new RankingItem();
		assertionSample.setRankingPosition(sample.getRankingPosition());
		
		assertNotNull(rankingItemDao.findByExample(assertionSample));
	}
	
	@Test
	public void test_update() {
		RankingItem sample = TestObjects.createSampleRankingItem();
		rankingDao.save(sample.getRanking());
		stockDao.save(sample.getStock());
		rankingItemDao.save(sample);
		
		sample.setRankingPosition(8);
		rankingItemDao.save(sample);
		
		RankingItem rankingItem = rankingItemDao.findById(sample.getId());
		
		assertNotNull(rankingItem);
		
		assertEquals(sample.getRankingPosition(), rankingItem.getRankingPosition());
	}
	
	@Test
	public void test_delete() {
		RankingItem sample = TestObjects.createSampleRankingItem();
		rankingDao.save(sample.getRanking());
		stockDao.save(sample.getStock());
		rankingItemDao.save(sample);
		Integer initialCount = rankingDao.count();
		
		rankingItemDao.delete(sample);
		Integer finalCount = rankingItemDao.count();
		
		assertTrue(finalCount == initialCount - 1);
		
		assertNull(rankingItemDao.findById(sample.getId()));
	}
	
}
