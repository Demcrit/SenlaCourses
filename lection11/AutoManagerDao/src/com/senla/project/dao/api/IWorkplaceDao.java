package com.senla.project.dao.api;

import java.sql.Connection;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Workplace;


public interface IWorkplaceDao {
	void create(Connection connection);

	Workplace getFreePlace(Connection connection) throws NoSuchDataException;

	boolean removeWorkPlace(Connection connection,int placeID) throws NoSuchDataException;
}
