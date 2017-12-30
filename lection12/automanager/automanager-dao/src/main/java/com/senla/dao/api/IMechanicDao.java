package com.senla.dao.api;

import java.sql.Connection;
import java.util.List;

import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Mechanic;

public interface IMechanicDao extends IBaseDao<Mechanic>{
	
	Mechanic findFreeMechanic(Connection connection) throws NoSuchDataException;

	List<Mechanic> sortMechanicsByFullName(Connection connection);

	List<Mechanic> sortMechanicsByWork(Connection connection);
}
