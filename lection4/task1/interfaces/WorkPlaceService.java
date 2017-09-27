package com.senla.project.interfaces;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.model.Garage;
import com.senla.project.model.WorkPlace;

public interface WorkPlaceService {
void addGarage(Garage garage);
void addWorkPlace(Garage garage);
boolean deleteWorkPlace(Garage garage,int workPlaceId);
WorkPlace findFreeWorkPlace() throws NoSuchDataException;
Garage showGarage(int garageId) throws NoSuchDataException;

}
