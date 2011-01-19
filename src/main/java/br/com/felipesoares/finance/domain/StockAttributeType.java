package br.com.felipesoares.finance.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FN_PAPEL_ATRIBUTO_TIPO")
public class StockAttributeType implements Serializable {
	
	private static final long serialVersionUID = -2056429756965786526L;
	
	@Id
	@Column(name="CD_PAPEL_ATRIBUTO_TIPO")
	protected String id;
	
	@Column(name="NM_NOME")
	protected String label;
	
	public String getId() {
		return id;
	}
	
	public String getLabel() {
		return label;
	}
}