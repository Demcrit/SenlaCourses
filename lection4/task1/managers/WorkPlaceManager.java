package com.senla.project.managers;

import java.util.Iterator;
import java.util.List;

import com.senla.project.model.WorkPlace;
import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.interfaces.WorkPlaceService;
import com.senla.project.model.Garage;

public class WorkPlaceManager implements WorkPlaceService {
	private int workPlaceNextId;
	private int garageNextId;
	private List<Garage> garages;
	
	public List<Garage> getGarages() {
		return garages;
	}
	
	public void addWorkPlace(Garage garage) {

		WorkPlace temp = new WorkPlace();
		temp.setId(workPlaceNextId);
		workPlaceNextId++;

		garage.getWorkplace().add(temp);
	}
	
	public void addGarage(Garage garage) {
		garage.setId(garageNextId);
		garageNextId++;
		garages.add(garage);
	}

	public boolean deleteWorkPlace(Garage garage, int placeId) {

		Iterator<WorkPlace> it = garage.getWorkplace().iterator();
		while (it.hasNext()) {

			if (it.next().getId() == placeId) {
				it.remove();
				return true;
			}
		}
		return false;
	}
	
	public Garage getGarage(int id) throws NoSuchDataException {

		for (Garage garage : garages) {
			if (garage.getId() == id) {
				return garage;
			}
		}
		throw new NoSuchDataException();
	}
	
	public WorkPlace findFreeWorkPlace() throws NoSuchDataException {

		if (!garages.isEmpty()) {

			for (Garage garage : garages) {
				if (garage.getWorkplace() != null) {

					for (WorkPlace workPlace : garage.getWorkplace()) {
						if (workPlace.getOrder() == null) {
							return workPlace;
						}
					}
				}
			}
		}
		throw new NoSuchDataException ();
	}
	
	public Garage showGarage(int garageId) throws NoSuchDataException{
		for (Garage garage:garages){
			if (garage.getId()==garageId){
				return garage;
			}
		}
		throw new NoSuchDataException();
	}
}
