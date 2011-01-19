package br.com.felipesoares.finance.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.tidy.Tidy;
import org.xml.sax.SAXException;

import br.com.felipesoares.finance.domain.Stock;

public class FundamentusParser {

	private static Log logger = LogFactory.getLog(FundamentusParser.class);
	protected FundamentusClient client;
	protected List<String> stocksHtml;
	
	public FundamentusParser() { }

	public FundamentusParser(List<String> stocksHtml) {
		this.stocksHtml = stocksHtml;
	}

	public List<Stock> getStocks(String[] stockcodes) {
		List<Stock> stocks = new ArrayList<Stock>();
		
		for (String htmlStock : stocksHtml) {
			
			try {
			 	Stock stock = parseHtml(htmlStock);

				if (stock != null)
					stocks.add(stock);
			} catch (XPathExpressionException e) {
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
		
		return stocks;
	}

	protected Stock parseHtml(String htmlStock) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException {
		ByteArrayInputStream bais = new ByteArrayInputStream(htmlStock.getBytes("UTF-8"));
		
		Tidy tidy = new Tidy();
		tidy.setXHTML(false); 
		tidy.setQuiet(true);
		tidy.setShowWarnings(false);
		Document document = tidy.parseDOM(bais, null);
		
		XPath xpath = XPathFactory.newInstance().newXPath();
		XPathExpression expression = 
			xpath.compile("//table/tr/td[@class='data' or @class='data w2' or @class='data w3' or @class='data w35' or @class='data w35' or @class='data destaque w3']/span/text()");
		
		Object result = expression.evaluate(document, XPathConstants.NODESET);
		
		return transform((NodeList) result); 
	}
	
	private Stock transform(NodeList nodes) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Stock stock = new Stock();
		
		try {
			stock.setCode(							nodes.item(0).getNodeValue());
			stock.setQuotation(						Float.parseFloat(nodes.item(1).getNodeValue().replaceAll(",", ".")));
			stock.setCompanyName(					nodes.item(4).getNodeValue());	
			stock.setMarketValue(					Long.parseLong(nodes.item(8).getNodeValue().replaceAll("\\.", "")));	
			stock.setLastBalanceSheetDate(			sdf.parse(nodes.item(9).getNodeValue()));	
			stock.setRealValue(						Long.parseLong(nodes.item(10).getNodeValue().replaceAll("\\.", "")));	
			stock.setNumberOfShares(				Long.parseLong(nodes.item(11).getNodeValue().replaceAll("\\.", "")));	
			stock.setP_l(							Float.parseFloat(nodes.item(12).getNodeValue().replaceAll(",", ".")));	
			stock.setLpa(							Float.parseFloat(nodes.item(13).getNodeValue().replaceAll(",", ".")));	
			stock.setP_vp(							Float.parseFloat(nodes.item(14).getNodeValue().replaceAll(",", ".")));	
			stock.setVpa(							Float.parseFloat(nodes.item(15).getNodeValue().replaceAll(",", ".")));
			stock.setP_ebit(						Float.parseFloat(nodes.item(16).getNodeValue().replaceAll(",", ".")));	
			stock.setGrossMargin(					Float.parseFloat(nodes.item(17).getNodeValue().replaceAll("%", "").replaceAll(",", ".")));	
			stock.setPsr(							Float.parseFloat(nodes.item(18).getNodeValue().replaceAll(",", ".")));	
			stock.setEbitMargin(					Float.parseFloat(nodes.item(19).getNodeValue().replaceAll("%", "").replaceAll(",", ".")));	
			stock.setP_assets(						Float.parseFloat(nodes.item(20).getNodeValue().replaceAll(",", ".")));	
			stock.setNetMargin(						Float.parseFloat(nodes.item(21).getNodeValue().replaceAll("%", "").replaceAll(",", ".")));	
			stock.setP_workingCapital(				Float.parseFloat(nodes.item(22).getNodeValue().replaceAll(",", ".")));
			stock.setEbit_assets(					Float.parseFloat(nodes.item(23).getNodeValue().replaceAll("%", "").replaceAll(",", ".")));	
			stock.setP_netCurrentAssets(			Float.parseFloat(nodes.item(24).getNodeValue().replaceAll(",", ".")));
			stock.setRoic(							Float.parseFloat(nodes.item(25).getNodeValue().replaceAll("%", "").replaceAll(",", ".")));	
			stock.setDividendYield(					Float.parseFloat(nodes.item(26).getNodeValue().replaceAll("%", "").replaceAll(",", ".")));	
			stock.setRoe(							Float.parseFloat(nodes.item(27).getNodeValue().replaceAll("%", "").replaceAll(",", ".")));	
			stock.setEv_ebit(						Float.parseFloat(nodes.item(28).getNodeValue().replaceAll(",", ".")));	
			stock.setCurrentRatio(					Float.parseFloat(nodes.item(29).getNodeValue().replaceAll(",", ".")));	
			stock.setWorkingAssets(					Float.parseFloat(nodes.item(30).getNodeValue().replaceAll(",", ".")));	
			stock.setGrossDebt_netWorth(			Float.parseFloat(nodes.item(31).getNodeValue().replaceAll(",", ".")));	
			stock.setLastFiveYearsGrowth(			Float.parseFloat(nodes.item(32).getNodeValue().replaceAll("%", "").replaceAll(",", ".")));	
			stock.setTotalAssets(					Long.parseLong(nodes.item(33).getNodeValue().replaceAll("\\.", "")));	
			stock.setGrossDebt(						Long.parseLong(nodes.item(34).getNodeValue().replaceAll("\\.", "")));	
			stock.setAvailability(					Long.parseLong(nodes.item(35).getNodeValue().replaceAll("\\.", "")));	
			stock.setNetDebt(						Long.parseLong(nodes.item(36).getNodeValue().replaceAll("\\.", "")));	
			stock.setCurrentAssets(					Long.parseLong(nodes.item(37).getNodeValue().replaceAll("\\.", "")));	
			stock.setNetWorth(						Long.parseLong(nodes.item(38).getNodeValue().replaceAll("\\.", "")));	
			stock.setNetLastTwelveMonths(			Long.parseLong(nodes.item(39).getNodeValue().replaceAll("\\.", "")));	
			stock.setNetLastThreeMonths(			Long.parseLong(nodes.item(40).getNodeValue().replaceAll("\\.", "")));	
			stock.setEbitLastTwelveMonths(			Long.parseLong(nodes.item(41).getNodeValue().replaceAll("\\.", "")));	
			stock.setEbitLastThreeMonths(			Long.parseLong(nodes.item(42).getNodeValue().replaceAll("\\.", "")));	
			stock.setNetProfitLastTwelveMonths(		Long.parseLong(nodes.item(43).getNodeValue().replaceAll("\\.", "")));	
			stock.setNetProfitLastThreeMonths(		Long.parseLong(nodes.item(44).getNodeValue().replaceAll("\\.", "")));	
		} catch (Exception e) {
			logger.error("Erro ao converter dados do papel", e);
			return null;
		}
		
		return stock;
	}
	
}
