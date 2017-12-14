package com.senla.project.dao.api;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class AbstractDao<T> {
	protected Logger LOG = LogManager.getLogger(AbstractDao.class);
	protected static final String SQL_ERROR = "SQL Error";

	protected abstract String getByIdQuery();
	protected abstract String getInsertQuery();
	protected abstract String getDeleteQuery();
	protected abstract String getAllQuery();
	protected abstract String getUpdateQuery();

	protected abstract void prepareUpdateStatement(PreparedStatement statement, T object) throws SQLException;

	protected abstract void prepareInsertStatement(PreparedStatement statement, T object) throws SQLException;

	protected abstract T parseEntity(ResultSet resultSet);

	public T getById(Connection connection, int id) {

		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(getByIdQuery());
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return parseEntity(rs);
			}
			return null;

		} catch (SQLException e) {
			LOG.error(SQL_ERROR);
			return null;
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				LOG.error(SQL_ERROR, e);
			}
		}
	}

	public void create(Connection connection, T object) {

		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(getInsertQuery());
			prepareInsertStatement(statement, object);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOG.error(SQL_ERROR);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				LOG.error(SQL_ERROR, e);
			}
		}
	}

	public void delete(Connection connection, int id) {

		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(getDeleteQuery());
			statement.setInt(1, id);
			if (statement.executeUpdate() == 0) {
						}
		} catch (SQLException e) {
			LOG.error(SQL_ERROR);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				LOG.error(SQL_ERROR, e);
			}
		}
	}

	public void update(Connection connection, T object) {

		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(getUpdateQuery());
			prepareUpdateStatement(statement, object);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOG.error(SQL_ERROR);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				LOG.error(SQL_ERROR, e);
			}
		}
	}

	public List<T> getAll(Connection connection, String... sortingColumn) {

		List<T> tempList = new ArrayList<>();
		Statement statement = null;
		try {
			statement = connection.createStatement();
			String query = (sortingColumn.length == 1) ? getAllQuery() + " order by " + sortingColumn[0]
					: getAllQuery();
			ResultSet resultSet = statement.executeQuery(query);
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
				LOG.error(SQL_ERROR, e);
			}
		}
	}
}
