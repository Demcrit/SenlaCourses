package com.senla.project.interfaces;

import java.util.List;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Mechanic;

public interface MechanicService {

	void addMechanic(Mechanic mechanic);
	void deleteMechanic(Mechanic mechanic);
	Mechanic showMechanic(int id) throws NoSuchDataException;
	Mechanic findFreeMechanic();
	void getAllMechanics();
	List <Mechanic> sortMechanicsByName();
	List <Mechanic> sortMechanicsByWork();
}
