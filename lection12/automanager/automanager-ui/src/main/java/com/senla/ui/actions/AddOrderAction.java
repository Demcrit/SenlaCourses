package com.senla.ui.actions;

import java.text.ParseException;

import static com.senla.utils.PrintUtil.*;
import static com.senla.ui.utils.GeneralScanner.*;

import com.senla.exceptions.NoSuchDataException;
import com.senla.facade.*;
import com.senla.model.*;
import com.senla.ui.api.IAction;
public class AddOrderAction implements IAction {

	private static final String PARSED_WITH_ERRORS = "Date was parsed with errors.";

	public void execute() throws ReflectiveOperationException {
		printMessage("Fill TODO field:");
		String toDo = nextLine();
		printMessage("Date, when order will start:");
		String startDate = nextLine();
		printMessage("Date, when order will be completed:");
		String completeDate = nextLine();
		printMessage("Price:");
		double price = nextDouble();
		
		try {
			Task task = new Task(0, toDo, parseTodayDate(), parseDate(startDate), parseDate(completeDate), price);
			Mechanic freeMechanic = Facade.getInstance().findFreeMechanic();
			Workplace freeWorkPlace = Facade.getInstance().findFreeWorkPlace();
			
			Order order = new Order(freeMechanic, freeWorkPlace, task);
			
			freeMechanic.setCurrenOrder(order);
			freeWorkPlace.setOrder(order);
			
		} catch (ParseException e) {
			printMessage(PARSED_WITH_ERRORS);
		} catch (NoSuchDataException e) {
			printMessage(e.getMessage());
		}
	}


	}

