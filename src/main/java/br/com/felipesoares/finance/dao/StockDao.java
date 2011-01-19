package br.com.felipesoares.finance.dao;

import java.util.List;

import br.com.felipesoares.finance.domain.Stock;


public interface StockDao extends Dao<Stock> {

	List<Stock> findByCodes(List<String> ids);
	
}
