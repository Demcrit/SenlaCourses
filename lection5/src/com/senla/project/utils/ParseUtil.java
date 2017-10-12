package com.senla.project.utils;

import java.util.List;

public class ParseUtil {
	public static String[] arrayToList(List list) {
		String[] mas = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			mas[i] = String.valueOf(list.get(i));
		}
		return mas;
	}
}
