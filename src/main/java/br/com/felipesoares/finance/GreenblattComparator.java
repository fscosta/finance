package br.com.felipesoares.finance;

import java.util.Comparator;

import br.com.felipesoares.finance.domain.Stock;

public class GreenblattComparator implements Comparator<Stock> {

	@Override
	public int compare(Stock stock1, Stock stock2) {
		Float comparisonResult = 0f;
		comparisonResult += (stock2.getEbitOverNetAssets() - stock1.getEbitOverNetAssets());
		comparisonResult += (stock2.getEbitOverEnterpriseValue() - stock1.getEbitOverEnterpriseValue());
		comparisonResult = comparisonResult * 100f;
		return comparisonResult.intValue();
	}
	
}