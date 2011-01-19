package br.com.felipesoares.finance.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.com.felipesoares.finance.dao.StockDao;
import br.com.felipesoares.finance.domain.Stock;

public class StockDaoImpl extends GenericDaoImpl<Stock> implements StockDao {

	public List<Stock> findByCodes(List<String> ids) {
		Criteria criteria = getSession().createCriteria(Stock.class);
		criteria.add( Restrictions.in("code", ids) );
		return criteria.list();
	}

}
