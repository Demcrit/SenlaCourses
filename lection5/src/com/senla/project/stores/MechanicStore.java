package com.senla.project.stores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.senla.project.comparators.MechanicFullNameComparator;
import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Mechanic;
import static com.senla.project.utils.PrintUtil.*;

public class MechanicStore {
	private final static MechanicFullNameComparator MECHANIC_NAME_COMPARATOR = new MechanicFullNameComparator();
	private List<Mechanic> mechanics = new ArrayList<>();
	private int nextId;
	
	public void addMechanic(Mechanic mechanic) {
		mechanic.setId(nextId);
		nextId++;
		mechanics.add(mechanic);
	}

	public void deleteMechanic(Mechanic mechanic) {
		mechanics.remove(mechanic);
	}

	public Mechanic findFreeMechanic() {
		for (Mechanic mechanic : mechanics) {
			if (mechanic.getCurrenOrder() == null) {
				return mechanic;
			}
		}
		return null;
	}

	public List<Mechanic> getAllMechanics() {
		for (int i = 0; i < mechanics.size(); i++) {
			mechanics.get(i);
		}
		return mechanics;
	}

	public List<Mechanic> sortMechanicsByName() {
		List<Mechanic> list = new ArrayList<>(mechanics);
		Collections.sort(list, MECHANIC_NAME_COMPARATOR);
		printMessage("Sorted by name");
		return list;
	}

	public List<Mechanic> sortMechanicsByWork() {
		List<Mechanic> list = new ArrayList<>(mechanics);
		for (Mechanic mechanic : mechanics) {
			if (mechanic.getCurrenOrder() != null) {
				list.add(0,mechanic);
			} else {
				list.add(mechanic);
			}
			printMessage("Sorted by Work");
			return list;
		}
		return null;
	}

	public List<Mechanic> getAll() {
		return mechanics;
	}
	
	public Mechanic getMechanic(int id) throws NoSuchDataException {

		for (Mechanic mechanic : mechanics) {
			if (mechanic.getId() == id) {
				return mechanic;
			}
		}
		throw new NoSuchDataException();
	}

}
