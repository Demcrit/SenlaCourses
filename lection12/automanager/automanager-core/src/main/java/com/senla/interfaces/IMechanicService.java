package com.senla.interfaces;

import java.util.List;

import com.senla.exceptions.NoSuchDataException;
import com.senla.model.Mechanic;

public interface IMechanicService  {

	void addMechanic(String fullName);

	void deleteMechanic(int mechanicId);

	Mechanic findFreeMechanic() throws NoSuchDataException;

	List<Mechanic> sortMechanicsByName();

	List<Mechanic> sortMechanicsByWork();

	public List<Mechanic> getAll();
	
	public boolean exportAll();
	
	public boolean importAll() throws NoSuchDataException;
	
	Mechanic getMechanic(int id) throws NoSuchDataException;

}
