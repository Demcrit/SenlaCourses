package com.senla.dao.realization;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.senla.dao.api.ITaskDao;
import com.senla.dao.util.DateParser;
import com.senla.model.Task;

public class TaskDao extends AbstractDao<Task> implements ITaskDao {
	private static final String PRICE = "price";
	private static final String COMPLETE_DATE = "complete_date";
	private static final String START_DATE = "start_date";
	private static final String REQUEST_DATE = "request_date";
	private static final String TO_DO = "to_do";
	private static final String ID_TASK = "id_task";
	private static final String UPDATE_TASK = "update task set to_do=?, request_date=?, start_date=?, complete_date=?, price=? where id_task=?";
	private static final String INSERT_INTO_TASK = "insert into task(to_do, request_date, start_date, complete_date, price) value (?, now(), ?, ?, ?)";
	private static final String SELECT_FROM_TASK_BY_ID = "select * from task where id_task = ?";
	private static final String DELETE_TASK_BY_ID = "delete from task where id_task = ?";
	private static final String SELECT_ALL_FROM_TASK = "select * from task";

	@Override
	protected String getByIdQuery() {
		return SELECT_FROM_TASK_BY_ID;
	}

	@Override
	protected String getInsertQuery() {
		return INSERT_INTO_TASK;
	}

	@Override
	protected String getDeleteQuery() {
		return DELETE_TASK_BY_ID;
	}

	@Override
	protected String getAllQuery() {
		return SELECT_ALL_FROM_TASK;
	}

	@Override
	protected String getUpdateQuery() {
		return UPDATE_TASK;
	}
	
	@Override
	protected Task parseEntity(ResultSet resultSet) {
		try {
			return new Task(resultSet.getInt(ID_TASK), resultSet.getString(TO_DO), resultSet.getDate(REQUEST_DATE),
					resultSet.getDate(START_DATE), resultSet.getDate(COMPLETE_DATE), resultSet.getDouble(PRICE));
		} catch (SQLException e) {
			LOG.error(SQL_ERROR);
			return null;
		}
	}

	@Override
	protected void prepareUpdateStatement(PreparedStatement statement, Task object) throws SQLException {
		statement.setString(1, object.getCommonTask());
		statement.setString(2, DateParser.generateStringFromDate(object.getOrderDate()));
		statement.setString(3, DateParser.generateStringFromDate(object.getStartDate()));
		statement.setString(4, DateParser.generateStringFromDate(object.getEndDate()));
		statement.setDouble(5, object.getPrice());
		statement.setInt(6, object.getId());

	}

	@Override
	protected void prepareInsertStatement(PreparedStatement statement, Task object) throws SQLException {
		statement.setString(1, object.getCommonTask());
		statement.setString(2, DateParser.generateStringFromDate(object.getStartDate()));
		statement.setString(3, DateParser.generateStringFromDate(object.getEndDate()));
		statement.setDouble(4, object.getPrice());

	}

	
}
