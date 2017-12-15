package com.senla.project.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;
import com.senla.project.dao.api.IMechanicDao;
import com.senla.project.dao.api.IOrderDao;
import com.senla.project.dao.api.ITaskDao;
import com.senla.project.dao.api.IWorkplaceDao;
import com.senla.project.dbconnector.DBAccess;
import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.injector.Inject;
import com.senla.project.interfaces.IOrderService;
import com.senla.project.model.Order;
import com.senla.project.model.Workplace;
import com.senla.project.model.enums.OrderStatus;

public class OrderService implements IOrderService {

	private IOrderDao orderDAO = (IOrderDao) Inject.getClassInstance(IOrderDao.class);
	private ITaskDao taskDAO = (ITaskDao) Inject.getClassInstance(ITaskDao.class);
	private IMechanicDao mechanicDAO = (IMechanicDao) Inject.getClassInstance(IMechanicDao.class);
	private IWorkplaceDao workPlaceDAO = (IWorkplaceDao) Inject.getClassInstance(IWorkplaceDao.class);
	private DBAccess dbAccess;

	@Override
	public void addOrder(Order order) {
		Connection connection = dbAccess.getConnection();
		Savepoint savepoint = null;
		try {
			connection.setAutoCommit(false);
			savepoint = connection.setSavepoint();
			orderDAO.update(connection, (Order) order);
			taskDAO.create(connection, order.getTask());
			mechanicDAO.update(connection, order.getMechanic());
			workPlaceDAO.update(connection, (Workplace) order.getWorkplace());
			connection.commit();
			connection.setAutoCommit(true);
		} catch (SQLException e) {
			try {
				connection.rollback(savepoint);
			} catch (SQLException e1) {
			}
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
			}
		}
	}

	@Override
	public void deleteOrder(int orderId) throws SQLException {
		synchronized (orderDAO) {
			orderDAO.delete(dbAccess.getConnection(), orderId);
		}
	}

	@Override
	public List<Order> getOrders() {
		synchronized (orderDAO) {
			return orderDAO.getAll(dbAccess.getConnection());
		}
	}

	@Override
	public List<Order> getOrdersByStatus(OrderStatus orderStatus) {
		return orderDAO.getAll(dbAccess.getConnection(), orderStatus);
	}

	public Order getDirectOrder(int orderId) throws NoSuchDataException {
		synchronized (orderDAO) {
			return orderDAO.getById(dbAccess.getConnection(), orderId);
		}
	}

	public List<Order> sortOrdersByCompleteDateAction() {
		return orderDAO.sortOrdersByCompleteDateAction(dbAccess.getConnection());
	}

	public List<Order> sortOrdersByPriceAction() {
		return orderDAO.sortOrdersByPriceAction(dbAccess.getConnection());
	}

	public List<Order> sortOrdersByRequestDateAction() {
		return orderDAO.sortOrdersByRequestDateAction(dbAccess.getConnection());
	}

	public List<Order> sortOrdersByStartDateAction() {
		return orderDAO.sortOrdersByStartDateAction(dbAccess.getConnection());
	}
}
