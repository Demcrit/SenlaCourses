package com.senla.project.services;

import java.util.List;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.interfaces.IWorkplaceService;
import com.senla.project.model.Workplace;
import com.senla.project.stores.WorkplaceStore;

public class WorkplaceService implements IWorkplaceService {

	private WorkplaceStore workplaceStore = new WorkplaceStore();

	@Override
	public void addWorkplace(Workplace workplace) {
		workplaceStore.addWorkplace(workplace);

	}

	@Override
	public void deleteWorkplace(Workplace workplace) {
		workplaceStore.deleteWorkplace(workplace);

	}

	@Override
	public Workplace findFreeWorkPlace() throws NoSuchDataException {
		return workplaceStore.findFreeWorkPlace();
	}

	public List<Workplace> getWorkplaces() {
		return workplaceStore.getWorkplaces();
	}

	public void setWorkplaces(List<Workplace> workplaces) {
		workplaceStore.setWorkplaces(workplaces);
	}

}
