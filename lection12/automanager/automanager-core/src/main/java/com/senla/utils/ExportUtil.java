package com.senla.utils;

import java.util.ArrayList;
import java.util.List;

import com.senla.model.Mechanic;

public class ExportUtil {

	private static final String EXPORT_SPLIT_BASE = ",";

	public static String exportMechanic(Mechanic mechanic) {
		StringBuilder str = new StringBuilder();
		str.append(mechanic.getId()).append(EXPORT_SPLIT_BASE).append(mechanic.getFullName()).append(EXPORT_SPLIT_BASE);
		return str.toString();
	}

	public static List<String> exportMechanics(List<Mechanic> mechanics) {
		List<String> output = new ArrayList<>();
		for (Mechanic mechanic : mechanics) {
			output.add(exportMechanic(mechanic));
		}
		return output;
	}
}
