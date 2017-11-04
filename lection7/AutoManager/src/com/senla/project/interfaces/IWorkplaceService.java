package com.senla.project.interfaces;

import java.util.List;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Workplace;

public interface IWorkplaceService {

	void addWorkplace(Workplace workplace);

	void deleteWorkplace(Workplace workplace);

	Workplace findFreeWorkPlace() throws NoSuchDataException;

	void setWorkplaces(List<Workplace> workplaces);

	List<Workplace> getWorkplaces();

}
