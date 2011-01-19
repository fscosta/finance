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
import br.com.felipesoares.finance.domain.Ranking;

@ContextConfiguration(locations = { "classpath*:data-context-test.xml" } )
public class RankingDaoIntegrationTests extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private RankingDao rankingDao;
	
	@Test
	public void test_save() {
		Integer initialCount = rankingDao.count();
		Ranking sample = TestObjects.createSampleRanking();
		rankingDao.save(sample);
		Integer finalCount = rankingDao.count();
		
		assertTrue(finalCount == initialCount + 1);
		
		Ranking assertionSample = new Ranking();
		assertionSample.setTitle(sample.getTitle());
		
		assertNotNull(rankingDao.findByExample(assertionSample));
	}
	
	@Test
	public void test_update() {
		Ranking sample = TestObjects.createSampleRanking();
		rankingDao.save(sample);
		
		sample.setTitle("Novo ranking");
		rankingDao.save(sample);
		
		Ranking ranking = rankingDao.findById(sample.getId());
		
		assertNotNull(ranking);
		
		assertEquals(sample.getTitle(), ranking.getTitle());
	}
	
	@Test
	public void test_delete() {
		Ranking sample = TestObjects.createSampleRanking();
		rankingDao.save(sample);
		Integer initialCount = rankingDao.count();
		
		rankingDao.delete(sample);
		Integer finalCount = rankingDao.count();
		
		assertTrue(finalCount == initialCount - 1);
		
		assertNull(rankingDao.findById(sample.getId()));
	}
	
}
