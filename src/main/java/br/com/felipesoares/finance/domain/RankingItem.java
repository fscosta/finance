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
@Table(name="FN_ITEM_RANKING")
public class RankingItem implements Serializable {

	private static final long serialVersionUID = -8662353622100152090L;

	@Id
	@GeneratedValue(strategy=SEQUENCE, generator="itemRankingSequence")
	@SequenceGenerator(name="itemRankingSequence", sequenceName="FN_SEQ_ITEM_RANKING")
	@Column(name="CD_ITEM_RANKING", unique=true, nullable=false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="CD_PAPEL")
	private Stock stock;
	
	@ManyToOne
	@JoinColumn(name="CD_RANKING")
	private Ranking ranking;
	
	@Column(name="NR_POSICAO")
	private Integer rankingPosition;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Ranking getRanking() {
		return ranking;
	}

	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}

	public Integer getRankingPosition() {
		return rankingPosition;
	}

	public void setRankingPosition(Integer rankingPosition) {
		this.rankingPosition = rankingPosition;
	}
	
}
