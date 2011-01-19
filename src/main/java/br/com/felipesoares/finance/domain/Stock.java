package br.com.felipesoares.finance.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FN_PAPEL")
public class Stock implements Serializable {

	// TODO: NÃO GUARDAR NO BANCO VALORES QUE PODEM SER CALCULADOS. CRIAR UM GETTER PARA CADA CASO.
	private static final long serialVersionUID = -7070826527175166000L;

	@Id
	@Column(name = "CD_PAPEL", unique = true, nullable = false)
	private String code;					// Código do papel
	
	@Column(name="NM_EMPRESA")
	private String companyName;			// Nome da empresa
	
	@Column(name="VL_COTACAO")
	private float quotation;				// Cotação atual
	
	@Column(name="NR_QUANTIDADE")
	private long numberOfShares;			// Número de ações
	
	@Column(name="VL_VALOR_MERCADO")
	private long marketValue;				// Valor da empresa no mercado
	
	@Column(name="VL_VALOR")
	private long realValue;				// Valor real da empresa
	
	@Column(name="DT_BALANCO")
	private Date lastBalanceSheetDate;	// Data do último balanço divulgado
	
	@Column(name="VL_PRECO_LUCRO")
	private float p_l;					// Preço / Lucro
	
	@Column(name="VL_PRECO_VALOR_PATRIMONIAL")
	private float p_vp;					// Preço / Valor Patrimonial
	
	@Column(name="VL_PRECO_EBITDA")
	private float p_ebit;					// Preço / EBITDA
	
	@Column(name="VL_PSR")
	private float psr;					// Price Sales Ration
	
	@Column(name="VL_PRECO_ATIVOS")
	private float p_assets;				// Preço / Ativos Totais
	
	@Column(name="VL_PRECO_GIRO")
	private float p_workingCapital;		// Preço / Capital de Giro
	
	@Column(name="VL_DIVIDEND_YIELD")
	private float dividendYield;			// % do Lucro em dividendos
	
	@Column(name="VL_EV_EBTIDA")
	private float ev_ebit;				// Enterprise Value / EBITDA
	
	@Column(name="VL_GIRO_ATIVOS")
	private float workingAssets;			// Giro Ativos (Receita Líquida / Ativos Totais)
	
	@Column(name="VL_CRESCIMENTO")
	private float lastFiveYearsGrowth;	// Crescimento nos últimos 5 anos
	
	@Column(name="VL_LPA")
	private float lpa;					// Lucro por Ação
	
	@Column(name="VL_VPA")
	private float vpa;					// Valor Patrimonial por Ação
	
	@Column(name="VL_MARGEM_BRUTA")
	private float grossMargin;			// Margem Bruta
	
	@Column(name="VL_MARGEM_EBTIDA")
	private float ebitMargin;				// Margem EBITDA
	
	@Column(name="VL_MARGEM_LIQUIDA")
	private float netMargin;				// Margem Líquida
	
	@Column(name="VL_EBTIDA_ATIVOS")
	private float ebit_assets;			// EBITDA / Ativos
	
	@Column(name="VL_PRECO_ATIVO_CIRCULANTE")
	private float p_netCurrentAssets;		// Preço / Ativo Circulante Líquido
	
	@Column(name="VL_ROIC")
	private float roic;					// Retorno Sobre Captial Investido (Return Over Invested Capital)
	
	@Column(name="VL_ROE")
	private float roe;					// Retorno Sobre o Patrimônio Líquido
	
	@Column(name="VL_LIQUIDEZ")
	private float currentRatio;			// Liquidez corrente

	@Column(name="VL_DIV_BRUTA_PATR_LIQ")
	private float grossDebt_netWorth;		// Dívida Bruta / Patrimônio Líquido
	
	@Column(name="VL_ATIVOS")
	private long totalAssets;				// Ativos totais
	
	@Column(name="VL_DISPONIBILIDADES")
	private long availability;			// Disponibilidades (dinheiro)
	
	@Column(name="VL_ATIVO_CIRCULANTE")
	private long currentAssets;			// Ativo Circulante
	
