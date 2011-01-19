package br.com.felipesoares.finance.client;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

public class FundamentusClient {

	private static Log LOGGER = LogFactory.getLog(FundamentusClient.class); 
	private String baseURL = "http://www.fundamentus.com.br/detalhes.php?papel=";
	
	public List<String> downloadHtml(String[] stockcodes) {
		HttpParams params = new BasicHttpParams();
		HttpClient httpClient = new DefaultHttpClient(params);
		List<String> stocksHtml = new ArrayList<String>();
		
		for (String stockcode : stockcodes) {
			
			try {
				HttpGet httpget = new HttpGet(baseURL + stockcode);
				HttpResponse response = httpClient.execute(httpget);
				HttpEntity entity = response.getEntity();
				
				if (entity != null) {
					String html = EntityUtils.toString(entity);
					stocksHtml.add(html);
					LOGGER.debug("Recuperando HTML do papel " + stockcode + " ...");
				}
				
			} catch (Exception e) {
				LOGGER.error("Erro ao recuperar HTML do papel " + stockcode, e);
			}
				
		}
			
		return stocksHtml;
	}
	
}
