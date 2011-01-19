package br.com.felipesoares.finance.dao.hibernate;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.springframework.dao.support.DataAccessUtils;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class GenericDaoImpl<T> extends HibernateDaoSupport {

	private Class<T> persistentClass;

	public Integer count() {
		return DataAccessUtils.intResult(
					getHibernateTemplate().find(
							"select count(*) from " + getPersistentClass().getName()
					)
				);
	}

	public T findById(Serializable id) {
		return (T) getHibernateTemplate().get(getPersistentClass(), id);
	}
	
	public List<T> findAll() {
		return getHibernateTemplate().find( "from " + getPersistentClass().getName() );
	}

	public List<T> findByExample(T example) {
		return getHibernateTemplate().findByExample(example);
	}
	
	@Transactional
	public void save(T entity) {
		getHibernateTemplate().saveOrUpdate(entity);
	}
	
	@Transactional
	public void saveAll(List<T> entities) {
		getHibernateTemplate().saveOrUpdateAll(entities);
	}

	public void delete(T entity) {
		getHibernateTemplate().delete(entity);
	}
	
	public Class<T> getPersistentClass() {
		if ( persistentClass == null ) {
			this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		}
		
		return persistentClass;
	}
	
}
