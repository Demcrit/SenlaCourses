package com.senla.project.utils;

public class PrintUtil {

	public static void printMessage(String message) {
        System.out.println(message);
    }

    public static  void printObject(Object object) {
        System.out.println(object);
    }

    public static void printMessageAndObject(String message, Object object) {
        printMessage(message);
        System.out.println(object);
    }

    public static void printInfo(String message, Object object, Object object1) {
        printMessage(message);
        printObject(object);
        System.out.println(object1);
    }
}