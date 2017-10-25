package com.senla.project.interfaces;

import com.senla.project.exceptions.NoSuchDataException;

import com.senla.project.model.Workplace;
import com.senla.project.services.IService;

public interface IWorkplaceService extends IService<Workplace> {
	
	void addWorkplace(Workplace workplace);
	
	void deleteWorkplace(Workplace workplace);
	
    Workplace findFreeWorkPlace() throws NoSuchDataException;

}
