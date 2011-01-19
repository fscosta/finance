package br.com.felipesoares.finance.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "FN_FILTRO")
public class Filter implements Serializable {

	private static final long serialVersionUID = 510264424615446236L;

	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="filterSequence")
	@SequenceGenerator(name="filterSequence", sequenceName="FN_SEQ_FILTRO")
	@Column(name = "CD_FILTRO", unique = true, nullable = false)
	protected Long id;
	
	@Column(name = "NM_OPERADOR")
	protected String operator;	// 0: 'Menor que' e 1: 'Maior que'
	
	@Column(name = "NM_LIMITE")
	protected String threshold;
	
	@ManyToOne
	@JoinColumn(name = "CD_RANKING")
	protected Ranking ranking;
	
	@ManyToOne
	@JoinColumn(name = "CD_PAPEL_ATRIBUTO_TIPO")
	protected StockAttributeType attributeType;
	
	public Filter() { }

	public Filter(StockAttributeType attributeType) {
		this.attributeType = attributeType;
	}

	public Long getId() {
		return id;
	}
	
	public StockAttributeType getAttributeType() {
		return attributeType;
	}
	
	public String getOperator() {
		return operator;
	}
	
	public String getThreshold() {
		return threshold;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setAttributeType(StockAttributeType attributeType) {
		this.attributeType = attributeType;
	}
	
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}
	
}