package com.senla.interfaces;

import java.util.List;

import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Mechanic;
import com.senla.model.enums.Sorting;

public interface IMechanicService  {

	void addMechanic(String fullName);

	void deleteMechanic(int mechanicId);

	Mechanic findFreeMechanic() throws NoSuchDataException;

	List<Mechanic> sortMechanicsByName(Sorting sort);

	List<Mechanic> sortMechanicsByWork(Sorting sort);

	public List<Mechanic> getAll(Sorting sort);
	
	public boolean exportAll();
	
	public boolean importAll() throws NoSuchDataException;
	
	Mechanic getMechanic(int id) throws NoSuchDataException;
	
	Mechanic cloneMechanic(int id);

}
