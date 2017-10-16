package com.senla.project.ui.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class GeneralScanner {

	static Scanner scanner = new Scanner(System.in);
	static DateParser dateParser = new DateParser();

	public static int nextInt() {
		return scanner.nextInt();
	}

	public static String nextLine() {
		return scanner.nextLine();
	}

	public static double nextDouble() {
		return scanner.nextDouble();
	}

	public static Date parseDate(String stringDate) throws ParseException {
		return dateParser.parseDate(stringDate);
	}

	public static Date parseTodayDate(){
		return dateParser.getToday();
	}
	
	public boolean hasNextInt(){
		return scanner.hasNextInt();
	}
	
	private static class DateParser {

		private SimpleDateFormat format = new SimpleDateFormat();

		private Date parseDate(String stringDate) throws ParseException {

			format.applyPattern("dd.MM.yyyy");
			return format.parse(stringDate);
		}

		private Date getToday() {
			return Calendar.getInstance().getTime();
		}
	}
}
