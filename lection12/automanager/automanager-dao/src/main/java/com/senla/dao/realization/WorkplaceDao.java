package com.senla.dao.realization;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.senla.dao.api.IWorkplaceDao;
import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Workplace;

public class WorkplaceDao extends AbstractDao<Workplace> implements IWorkplaceDao {

	public WorkplaceDao() {
		super(Workplace.class);
	}

	private static final String ORDER_ALIAS = "order";
	private static final String FREE_PLACE_PATTERN = ORDER_ALIAS;
	
	
	@Override
	public Workplace getFreePlace(Session session) throws NoSuchDataException {
		Criteria criteria = session.createCriteria(returnClass()).add(Restrictions.isNull(FREE_PLACE_PATTERN));
		return (Workplace) criteria.setMaxResults(1).list().get(0);
	}

	@Override
	public void removeWorkPlace(Session session, int placeID) throws NoSuchDataException {
		Workplace tempObject = getById(session, new Integer(placeID));
		session.delete(tempObject);
		

	}

}