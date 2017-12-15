package com.senla.project.dao.realization;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.senla.project.dao.api.IWorkplaceDao;
import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Workplace;

public class WorkplaceDao extends AbstractDao<Workplace> implements IWorkplaceDao {

	private static final String ID_WORKPLACE = "id_workplace";
	private static final String UPDATE_WORKPLACE = "update workplace set id_order=? where id_workplace=?";
	private static final String SELECT_WORKPLACE_BY_ID = "select * from workplace where id_workplace = ?";
	private static final String SELECT_ALL_FROM_WORKPLACE = "select * from workplace";
	private static final String REMOVE_WORKPLACE_IN_GARAGE = "delete from workplace where id_garage = ? and id_workplace = ?";
	private static final String REMOVE_WORKPLACE = "delete from workplace where id_workplace = ?";
	private static final String FREE_WORKPLACE = "select * from workplace where id_order is null limit 1";
	private static final String INSERT_WORKPLACE = "insert into workplace value (?)";

	@Override
	public void create(Connection connection) {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(INSERT_WORKPLACE);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOG.error(SQL_ERROR);
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
			}
		}

	}

	@Override
	public Workplace getFreePlace(Connection connection) throws NoSuchDataException {
		Statement statement = null;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(FREE_WORKPLACE);
			if (resultSet.next()) {
				return parseEntity(resultSet);
			} else {
				throw new NoSuchDataException();
			}
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
	public boolean removeWorkPlace(Connection connection, int placeID) throws NoSuchDataException {
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(REMOVE_WORKPLACE_IN_GARAGE);
			statement.setInt(1, placeID);
			if (statement.executeUpdate() == 0) {
				throw new NoSuchDataException();
			} else {
				return true;
			}
		} catch (SQLException e) {
			LOG.error(SQL_ERROR);
			return false;
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				LOG.error(e.getMessage(), e);
			}
		}
	}

	@Override
	protected String getByIdQuery() {
		return SELECT_WORKPLACE_BY_ID;
	}

	@Override
	protected String getInsertQuery() {
		return INSERT_WORKPLACE;
	}

	@Override
	protected String getDeleteQuery() {
		return REMOVE_WORKPLACE;
	}

	@Override
	protected String getAllQuery() {
		return SELECT_ALL_FROM_WORKPLACE;
	}

	@Override
	protected String getUpdateQuery() {
		return UPDATE_WORKPLACE;
	}

	@Override
	protected void prepareUpdateStatement(PreparedStatement statement, Workplace object) throws SQLException {
		statement.setInt(1, object.getOrder().getId());
		statement.setInt(2, object.getId());

	}

	@Override
	protected void prepareInsertStatement(PreparedStatement statement, Workplace object) throws SQLException {

	}

	@Override
	protected Workplace parseEntity(ResultSet resultSet) {
		try {
			Workplace temp = new Workplace();
			temp.setId(resultSet.getInt(ID_WORKPLACE));
			return temp;

		} catch (SQLException e) {
			return null;
		}
	}

}
