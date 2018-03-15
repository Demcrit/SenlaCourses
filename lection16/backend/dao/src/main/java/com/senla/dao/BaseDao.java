package com.senla.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.senla.dao.api.BaseDAO;
import com.senla.model.Base;

@Repository
public class BaseDao<T extends Base> implements BaseDAO<T> {

	@Autowired
	private SessionFactory sessionFactory;
	@SuppressWarnings("unused")
	private Class<T> clazz;

	public BaseDao() {

	}

	@SuppressWarnings("unchecked")
	public BaseDao(@SuppressWarnings("rawtypes") Class clazz) {
		this.clazz = clazz;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void add(T t) {
		getSession().save(t);
	}

	@Override
	public void update(T t) {
		getSession().update(t);
	}

	@Override
	public void delete(Long id) {
		@SuppressWarnings("unchecked")
		T object = (T) getSession().load(getClass(), id);
		getSession().delete(object);

	}

	@Override
	public T getById(Long id) {
		@SuppressWarnings("unchecked")
		T object = (T) getSession().load(getClass(), id);
		return object;
	}

}
