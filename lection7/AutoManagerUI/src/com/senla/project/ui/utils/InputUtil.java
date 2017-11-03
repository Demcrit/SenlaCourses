package com.senla.project.ui.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.senla.project.utils.*;
import com.senla.project.model.Mechanic;
import com.senla.project.model.Order;
import com.senla.project.model.Task;
import com.senla.project.model.Workplace;

public class InputUtil {
	private static Logger log = LogManager.getLogger(InputUtil.class);
	private static Scanner sc=  new Scanner(System.in);
	private static PrintUtil printer = new PrintUtil();
	
	public static Mechanic inputMechanic(){
		printer.printMessage("Enter full name");
		String fname = sc.nextLine();
		Mechanic mechanic = new Mechanic(fname); 
		return mechanic;
	}
	
	public static Order inputOrder(){
		printer.printMessage("Enter Mechanic");
		Mechanic mechanic = inputMechanic();
		printer.printMessage("Enter worplace");
		Workplace workplace = inputWorkplace();
		printer.printMessage("Enter Task");
		Task task = inputTask();
		Order order = new Order(mechanic,workplace,task);
		return order;
	}
	
	
	public static Workplace inputWorkplace(){
		printer.printMessage("Enter number");
		int number = sc.nextInt();
		printer.printMessage("Enter Order");
		Order order = inputOrder();
		Workplace workplace = new Workplace();
		return workplace;
	}
	
	public static Task inputTask(){
		printer.printMessage("Enter task name");
		String name = sc.nextLine();
		printer.printMessage("Enter order date");
		Date orderDate = inputDate();
		printer.printMessage("Enter start date");
		Date startDate = inputDate();
		printer.printMessage("Enter end date");
		Date endDate = inputDate();
		printer.printMessage("Enter price");
		double price = sc.nextDouble();
		
		Task task = new Task(name,orderDate,startDate,endDate,price);
		return task;
	}
	
	public static Date inputDate() {
        Date date = null;
        DateUtil dateTest = new DateUtil();
        printer.printMessage("ENTER_DATE");
        boolean stop = true;
        while (stop) {
            try {
                date = dateTest.create(sc.nextLine());
                stop = false;
            } catch (Exception e) {
                System.out.println("DATE_ERROR");
                log.info(e);
            }
        }
        return date;
    }
	
	public static Integer inputMenu() {
        boolean stop = true;
        Integer id = 0;
        while (stop) {
            try {
                id = Integer.parseUnsignedInt(sc.nextLine());
                stop = false;
            } catch (Exception e) {
                printer.printMessage("ERROR_MENU");
                log.info(e);
            }
        }
        return id;
    }
	
	public static void closeScanner(){
		sc.close();
	}
	
}
