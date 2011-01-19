package br.com.felipesoares.finance.domain;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="FN_RANKING")
public class Ranking implements Serializable {

	private static final long serialVersionUID = -4215899709576745098L;

	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="rankingSequence")
	@SequenceGenerator(name="rankingSequence", sequenceName="FN_SEQ_RANKING")
	@Column(name = "CD_RANKING", unique = true, nullable = false)
	protected Long id;
	
	@Column(name = "NM_TITULO")
	protected String title;
	
	@Column(name = "DT_DATA")
	protected Date date;
	
	@OneToMany(mappedBy="ranking")
	protected List<RankingItem> items;

	@OneToMany(mappedBy = "ranking")
	protected List<SortingRule> sortingRules;
	
	@OneToMany(mappedBy = "ranking")
	protected List<Filter> filters;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<RankingItem> getItems() {
		return items;
	}

	public void setItems(List<RankingItem> items) {
		this.items = items;
	}
	
	public List<SortingRule> getSortingRules() {
		return sortingRules;
	}
}
