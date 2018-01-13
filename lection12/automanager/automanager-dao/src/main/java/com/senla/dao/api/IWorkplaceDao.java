package com.senla.dao.api;

import org.hibernate.Session;
import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Workplace;

public interface IWorkplaceDao extends IBaseDao<Workplace>{
	
	Workplace getFreePlace(Session session) throws NoSuchDataException;

	void removeWorkPlace(Session session,int placeID) throws NoSuchDataException;
}
