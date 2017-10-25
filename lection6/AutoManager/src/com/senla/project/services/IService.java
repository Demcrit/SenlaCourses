package com.senla.project.services;

import java.util.List;

public interface IService<T> {
	
	    void add(T t);

	    String importAll();

	    String exportAll();

	    List<T> getAll();

	    T getById(Integer id);

}