	@Column(name="VL_DIVIDA_BRUTA")
	private long grossDebt;				// Dívida Bruta
	
	@Column(name="VL_DIVIDA_LIQUIDA")
	private long netDebt;					// Dívida Líquida
	
	@Column(name="VL_PATRIMONIO_LIQUIDO")
	private long netWorth;				// Patrimônio Líquido
	
	@Column(name="VL_RECEITA_LIQ_3_MESES")
	private long netLastThreeMonths;		// Receita Líquida dos últimos 3 meses
	
	@Column(name="VL_EBITDA_3_MESES")
	private long ebitLastThreeMonths;		// EBITDA dos últimos 3 meses
	
	@Column(name="VL_LUCRO_LIQ_3_MESES")
	private long netProfitLastThreeMonths;	// Lucro líquido dos últimos 3 meses

	@Column(name="VL_RECEITA_LIQ_12_MESES")
	private long netLastTwelveMonths;		// Receita Líquida dos últimos 12 meses
	
	@Column(name="VL_EBITDA_12_MESES")
	private long ebitLastTwelveMonths;		// EBITDA dos últimos 12 meses
	
	@Column(name="VL_LUCRO_LIQ_12_MESES")
	private long netProfitLastTwelveMonths;	// Lucro líquido dos últimos 12 meses
	
	public float getEbitOverNetAssets() {
		return new Float(this.ebitLastTwelveMonths) / new Float( this.currentAssets + this.availability );
	}
	
