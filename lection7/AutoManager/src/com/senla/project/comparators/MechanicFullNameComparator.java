package com.senla.project.comparators;

import java.util.Comparator;

import com.senla.project.model.Mechanic;
import com.senla.project.utils.ComparatorSafetyUtil;

public class MechanicFullNameComparator implements Comparator<Mechanic> {

	public int compare(Mechanic m1, Mechanic m2) {
		int check = ComparatorSafetyUtil.checkNull(m1, m2);
		if (check == 2) {
			return m1.getFullName().compareTo(m2.getFullName());
		}
		return check;
	}
}