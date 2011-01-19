package br.com.felipesoares.finance.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import br.com.felipesoares.finance.GreenblattComparator;
import br.com.felipesoares.finance.client.FundamentusClient;
import br.com.felipesoares.finance.client.FundamentusParser;
import br.com.felipesoares.finance.dao.RankingDao;
import br.com.felipesoares.finance.dao.RankingItemDao;
import br.com.felipesoares.finance.dao.StockDao;
import br.com.felipesoares.finance.domain.Ranking;
import br.com.felipesoares.finance.domain.RankingItem;
import br.com.felipesoares.finance.domain.Stock;
import br.com.felipesoares.finance.service.RankingService;

@Service
public class RankingService {

	private String[] stockcodes;
	
	@Autowired
	protected RankingItemDao rankingItemDao;
	
	@Autowired
	protected RankingDao rankingDao;
	
	@Autowired
	protected StockDao stockDao;

	private Resource stocksFile;
	
	public void setStocksFile(Resource stocksFile) {
		this.stocksFile = stocksFile;
	}
	
	public void refresh(Long rankingId) {
		FundamentusClient client = new FundamentusClient();
		FundamentusParser stockParser = new FundamentusParser(client.downloadHtml(stockcodes));	
		List<Stock> stocks = stockParser.getStocks(stockcodes);
		// TODO: Recuperar os stocks do banco para fazer update.
		stockDao.saveAll(stocks);
		
		Collections.sort(stocks, new GreenblattComparator());
		Ranking ranking = rankingDao.findById(rankingId);
		ranking.setDate(new Date());

		List<RankingItem> rankingItems = new ArrayList<RankingItem>();
		
		for (int i = 0; i < stocks.size(); i++) {
			RankingItem item = new RankingItem();
			item.setStock(stocks.get(i));
			item.setRankingPosition(i + 1);
			item.setRanking(ranking);
			rankingItems.add(item);
		}

		ranking.setItems(rankingItems);
		rankingItemDao.saveAll(rankingItems);
		rankingDao.save(ranking);
	}

	public void getAllCodes() {
		BufferedReader buffReader = null;
		
		try {
			buffReader = new BufferedReader(new InputStreamReader(stocksFile.getInputStream()));  
			String line = buffReader.readLine();  

			if (line != null)
				stockcodes = line.split(" ");
			
		} catch(IOException ioe){  
			ioe.printStackTrace();  
		} finally {
			
			try {  
				buffReader.close();  
			} catch(IOException ioe1){  
				ioe1.printStackTrace();
			}  
		} 
	}
	
}
