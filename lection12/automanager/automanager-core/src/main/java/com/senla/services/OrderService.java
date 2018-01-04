package com.senla.services;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.senla.dao.api.IOrderDao;
import com.senla.injector.Inject;
import com.senla.interfaces.IOrderService;
import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Order;
import com.senla.model.enums.OrderStatus;

public class OrderService extends SessionAccess implements IOrderService {

	private IOrderDao orderDAO = (IOrderDao) Inject.getClassInstance(IOrderDao.class);

	@Override
	public void addOrder(Order order) throws SQLException {
		Session session = null;

		try {
			session = getSession();
			session.beginTransaction();
			orderDAO.create(session, (Order) order);
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();

		} finally {
			session.close();
		}
	}

	@Override
	public void deleteOrder(int orderId) throws SQLException {
		Session session = null;

		try {
			session = getSession();
			session.beginTransaction();
			orderDAO.delete(session, orderDAO.getById(session, new Integer(orderId)));
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();

		} finally {
			session.close();
		}
	}

	@Override
	public List<Order> getOrders() {
		Session session = null;
		List<Order> tempList = null;

		try {
			session = getSession();
			session.beginTransaction();
			tempList = orderDAO.getAll(session);
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
	public List<Order> getOrdersByStatus(OrderStatus orderStatus) {
		Session session = null;
		List<Order> tempList = null;

		try {
			session = getSession();
			session.beginTransaction();
			tempList = orderDAO.getAll(session, orderStatus);
			session.getTransaction().commit();
			return tempList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}

	public Order getDirectOrder(int orderId) throws NoSuchDataException {
		Session session = null;
		Order tempObject = null;

		try {
			session = getSession();
			session.beginTransaction();
			orderDAO.getById(session, new Integer(orderId));
			session.getTransaction().commit();
			return tempObject;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			return null;

		} finally {
			session.close();
		}
	}

	public List<Order> sortOrdersByCompleteDateAction() {
		Session session = null;
		List<Order> tempList = null;

		try {
			session = getSession();
			session.beginTransaction();
			tempList = orderDAO.sortOrdersByCompleteDateAction(session);
			session.getTransaction().commit();
			return tempList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}

	public List<Order> sortOrdersByPriceAction() {
		Session session = null;
		List<Order> tempList = null;

		try {
			session = getSession();
			session.beginTransaction();
			tempList = orderDAO.sortOrdersByPriceAction(session);
			session.getTransaction().commit();
			return tempList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}

	public List<Order> sortOrdersByRequestDateAction() {
		Session session = null;
		List<Order> tempList = null;

		try {
			session = getSession();
			session.beginTransaction();
			tempList = orderDAO.sortOrdersByRequestDateAction(session);
			session.getTransaction().commit();
			return tempList;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			return null;
		} finally {
			session.close();
		}
	}

	public List<Order> sortOrdersByStartDateAction() {
		Session session = null;
		List<Order> tempList = null;

		try {
			session = getSession();
			session.beginTransaction();
			tempList = orderDAO.sortOrdersByStartDateAction(session);
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
