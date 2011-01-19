package br.com.felipesoares.finance.dao;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {

	Integer count();

	T findById(Serializable id);
	
	List<T> findAll();

	List<T> findByExample(T example);
	
	void save(T entity);
	
	void saveAll(List<T> entities);

	void delete(T entity);
	
	Class<T> getPersistentClass();

}
