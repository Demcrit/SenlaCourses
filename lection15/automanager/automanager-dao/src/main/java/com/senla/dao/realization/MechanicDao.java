package com.senla.dao.realization;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.senla.dao.api.IMechanicDao;
import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Mechanic;

public class MechanicDao extends AbstractDao<Mechanic> implements IMechanicDao {

	public MechanicDao() {
		super(Mechanic.class);
		}

	private static final String ID_ORDER = "currentOrder";
	private static final String FULL_NAME = "fullName";
	
	@Override
	public Mechanic findFreeMechanic(Session session) throws NoSuchDataException {
		Criteria criteria = session.createCriteria(returnClass()).add(Restrictions.isNull("currentOrder"));
		return (Mechanic) criteria.setMaxResults(1).list().get(0);
	}

	@Override
	public List<Mechanic> sortMechanicsByFullName(Session session) {
		return getAll(session, FULL_NAME);
	}

	@Override
	public List<Mechanic> sortMechanicsByWork(Session session) {
		return getAll(session, ID_ORDER);
	}

	
}
