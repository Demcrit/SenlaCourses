package com.senla.project.interfaces;

import java.util.List;
import com.senla.project.model.Mechanic;
import com.senla.project.services.IService;

public interface IMechanicService extends IService<Mechanic> {

	void addMechanic(Mechanic mechanic);

	void deleteMechanic(Mechanic mechanic);

	Mechanic findFreeMechanic();

	List<Mechanic> sortMechanicsByName();

	List<Mechanic> sortMechanicsByWork();

	public List<Mechanic> getAll();
}
