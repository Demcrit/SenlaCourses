package com.senla.project.dao.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.senla.project.dao.api.IOrderDao;
import com.senla.project.injector.Inject;
import com.senla.project.model.Order;
import com.senla.project.model.enums.OrderStatus;

public class OrderDao extends AbstractDao<Order> implements IOrderDao {

	private static final String ID_WORKPLACE = "id_workplace";
	private static final String FULL_NAME = "full_name";
	private static final String TO_DO = "to_do";
	private static final String ID_ORDER = "id_order";
	private static final String START_DATE = "start_date";
	private static final String REQUEST_DATE = "request_date";
	private static final String PRICE = "price";
	private static final String COMPLETE_DATE = "complete_date";
	private static final String SELECT_FROM_ORDER_STATUS = "select * from `order` where status = ?";
	private static final String UPDATE_ORDER_STATUS = "update `order` set id_mechanic=?, id_workplace=?, id_task=?, status=? where id_order=?";
	private static final String SELECT_ORDER_BY_ID = "select * from `order` where id_order = ?";
	private static final String SELECT_ALL_FROM_ORDER = "select * from `order` as o join task as t on o.id_task = t.id_task left join workplace as w on o.id_order = w.id_order left join mechanic as m on o.id_order = m.id_order";
	private static final String CREATE_ORDER = "insert into `order`(id_mechanic, id_workplace, id_task) value (?, ?, ?)";
	private static final String DELETE_ORDER = "delete from `order` where id_order = ?";

	@Override
	public List<Order> getAll(Connection connection, OrderStatus orderStatus) {
		List<Order> tempList = new ArrayList<>();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(SELECT_FROM_ORDER_STATUS);
			while (resultSet.next()) {
				tempList.add(parseEntity(resultSet));
			}
			return tempList;
		} catch (SQLException e) {
			LOG.error(SQL_ERROR);
			return null;
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
			}
		}
	}

	@Override
	public List<Order> sortOrdersByCompleteDateAction(Connection connection) {
		return getAll(connection, COMPLETE_DATE);
	}

	@Override
	public List<Order> sortOrdersByPriceAction(Connection connection) {
		return getAll(connection, PRICE);
	}

	@Override
	public List<Order> sortOrdersByRequestDateAction(Connection connection) {
		return getAll(connection, REQUEST_DATE);
	}

	@Override
	public List<Order> sortOrdersByStartDateAction(Connection connection) {
		return getAll(connection, START_DATE);
	}

	@Override
	protected String getByIdQuery() {
		return SELECT_ORDER_BY_ID;
	}

	@Override
	protected String getInsertQuery() {
		return CREATE_ORDER;
	}

	@Override
	protected String getDeleteQuery() {
		return DELETE_ORDER;
	}

	@Override
	protected String getAllQuery() {
		return SELECT_ALL_FROM_ORDER;
	}

	@Override
	protected String getUpdateQuery() {
		return UPDATE_ORDER_STATUS;
	}

	@Override
	protected void prepareUpdateStatement(PreparedStatement statement, Order object) throws SQLException {
		prepareInsertStatement(statement, object);
		statement.setString(4, object.getOrderstatus().toString());
		statement.setInt(5, object.getId());

	}

	@Override
	protected void prepareInsertStatement(PreparedStatement statement, Order object) throws SQLException {
		statement.setInt(1, object.getMechanic().getId());
		statement.setInt(2, object.getWorkplace().getId());
		statement.setInt(3, object.getTask().getId());

	}

	@Override
	protected Order parseEntity(ResultSet resultSet) {
		try {
			Order temp = new Order();
			temp.setId(resultSet.getInt(ID_ORDER));
			temp.setOrderstatus(OrderStatus.valueOf(resultSet.getString("status")));

			if (resultSet.findColumn(TO_DO) > 0) {
				TaskDao taskDAO = (TaskDao) Inject.getClassInstance(TaskDao.class);
				temp.setTask(taskDAO.parseEntity(resultSet));
			}

			if (resultSet.findColumn(FULL_NAME) > 0) {
				MechanicDao mechanicDAO = (MechanicDao) Inject.getClassInstance(MechanicDao.class);
				temp.setMechanic(mechanicDAO.parseEntity(resultSet));
			}

			if (resultSet.findColumn(ID_WORKPLACE) > 0) {
				WorkplaceDao workPlaceDAO = (WorkplaceDao) Inject.getClassInstance(WorkplaceDao.class);
				temp.setWorkplace(workPlaceDAO.parseEntity(resultSet));
			}

			return temp;
		} catch (SQLException e) {
			LOG.error(SQL_ERROR);
			return null;
		}
	}

}
