package com.senla.project.stores;

import java.util.List;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Workplace;

public class WorkplaceStore {
	private int nextId;
	private List<Workplace> workplaces;

	public List<Workplace> getWorkplaces() {
		return workplaces;
	}

	public void setWorkplaces(List<Workplace> workplaces) {
		this.workplaces = workplaces;
	}

	public void addWorkplace(Workplace workplace) {
		workplace.setId(nextId);
		nextId++;
		workplaces.add(workplace);
	}

	public void deleteWorkplace(Workplace workplace) {
		workplaces.remove(workplace);

	}

	public Workplace findFreeWorkPlace() throws NoSuchDataException {

		for (Workplace workplace : workplaces) {
			if (workplace.getOrder() == null) {
				return workplace;
			}

		}
		throw new NoSuchDataException();
	}

}
