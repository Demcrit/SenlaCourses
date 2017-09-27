package com.senla.project.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.senla.project.comparators.MechanicFullNameComparator;
import com.senla.project.interfaces.MechanicService;
import com.senla.project.model.Mechanic;
import com.senla.project.exceptions.NoSuchDataException;
public class MechanicManager implements MechanicService{
	
	private List<Mechanic> mechanics = new ArrayList<>();

	
	public void addMechanic(Mechanic mechanic){
			mechanics.add(mechanic);
		
	}
	
	public void deleteMechanic(Mechanic mechanic){
		mechanics.remove(mechanic);
	}
	
	public Mechanic showMechanic(int id) throws NoSuchDataException { 
		for(Mechanic mechanic:mechanics) {
			if (mechanic.getId()== id){
				return mechanic;
			}
		}
		throw new NoSuchDataException();
					}
	
	public Mechanic findFreeMechanic(){
		for (Mechanic mechanic:mechanics){
			if(mechanic.getCurrenOrder()==null){
				return mechanic;
			}
			}
		return null;
	}
	
	public void getAllMechanics(){
		for (int i = 0; i<mechanics.size();i++){
		 System.out.println(mechanics.get(i));
	}		
		}
	
	public List <Mechanic> sortMechanicsByName() {
		List <Mechanic> list = new ArrayList<Mechanic>();
		Collections.sort(list,new MechanicFullNameComparator());
		return list;
	}
	
	public List <Mechanic> sortMechanicsByWork(){
		List <Mechanic> list = new ArrayList<>();
		for (Mechanic mechanic:mechanics) {
			if(mechanic.getCurrenOrder() !=null) {
				list.add(0,mechanic);
			} else {
				list.add(mechanic);
		} return list;
			}
	return null;
	}
	
}
