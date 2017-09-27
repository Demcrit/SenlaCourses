package com.senla.project.comparators;

import java.util.Comparator;

import com.senla.project.model.Mechanic;

public class MechanicFullNameComparator implements Comparator<Mechanic>{
	
	public int compare(Mechanic m1,Mechanic m2){
		return m1.getFullName().compareTo(m2.getFullName());
	}

}
