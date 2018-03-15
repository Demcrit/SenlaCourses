package com.senla.dao.api;

public interface BaseDAO<T> {

	void add (T t);

	void update(T t);

	void delete(Long id);

	T getById(Long id);

}
