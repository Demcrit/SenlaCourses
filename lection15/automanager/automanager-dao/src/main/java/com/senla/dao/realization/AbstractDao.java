package com.senla.dao.realization;

import java.util.List;
import org.apache.log4j.*;
import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;

import com.senla.dao.api.IBaseDao;
import com.senla.model.enums.Sorting;

public abstract class AbstractDao<T> implements IBaseDao<T> {
	protected Logger LOG = LogManager.getLogger(AbstractDao.class);

	protected Class<T> clazz;

	public AbstractDao(Class<T> clazz) {
		this.clazz = clazz;
	}

	@SuppressWarnings("unchecked")
	public T getById(Session session, Integer id) {
		return (T) session.get(returnClass(), id);
	}

	public void create(Session session, T object) {
		session.save(object);
	}

	public void delete(Session session, T object) {
		session.delete(object);
	}

	public void update(Session session, T object) {
		session.update(object);
	}

	@SuppressWarnings("unchecked")
	public T getProxyById(Session session, Integer id) throws ObjectNotFoundException {
		return (T) session.load(returnClass(), id);
	}

	@SuppressWarnings("unchecked")
	public List<T> getAll(Session session, Sorting sort) {
		Criteria criteria = session.createCriteria(clazz).addOrder(Order.asc(sort.toString()));
		return criteria.list();

	}

	protected Class<T> returnClass() {
		return clazz;
	}
}