package com.senla.project.services;

import java.io.Serializable;
import java.util.List;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.interfaces.IMechanicService;
import com.senla.project.model.Mechanic;
import com.senla.project.stores.MechanicStore;

public class MechanicService implements IMechanicService, Serializable {

	private static final long serialVersionUID = 1L;
	private MechanicStore mechanicStore = new MechanicStore();

	@Override
	public void addMechanic(Mechanic mechanic) {
		synchronized (mechanicStore) {
			mechanicStore.addMechanic(mechanic);
		}
	}

	@Override
	public void deleteMechanic(Mechanic mechanic) {
		synchronized (mechanicStore) {
			mechanicStore.deleteMechanic(mechanic);
		}
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
		synchronized (mechanicStore) {
			return mechanicStore.getAllMechanics();
		}
	}

	public Mechanic getMechanic(int id) throws NoSuchDataException {
		synchronized (mechanicStore) {
			return mechanicStore.getMechanic(id);
		}
	}

	public List<Mechanic> getMechanics() {
		return mechanicStore.getMechanics();
	}

	public void setMechanics(List<Mechanic> mechanics) {
		mechanicStore.setMechanics(mechanics);
	}

	public boolean exportAll() {
		return mechanicStore.exportAll();
	}

	public boolean importAll() throws NoSuchDataException {
		return mechanicStore.importAll();
	}

}
