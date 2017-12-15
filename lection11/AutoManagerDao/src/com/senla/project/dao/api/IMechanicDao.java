package com.senla.project.dao.api;

import java.sql.Connection;
import java.util.List;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Mechanic;

public interface IMechanicDao extends IBaseDao<Mechanic>{
	
	Mechanic findFreeMechanic(Connection connection) throws NoSuchDataException;

	List<Mechanic> sortMechanicsByFullName(Connection connection);

	List<Mechanic> sortMechanicsByWork(Connection connection);
}
