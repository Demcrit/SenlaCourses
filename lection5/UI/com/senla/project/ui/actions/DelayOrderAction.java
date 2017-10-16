package com.senla.project.ui.actions;

import com.senla.project.ui.api.IAction;
import static com.senla.project.ui.utils.GeneralScanner.*;
import static com.senla.project.utils.PrintUtil.*;

import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.facade.Facade;
import com.senla.project.model.Order;

public class DelayOrderAction implements IAction {

	private static final String HOW_MANY_DAYS = "For how many days delay other orders:";
	private static final String DELAYED_ID_REQUEST = "Input Id of delayed order";
	
	@Override
	public void execute() {
		
		printMessage(DELAYED_ID_REQUEST);
			try {
				Order delayed = Facade.getFACADE().getDirectOrder(nextInt());
				printMessage(HOW_MANY_DAYS);
				Facade.getFACADE().moveOrder(delayed,nextInt());
			} catch (NoSuchDataException e) {
				printMessage(e.getMessage());
			}
			
		} 		
	}
