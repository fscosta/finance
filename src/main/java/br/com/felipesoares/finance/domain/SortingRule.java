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
@Table(name = "FN_ORDENACAO")
public class SortingRule implements Serializable {

	private static final long serialVersionUID = 4260808350429295166L;
	
	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="sortSequence")
	@SequenceGenerator(name="sortSequence", sequenceName="FN_SEQ_ORDENACAO")
	@Column(name = "CD_ORDENACAO", unique = true, nullable = false)
	protected Long id;
	
	@Column(name = "IN_ASCENDENTE")
	protected Boolean ascending;
	
	@ManyToOne
	@JoinColumn(name = "CD_RANKING")
	protected Ranking ranking;
	
	@ManyToOne
	@JoinColumn(name = "CD_PAPEL_ATRIBUTO_TIPO")
	protected StockAttributeType attributeType;
	
	public SortingRule() { }
	
	public SortingRule(StockAttributeType attributeType) {
		this.attributeType = attributeType;
	}
	
	public Long getId() {
		return id;
	}
	
	public StockAttributeType getAttributeType() {
		return attributeType;
	}
	
	public Boolean getAscending() {
		return ascending;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setAscending(Boolean ascending) {
		this.ascending = ascending;
	}
	
	public void setAttributeType(StockAttributeType attributeType) {
		this.attributeType = attributeType;
	}
	
}