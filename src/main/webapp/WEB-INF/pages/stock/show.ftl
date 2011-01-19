<html>
	<head>
		<title>Finance - ${stock.code}</title>
	</head>
	<body>
		<h1>${stock.code} - ${stock.companyName}</h1>
	
		<table>
			<tr>
				<td>Cotação:</td><td>R$${stock.quotation}</td>
				<td>&nbsp;</td>
				<td>Número de ações:</td><td>${stock.numberOfShares}</td>
			</tr>
			<tr>
				<td>Valor de mercado:</td><td>R$${stock.marketValue}</td>
				<td>&nbsp;</td>
				<td>Valor real:</td><td>R$${stock.realValue}</td>
			</tr>
			<tr>
				<td>Data do último balanço divulgado:</td><td>${stock.lastBalanceSheetDate}</td>
				<td>&nbsp;</td>
				<td>P/L:</td><td>${stock.p_l}</td>
			</tr>
			<tr>
				<td>P/VP:</td><td>${stock.p_vp}</td>
				<td>&nbsp;</td>
				<td>P/EBIT:</td><td>${stock.p_ebit}</td>
			</tr>
			<tr>
				<td>PSR:</td><td>${stock.psr}</td>
				<td>&nbsp;</td>
				<td>Preço / Ativos Totais:</td><td>${stock.p_assets}</td>
			</tr>
			<tr>
				<td>Preço / Capital de Giro:</td><td>${stock.p_workingCapital}</td>
				<td>&nbsp;</td>
				<td>% do lucro em dividendos:</td><td>${stock.dividendYield}</td>
			</tr>
			<tr>
				<td>EV / EBIT:</td><td>${stock.ev_ebit}</td>
				<td>&nbsp;</td>
				<td>Giro Ativos:</td><td>${stock.workingAssets}</td>
			</tr>
			<tr>
				<td>Crescimento (últ. 5 anos):</td><td>${stock.lastFiveYearsGrowth}</td>
				<td>&nbsp;</td>
				<td>LPA:</td><td>${stock.lpa}</td>
			</tr>
			<tr>
				<td>VPA:</td><td>${stock.vpa}</td>
				<td>&nbsp;</td>
				<td>Margem Bruta:</td><td>${stock.grossMargin}</td>
			</tr>
			<tr>
				<td>Margem EBIT:</td><td>${stock.ebitMargin}</td>
				<td>&nbsp;</td>
				<td>Margem Líquida:</td><td>${stock.netMargin}</td>
			</tr>
			<tr>
				<td>EBIT / Ativos:</td><td>${stock.ebit_assets}</td>
				<td>&nbsp;</td>
				<td>Preço / Ativo Circulante Líquido:</td><td>${stock.p_netCurrentAssets}</td>
			</tr>
			<tr>
				<td>ROIC:</td><td>${stock.roic}</td>
				<td>&nbsp;</td>
				<td>ROE:</td><td>${stock.roe}</td>
			</tr>
			<tr>
				<td>Liquidez corrente:</td><td>${stock.currentRatio}</td>
				<td>&nbsp;</td>
				<td>Dívida bruta / Patrimônio Líquido:</td><td>${stock.grossDebt_netWorth}</td>
			</tr>
			<tr>
				<td>Ativos totais:</td><td>R$${stock.totalAssets}</td>
				<td>&nbsp;</td>
				<td>Disponibilidades:</td><td>R$${stock.availability}</td>
			</tr>
			<tr>
				<td>Ativo circulante:</td><td>R$${stock.currentAssets}</td>
				<td>&nbsp;</td>
				<td>Dívida bruta:</td><td>R$${stock.grossDebt}</td>
			</tr>
			<tr>
				<td>Dívida líquida:</td><td>R$${stock.netDebt}</td>
				<td>&nbsp;</td>
				<td>Patrimônio líquido:</td><td>R$${stock.netWorth}</td>
			</tr>
			<tr>
				<td>Receita líquida (últ. 3 meses):</td><td>R$${stock.netLastThreeMonths}</td>
				<td>&nbsp;</td>
				<td>EBIT (últ. 3 meses):</td><td>R$${stock.ebitLastThreeMonths}</td>
			</tr>
			<tr>
				<td>Lucro líquido (últ. 3 meses):</td><td>R$${stock.netProfitLastThreeMonths}</td>
				<td>&nbsp;</td>
				<td>Receita líquida (últ. 12 meses):</td><td>R$${stock.netLastTwelveMonths}</td>
			</tr>
			<tr>
				<td>EBIT (últ. 12 meses):</td><td>R$${stock.ebitLastTwelveMonths}</td>
				<td>&nbsp;</td>
				<td>Lucro líquido (últ. 12 meses):</td><td>R$${stock.netProfitLastTwelveMonths}</td>
			</tr>
		</table>
		
	</body>
</html>