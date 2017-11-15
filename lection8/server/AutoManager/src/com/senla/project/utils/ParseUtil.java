package com.senla.project.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.senla.project.model.Mechanic;

public class ParseUtil {
	private static final String PARSE_SPLIT_BASE = "[,] + ";
	private static Logger LOG = LogManager.getLogger(ParseUtil.class);

	public static Mechanic parseMechanic(String input) {
		String[] parsed = input.split(PARSE_SPLIT_BASE);
		List<String> inputArray = Arrays.asList(parsed);
		Mechanic mechanic;
		try {
			Integer id = Integer.parseInt(inputArray.get(0));
			String name = inputArray.get(1);
			mechanic = new Mechanic(id, name);
			return mechanic;
		} catch (NumberFormatException e) {
			LOG.error(e);
			return null;
		}

	}

	public static List<Mechanic> parseMechanics(List<String> input) {
		List<Mechanic> mechanics = new ArrayList<Mechanic>();
		for (String str : input) {
			Mechanic mechanic = parseMechanic(str);
			mechanics.add(mechanic);
		}
		return mechanics;
	}
}
