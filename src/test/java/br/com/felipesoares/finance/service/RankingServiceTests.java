package br.com.felipesoares.finance.service;

import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

import br.com.felipesoares.finance.dao.hibernate.RankingDaoImpl;
import br.com.felipesoares.finance.dao.hibernate.RankingItemDaoImpl;
import br.com.felipesoares.finance.dao.hibernate.StockDaoImpl;

public class RankingServiceTests {

	private RankingService rankingService;
	
	@Before
	public void setUp() {
		rankingService = new RankingService();
		rankingService.rankingDao = mock(RankingDaoImpl.class);
		rankingService.rankingItemDao = mock(RankingItemDaoImpl.class);
		rankingService.stockDao = mock(StockDaoImpl.class);

	}
	
	@Test
	public void test_refresh() {
		// TODO: Implementar este teste e refatorar o código. Colocar o client e o parser como dependências do service.
	}
}
