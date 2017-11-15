package com.senla.project.ui.actions;

import java.text.ParseException;
import com.senla.project.ui.api.IAction;
import static com.senla.project.utils.PrintUtil.*;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.facade.*;
import com.senla.project.model.*;
import static com.senla.project.ui.utils.GeneralScanner.*;
public class AddOrderAction implements IAction {

	private static final String PARSED_WITH_ERRORS = "Date was parsed with errors.";

	@Override
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
			Task task = new Task(toDo, parseTodayDate(), parseDate(startDate), parseDate(completeDate), price);
			Mechanic freeMechanic = Facade.getInstance().findFreeMechanic();
			Workplace freeWorkPlace = Facade.getInstance().findFreeWorkPlace();
			
			Order order = new Order(freeMechanic, freeWorkPlace, task);
			
			Facade.getInstance().addOrder(order);
			freeMechanic.setCurrenOrder(order);
			freeWorkPlace.setOrder(order);
			
		} catch (ParseException e) {
			printMessage(PARSED_WITH_ERRORS);
		} catch (NoSuchDataException e) {
			printMessage(e.getMessage());
		}
	}


	}

