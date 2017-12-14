package com.senla.project.services;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;
import com.senla.project.dao.realization.MechanicDao;
import com.senla.project.dao.realization.OrderDao;
import com.senla.project.dao.realization.TaskDao;
import com.senla.project.dao.realization.WorkplaceDao;
import com.senla.project.dbconnector.DBAccess;
import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.injector.Inject;
import com.senla.project.interfaces.IOrderService;
import com.senla.project.model.Order;
import com.senla.project.model.Workplace;
import com.senla.project.model.enums.OrderStatus;

public class OrderService implements IOrderService {

	private OrderDao orderDAO = new OrderDao();
	private TaskDao taskDAO = new TaskDao();
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
			MechanicDao mechanicDAO = (MechanicDao) Inject.getClassInstance(MechanicDao.class);
			mechanicDAO.update(connection, order.getMechanic());
			WorkplaceDao workPlaceDAO = (WorkplaceDao) Inject.getClassInstance(WorkplaceDao.class);
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
	public void deleteOrder(int orderId) {
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
