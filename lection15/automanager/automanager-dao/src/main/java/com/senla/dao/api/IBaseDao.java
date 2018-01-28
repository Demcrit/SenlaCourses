package com.senla.dao.api;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import com.senla.model.enums.Sorting;

public interface IBaseDao<T> {

    List<T> getAll(Session session,Sorting sort);
	
	void create(Session session, T t) throws SQLException;
	
	void delete(Session session, T object) throws SQLException;
	
	T getById(Session session, Integer id);
	
	void update(Session session, T object) throws SQLException;
}
