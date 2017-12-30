package com.senla.dao.api;

import java.sql.Connection;

import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Workplace;

public interface IWorkplaceDao extends IBaseDao<Workplace>{
	
	void create(Connection connection);

	Workplace getFreePlace(Connection connection) throws NoSuchDataException;

	boolean removeWorkPlace(Connection connection,int placeID) throws NoSuchDataException;
}
