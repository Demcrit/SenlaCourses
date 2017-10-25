package com.senla.project.services;

import java.io.Serializable;
import java.util.List;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.interfaces.IMechanicService;
import com.senla.project.model.Mechanic;
import com.senla.project.stores.MechanicStore;

public class MechanicService implements IMechanicService,Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	
	public Mechanic getMechanic(int id) throws NoSuchDataException {
		return mechanicStore.getMechanic(id);
	}

	@Override
	public void add(Mechanic t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String importAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String exportAll() {
		return mechanicStore.exportAll();
	}

	@Override
	public Mechanic getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
