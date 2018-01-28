package com.senla.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.senla.dao.realization.WorkplaceDao;
import com.senla.interfaces.IWorkplaceService;
import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Workplace;
import com.senla.model.enums.Sorting;

public class WorkplaceService extends SessionAccess implements IWorkplaceService {

	private WorkplaceDao workplaceDAO = new WorkplaceDao();
	
	@Override
	public void addWorkplace(Workplace workplace) {
		Session session = null;

		try {
			session = getSession();
			session.beginTransaction();
			workplaceDAO.create(session, new Workplace());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();

		} finally {
			session.close();
		}
	}

	@Override
	public void deleteWorkplace(int workplaceId) {
		Session session = null;
		Workplace tempObject = null;

		try {
			session = getSession();
			session.beginTransaction();
			tempObject = workplaceDAO.getProxyById(session, new Integer(workplaceId));
			workplaceDAO.delete(session, tempObject);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();

		} finally {
			session.close();
		}
	}

	@Override
	public Workplace findFreeWorkPlace() throws NoSuchDataException {
		Session session = null;
		Workplace tempObject = null;

		try {
			session = getSession();
			session.beginTransaction();
			tempObject = workplaceDAO.getFreePlace(session);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();

		} finally {
			session.close();
		}

		return tempObject;
	}

	@Override
	public List<Workplace> getWorkplaces(Sorting sort) {
		Session session = null;
		List<Workplace> tempList = null;

		try {
			session = getSession();
			session.beginTransaction();
			tempList = workplaceDAO.getAll(session,sort);
			session.getTransaction().commit();
			return tempList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			return null;

		} finally {
			session.close();
		}
		
	}

}
