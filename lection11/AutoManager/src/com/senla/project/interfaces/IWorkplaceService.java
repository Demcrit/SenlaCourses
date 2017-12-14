package com.senla.project.interfaces;

import java.util.List;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Workplace;

public interface IWorkplaceService {

	void addWorkplace(Workplace workplace);

	void deleteWorkplace(int workplaceId);

	Workplace findFreeWorkPlace() throws NoSuchDataException;

	List<Workplace> getWorkplaces();

}
