package com.senla.project.stores;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static com.senla.project.model.constants.Constants.*;
import com.senla.project.model.Mechanic;
import static com.senla.project.utils.PrintUtil.*;

public class MechanicStore {

	private List<Mechanic> mechanics = new ArrayList<>();

	public void addMechanic(Mechanic mechanic) {
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
			printObject(mechanics.get(i));
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
				list.add(mechanic);
			} else {
				list.add(mechanic);
			}
			printMessage("Sorted by Work");
			return list;
		}
		return null;
	}
	
	public List<Mechanic> getAll(){
		return mechanics;
	}

}
