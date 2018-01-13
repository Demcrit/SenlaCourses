package com.senla.dao.realization;

import java.util.List;
import org.apache.log4j.*;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.senla.dao.api.IBaseDao;

public abstract class AbstractDao<T> implements IBaseDao <T>{
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
	public List<T> getAll(Session session, String... sortingColumn) {
		if (sortingColumn.length > 0) {
			return session.createCriteria(returnClass()).add(Restrictions.isNotNull(sortingColumn[0])).addOrder(Order.asc(sortingColumn[0])).list();
		}
		return session.createCriteria(returnClass()).list();
		}
	
	protected Class<T> returnClass(){
		return clazz;
}
}