package com.senla.project.interfaces;

import com.senla.project.exceptions.NoSuchDataException;

import com.senla.project.model.Workplace;

public interface IWorkplaceService {
	
	void addWorkplace(Workplace workplace);
	
	void deleteWorkplace(Workplace workplace);
	
    Workplace findFreeWorkPlace() throws NoSuchDataException;

}
