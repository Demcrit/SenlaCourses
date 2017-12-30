package com.senla.ui.utils;

import java.util.Date;
import java.util.Scanner;
import org.apache.log4j.*;
import com.senla.utils.*;
import com.senla.model.Mechanic;
import com.senla.model.Order;
import com.senla.model.Task;
import com.senla.model.Workplace;

public class InputUtil {
	private static Logger log = LogManager.getLogger(InputUtil.class);
	private static Scanner sc=  new Scanner(System.in);
	public static Mechanic inputMechanic(){
		PrintUtil.printMessage("Enter full name");
		String fname = sc.nextLine();
		Mechanic mechanic = new Mechanic(fname); 
		return mechanic;
	}
	
	public static Order inputOrder(){
		PrintUtil.printMessage("Enter Mechanic");
		Mechanic mechanic = inputMechanic();
		PrintUtil.printMessage("Enter worplace");
		Workplace workplace = inputWorkplace();
		PrintUtil.printMessage("Enter Task");
		Task task = inputTask();
		Order order = new Order(mechanic,workplace,task);
		return order;
	}
	
	
	public static Workplace inputWorkplace(){
		PrintUtil.printMessage("Enter number");
		PrintUtil.printMessage("Enter Order");
		Workplace workplace = new Workplace();
		return workplace;
	}
	
	public static Task inputTask(){
		PrintUtil.printMessage("Enter task id");
		int id = sc.nextInt();
		PrintUtil.printMessage("Enter task name");
		String name = sc.nextLine();
		PrintUtil.printMessage("Enter order date");
		Date orderDate = inputDate();
		PrintUtil.printMessage("Enter start date");
		Date startDate = inputDate();
		PrintUtil.printMessage("Enter end date");
		Date endDate = inputDate();
		PrintUtil.printMessage("Enter price");
		double price = sc.nextDouble();
		
		Task task = new Task(id, name,orderDate,startDate,endDate,price);
		return task;
	}
	
	public static Date inputDate() {
        Date date = null;
        DateUtil dateTest = new DateUtil();
        PrintUtil.printMessage("ENTER_DATE");
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
                PrintUtil.printMessage("ERROR_MENU");
                log.info(e);
            }
        }
        return id;
    }
	
	public static void closeScanner(){
		sc.close();
	}
	
}
