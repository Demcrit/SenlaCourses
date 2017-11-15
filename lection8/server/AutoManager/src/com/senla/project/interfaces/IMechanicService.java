package com.senla.project.interfaces;

import java.util.List;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Mechanic;

public interface IMechanicService  {

	void addMechanic(Mechanic mechanic);

	void deleteMechanic(Mechanic mechanic);

	Mechanic findFreeMechanic();

	List<Mechanic> sortMechanicsByName();

	List<Mechanic> sortMechanicsByWork();

	public List<Mechanic> getAll();
	
	public boolean exportAll();
	public boolean importAll() throws NoSuchDataException;

	void setMechanics(List<Mechanic> mechanics);

	List<Mechanic> getMechanics();

	Mechanic getMechanic(int id) throws NoSuchDataException;

}
