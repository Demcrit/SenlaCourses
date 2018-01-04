package com.senla.dao.api;

import java.util.List;

import org.hibernate.Session;

import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Mechanic;

public interface IMechanicDao extends IBaseDao<Mechanic>{
	
	Mechanic findFreeMechanic(Session session) throws NoSuchDataException;

	List<Mechanic> sortMechanicsByFullName(Session session);

	List<Mechanic> sortMechanicsByWork(Session session);
}
