package com.senla.services;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.senla.dao.realization.MechanicDao;
import com.senla.interfaces.IMechanicService;
import com.senla.exceptions.NoSuchDataException;
import com.senla.hibernate.connector.DBAccess;
import com.senla.model.Mechanic;

public class MechanicService extends SessionAccess implements IMechanicService, Serializable {

	private static final long serialVersionUID = 1L;
	private MechanicDao mechanicDAO = new MechanicDao();
	    
	@Override
	public void addMechanic(String fullName) {
		Session session = null;

		try {
			session = getSession();
			session.beginTransaction();
			mechanicDAO.create(session, new Mechanic(fullName));
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();

		} finally {
			session.close();
		}
	}

	@Override
	public void deleteMechanic(int mechanicId) {
		Session session = null;
		Mechanic tempObject = null;

		try {
			session = getSession();
			session.beginTransaction();
			tempObject = mechanicDAO.getProxyById(session, new Integer(mechanicId));
			mechanicDAO.delete(session, tempObject);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();

		} finally {
			session.close();
		}
	}

	@Override
	public Mechanic findFreeMechanic() throws NoSuchDataException {
		Session session = null;
		Mechanic tempObject = null;
		try {
			session = getSession();
			session.beginTransaction();
			tempObject = mechanicDAO.findFreeMechanic(session);
			session.getTransaction().commit();
			return tempObject;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			return null;

		} finally {
			session.close();
		}
	}

	@Override
	public List<Mechanic> sortMechanicsByName() {
		Session session = null;
		List<Mechanic> tempList = null;

		try {
			session = getSession();
			session.beginTransaction();
			tempList = mechanicDAO.sortMechanicsByFullName(session);
			session.getTransaction().commit();
			return tempList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			return null;

		} finally {
			session.close();
		}
	}

	@Override
	public List<Mechanic> sortMechanicsByWork() {
		Session session = null;
		List<Mechanic> tempList = null;

		try {
			session = getSession();
			session.beginTransaction();
			tempList = mechanicDAO.sortMechanicsByWork(session);
			session.getTransaction().commit();
			return tempList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			return null;

		} finally {
			session.close();
		}
	}

	public List<Mechanic> getAll() {
		Session session = null;
		List<Mechanic> tempList = null;

		try {
			session = DBAccess.getInstance().getSessionFactory().openSession();
			session.beginTransaction();
			tempList = mechanicDAO.getAll(session);
			session.getTransaction().commit();
			return tempList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			return null;

		} finally {
			session.close();
		}
	}

	public Mechanic getMechanic(int id) throws NoSuchDataException {
		Session session = null;
		Mechanic tempObject = null;

		try {
			session = getSession();
			session.beginTransaction();
			tempObject = mechanicDAO.getById(session, id);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();

		} finally {
			session.close();
		}

		return tempObject;
	}

	@Override
	public boolean exportAll() {
				return false;
	}

	@Override
	public boolean importAll() throws NoSuchDataException {
		return false;
	}

}
