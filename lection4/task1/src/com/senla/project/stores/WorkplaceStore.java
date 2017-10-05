package com.senla.project.stores;

import java.util.List;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Workplace;

public class WorkplaceStore {

	private List<Workplace> workplaces;

	public void addWorkplace(Workplace workplace) {
		workplaces.add(workplace);
	}

	public void deleteWorkplace(Workplace workplace) {
		workplaces.remove(workplace);

	}

	public Workplace findFreeWorkPlace() throws NoSuchDataException {
		
		for(Workplace workplace:workplaces){
			if(workplace.getOrder()==null){
				return workplace;
			}
			
		}
		throw new NoSuchDataException();
	}

}