	public float getEbitOverEnterpriseValue() {
		return new Float(this.ebitLastTwelveMonths) / new Float(this.marketValue);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public float getQuotation() {
		return quotation;
	}

	public void setQuotation(float quotation) {
		this.quotation = quotation;
	}

	public long getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(long numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public long getMarketValue() {
		return marketValue;
	}

	public void setMarketValue(long marketValue) {
		this.marketValue = marketValue;
	}

	public long getRealValue() {
		return realValue;
	}

	public void setRealValue(long realValue) {
		this.realValue = realValue;
	}

	public Date getLastBalanceSheetDate() {
		return lastBalanceSheetDate;
	}

	public void setLastBalanceSheetDate(Date lastBalanceSheetDate) {
		this.lastBalanceSheetDate = lastBalanceSheetDate;
	}

	public float getP_l() {
		return p_l;
	}

	public void setP_l(float p_l) {
		this.p_l = p_l;
	}

	public float getP_vp() {
		return p_vp;
	}

	public void setP_vp(float p_vp) {
		this.p_vp = p_vp;
	}

	public float getP_ebit() {
		return p_ebit;
	}

	public void setP_ebit(float p_ebit) {
		this.p_ebit = p_ebit;
	}

	public float getPsr() {
		return psr;
	}

	public void setPsr(float psr) {
		this.psr = psr;
	}

	public float getP_assets() {
		return p_assets;
	}

	public void setP_assets(float p_assets) {
		this.p_assets = p_assets;
	}

	public float getP_workingCapital() {
		return p_workingCapital;
	}

	public void setP_workingCapital(float p_workingCapital) {
		this.p_workingCapital = p_workingCapital;
	}

	public float getDividendYield() {
		return dividendYield;
	}

	public void setDividendYield(float dividendYield) {
		this.dividendYield = dividendYield;
	}

	public float getEv_ebit() {
		return ev_ebit;
	}

	public void setEv_ebit(float ev_ebit) {
		this.ev_ebit = ev_ebit;
	}

	public float getWorkingAssets() {
		return workingAssets;
	}

	public void setWorkingAssets(float workingAssets) {
		this.workingAssets = workingAssets;
	}

	public float getLastFiveYearsGrowth() {
		return lastFiveYearsGrowth;
	}

	public void setLastFiveYearsGrowth(float lastFiveYearsGrowth) {
		this.lastFiveYearsGrowth = lastFiveYearsGrowth;
	}

	public float getLpa() {
		return lpa;
	}

	public void setLpa(float lpa) {
		this.lpa = lpa;
	}

	public float getVpa() {
		return vpa;
	}

	public void setVpa(float vpa) {
		this.vpa = vpa;
	}

	public float getGrossMargin() {
		return grossMargin;
	}

	public void setGrossMargin(float grossMargin) {
		this.grossMargin = grossMargin;
	}

	public float getEbitMargin() {
		return ebitMargin;
	}

	public void setEbitMargin(float ebitMargin) {
		this.ebitMargin = ebitMargin;
	}

	public float getNetMargin() {
		return netMargin;
	}

	public void setNetMargin(float netMargin) {
		this.netMargin = netMargin;
	}

	public float getEbit_assets() {
		return ebit_assets;
	}

	public void setEbit_assets(float ebit_assets) {
		this.ebit_assets = ebit_assets;
	}

	public float getP_netCurrentAssets() {
		return p_netCurrentAssets;
	}

	public void setP_netCurrentAssets(float p_netCurrentAssets) {
		this.p_netCurrentAssets = p_netCurrentAssets;
	}

	public float getRoic() {
		return roic;
	}

	public void setRoic(float roic) {
		this.roic = roic;
	}

	public float getRoe() {
		return roe;
	}

	public void setRoe(float roe) {
		this.roe = roe;
	}

	public float getCurrentRatio() {
		return currentRatio;
	}

	public void setCurrentRatio(float currentRatio) {
		this.currentRatio = currentRatio;
	}

	public float getGrossDebt_netWorth() {
		return grossDebt_netWorth;
	}

	public void setGrossDebt_netWorth(float grossDebt_netWorth) {
		this.grossDebt_netWorth = grossDebt_netWorth;
	}

	public long getTotalAssets() {
		return totalAssets;
	}

	public void setTotalAssets(long totalAssets) {
		this.totalAssets = totalAssets;
	}

	public long getAvailability() {
		return availability;
	}

	public void setAvailability(long availability) {
		this.availability = availability;
	}

	public long getCurrentAssets() {
		return currentAssets;
	}

	public void setCurrentAssets(long currentAssets) {
		this.currentAssets = currentAssets;
	}

	public long getGrossDebt() {
		return grossDebt;
	}

	public void setGrossDebt(long grossDebt) {
		this.grossDebt = grossDebt;
	}

	public long getNetDebt() {
		return netDebt;
	}

	public void setNetDebt(long netDebt) {
		this.netDebt = netDebt;
	}

	public long getNetWorth() {
		return netWorth;
	}

	public void setNetWorth(long netWorth) {
		this.netWorth = netWorth;
	}

	public long getNetLastThreeMonths() {
		return netLastThreeMonths;
	}

	public void setNetLastThreeMonths(long netLastThreeMonths) {
		this.netLastThreeMonths = netLastThreeMonths;
	}

	public long getEbitLastThreeMonths() {
		return ebitLastThreeMonths;
	}

	public void setEbitLastThreeMonths(long ebitLastThreeMonths) {
		this.ebitLastThreeMonths = ebitLastThreeMonths;
	}

	public long getNetProfitLastThreeMonths() {
		return netProfitLastThreeMonths;
	}

	public void setNetProfitLastThreeMonths(long netProfitLastThreeMonths) {
		this.netProfitLastThreeMonths = netProfitLastThreeMonths;
	}

	public long getNetLastTwelveMonths() {
		return netLastTwelveMonths;
	}

	public void setNetLastTwelveMonths(long netLastTwelveMonths) {
		this.netLastTwelveMonths = netLastTwelveMonths;
	}

	public long getEbitLastTwelveMonths() {
		return ebitLastTwelveMonths;
	}

	public void setEbitLastTwelveMonths(long ebitLastTwelveMonths) {
		this.ebitLastTwelveMonths = ebitLastTwelveMonths;
	}

	public long getNetProfitLastTwelveMonths() {
		return netProfitLastTwelveMonths;
	}

	public void setNetProfitLastTwelveMonths(long netProfitLastTwelveMonths) {
		this.netProfitLastTwelveMonths = netProfitLastTwelveMonths;
	}

	@Override
	public String toString() {
		return this.code;
	}

}
