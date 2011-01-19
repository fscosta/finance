package br.com.felipesoares.finance;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.felipesoares.finance.domain.Ranking;
import br.com.felipesoares.finance.domain.RankingItem;
import br.com.felipesoares.finance.domain.Stock;

public class TestObjects {

	public static List<String> getHtmlList() {
		String[] stockcodes = {"PETR4", "GETI4"};
		return getHtml(stockcodes);
	}

	public static List<String> getHtmlWithMissingData() {
		String[] stockcodes = {"ABCB4"};
		return getHtml(stockcodes);
	}

	private static List<String> getHtml(String[] stockcodes) {
		List<String> htmlList = new ArrayList<String>();
		BufferedReader buffReader = null;
		
		try {
			
			for (String code : stockcodes) {
				StringBuilder builder = new StringBuilder();
				buffReader = new BufferedReader (new FileReader("src/test/resources/" + code + ".html"));  
				String line = buffReader.readLine();  
				
				while (line != null) {  
					builder.append(line);
					line = buffReader.readLine();  
				}
				
				htmlList.add(builder.toString());
			}
			
		} catch(IOException ioe){  
			ioe.printStackTrace();  
		} finally {
			
			try {  
				buffReader.close();  
			} catch(IOException ioe1){  
				ioe1.printStackTrace();
			}  
		} 
	
		return htmlList;
	}
	
	public static List<Stock> getStocks() {
		List<Stock> stocks = new ArrayList<Stock>();
		
		Stock ecod3 = new Stock();
		ecod3.setCode("ECOD3");
		ecod3.setEbitLastTwelveMonths(36273000l);
		ecod3.setAvailability(140252000l);
		ecod3.setMarketValue(717997000l);
		ecod3.setCurrentAssets(259032000l);
		stocks.add(ecod3);
		
		Stock geti41 = new Stock();
		geti41.setCode("GETI41");
		geti41.setEbitLastTwelveMonths(1219490000l);
		geti41.setAvailability(547472000l);
		geti41.setMarketValue(9226320000l);
		geti41.setCurrentAssets(905137000l);
		stocks.add(geti41);

		Stock petr4 = new Stock();
		petr4.setCode("PETR4");
		petr4.setEbitLastTwelveMonths(60372700000l);
		petr4.setAvailability(47291900000l);
		petr4.setMarketValue(320895000000l);
		petr4.setCurrentAssets(111415000000l);
		stocks.add(petr4);
				
		Stock geti4 = new Stock();
		geti4.setCode("GETI4");
		geti4.setEbitLastTwelveMonths(1219490000l);
		geti4.setAvailability(547472000l);
		geti4.setMarketValue(9226320000l);
		geti4.setCurrentAssets(905137000l);
		stocks.add(geti4);

		return stocks;
	}

	public static Ranking createSampleRanking() {
		Ranking ranking = new Ranking();
		ranking.setTitle("Meu ranking");
		return ranking;
	}

	public static RankingItem createSampleRankingItem() {
		Ranking ranking = new Ranking();
		ranking.setTitle("Meu ranking");
		
		Stock stock = new Stock();
		stock.setCode("ABCD2");
		
		RankingItem rankingItem = new RankingItem();
		rankingItem.setRankingPosition(172);
		rankingItem.setRanking(ranking);
		rankingItem.setStock(stock);
		
		return rankingItem;
	}

	public static Stock createSampleStock() {
		Stock stock = new Stock();
		stock.setCode("ABCD1");
		stock.setEbitLastTwelveMonths(36273000l);
		stock.setAvailability(140252000l);
		stock.setMarketValue(717997000l);
		stock.setCurrentAssets(259032000l);
		return stock;
	}
	
}
