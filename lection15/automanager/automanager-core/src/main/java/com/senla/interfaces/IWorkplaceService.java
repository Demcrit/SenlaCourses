package com.senla.interfaces;

import java.util.List;

import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Workplace;
import com.senla.model.enums.Sorting;

public interface IWorkplaceService {

	void addWorkplace(Workplace workplace);

	void deleteWorkplace(int workplaceId);

	Workplace findFreeWorkPlace() throws NoSuchDataException;

	List<Workplace> getWorkplaces(Sorting sort);

}
