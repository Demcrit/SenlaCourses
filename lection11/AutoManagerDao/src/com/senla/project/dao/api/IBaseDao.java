package com.senla.project.dao.api;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public interface IBaseDao<T> {

    List<T> getAll(Connection connection, String... sortingColumn);
	
	void create(Connection connection, T t) throws SQLException;
	
	void delete(Connection connection, Integer id) throws SQLException;
	
	T getById(Connection connection, Integer id);
	
	void update(Connection connection, T object) throws SQLException;
}
