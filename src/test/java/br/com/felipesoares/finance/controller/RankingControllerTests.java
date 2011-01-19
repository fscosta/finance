package br.com.felipesoares.finance.controller;

import static org.junit.Assert.assertEquals;
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
import br.com.felipesoares.finance.dao.hibernate.RankingDaoImpl;
import br.com.felipesoares.finance.domain.Ranking;
import br.com.felipesoares.finance.service.RankingService;

public class RankingControllerTests {

	private RankingController rankingController;
	
	@Before
	public void setup() {
		rankingController = new RankingController();
		rankingController.rankingService = mock(RankingService.class);
		rankingController.rankingDao = mock(RankingDaoImpl.class);
	}
	
	@Test
	public void test_refresh() {
		Long id = 1l;
		String redirect = rankingController.refresh(id);
		
		verify(rankingController.rankingService).refresh(id);
		
		assertEquals("redirect:show.do?id=1", redirect);
	}
	
	@Test
	public void test_list() {
		List<Ranking> rankingList = new ArrayList<Ranking>();
		rankingList.add(TestObjects.createSampleRanking());
		
		when(rankingController.rankingDao.findAll()).thenReturn(rankingList);
		
		ModelMap modelMap = rankingController.list();
		
		verify(rankingController.rankingDao).findAll();
		
		assertNotNull(modelMap.get("rankings"));

		assertTrue(((List<Ranking>) modelMap.get("rankings")).size() == 1);
	}
	
	@Test
	public void test_show() {
		Long id = 1l;
		
		when(rankingController.rankingDao.findById(id)).thenReturn(TestObjects.createSampleRanking());
		
		ModelMap modelMap = rankingController.show(id);
		
		verify(rankingController.rankingDao).findById(id);
		
		assertNotNull(modelMap.get("ranking"));
	}
	
	@Test
	public void test_edit() {
		Long id = 1l;
		
		when(rankingController.rankingDao.findById(id)).thenReturn(TestObjects.createSampleRanking());
		
		ModelMap modelMap = rankingController.edit(id);
		
		verify(rankingController.rankingDao).findById(id);
		
		assertNotNull(modelMap.get("ranking"));
	}
	
	@Test
	public void test_update() {
		Long id = 1l;
		Ranking ranking = TestObjects.createSampleRanking();
		
		when(rankingController.rankingDao.findById(id)).thenReturn(ranking);

		String redirect =  rankingController.save(id, "new Title");
		
		verify(rankingController.rankingDao).findById(id);
		verify(rankingController.rankingDao).save(ranking);
		
		assertEquals("redirect:show.do?id=1", redirect);
	}
	
	@Test
	public void test_save() {
		Long id = 1l;
		Ranking ranking = TestObjects.createSampleRanking();
		
		when(rankingController.rankingDao.findById(id)).thenReturn(ranking);

		String redirect =  rankingController.save(id, "Title");
		
		verify(rankingController.rankingDao).save(ranking);
		
		assertEquals("redirect:show.do?id=1", redirect);
	}
	
	@Test
	public void test_delete() {
		Long id = 1l;
		Ranking ranking = TestObjects.createSampleRanking();
		
		when(rankingController.rankingDao.findById(id)).thenReturn(ranking);

		String redirect =  rankingController.delete(id);
		
		verify(rankingController.rankingDao).findById(id);
		verify(rankingController.rankingDao).delete(ranking);
		
		assertEquals("redirect:list.do", redirect);
	}
	
}
