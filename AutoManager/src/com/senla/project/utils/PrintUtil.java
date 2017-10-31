package com.senla.project.utils;

import java.util.List;

public class PrintUtil {

	public static void printMessage(String message) {
		System.out.println(message);
	}

	public static void printObject(Object object) {
		System.out.println(object);
	}

	public static void printMessageAndObject(String message, Object object) {
		printMessage(message);
		System.out.println(object);
	}

	public static void printList(List<Object> object) {

		for (Object item : object) {
			System.out.println(item.toString());
		}
	}
}
