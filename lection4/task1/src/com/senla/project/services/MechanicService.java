package com.senla.project.services;

import java.util.List;

import com.senla.project.interfaces.IMechanicService;
import com.senla.project.model.Mechanic;
import com.senla.project.stores.MechanicStore;

public class MechanicService implements IMechanicService {

	private MechanicStore mechanicStore = new MechanicStore();

	@Override
	public void addMechanic(Mechanic mechanic) {
		mechanicStore.addMechanic(mechanic);

	}

	@Override
	public void deleteMechanic(Mechanic mechanic) {
		mechanicStore.deleteMechanic(mechanic);

	}

	@Override
	public Mechanic findFreeMechanic() {
		return mechanicStore.findFreeMechanic();
	}

	@Override
	public List<Mechanic> sortMechanicsByName() {
		return mechanicStore.sortMechanicsByName();
	}

	@Override
	public List<Mechanic> sortMechanicsByWork() {
		return mechanicStore.sortMechanicsByWork();
	}

	public List<Mechanic> getAll() {
		return mechanicStore.getAllMechanics();
	}

}
