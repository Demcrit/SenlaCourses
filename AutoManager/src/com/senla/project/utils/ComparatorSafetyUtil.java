package com.senla.project.utils;

public class ComparatorSafetyUtil {

	public static int checkNull(Object o1, Object o2) {
        if ((o1 == null) && (o2 == null)) {
            return 0;
        }
        if (o1 == null) {
            return 1;
        }
        if (o2 == null) {
            return -1;
        }
        return 2;
    }
	
	
}
