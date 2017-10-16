package com.senla.project.ui.actions;

import static com.senla.project.utils.PrintUtil.*;

import com.senla.project.exceptions.NoSuchDataException;

import static com.senla.project.ui.utils.GeneralScanner.*;
import com.senla.project.facade.Facade;
import com.senla.project.model.Mechanic;
import com.senla.project.ui.api.IAction;

public class DeleteMechanicAction implements IAction {

	private static final String MESSAGE = "Enter Mechnanic's ID to delete: ";

	@Override
	public void execute() {

		printMessage(MESSAGE);
		try {
			Mechanic mechanic = Facade.getFACADE().getMechanic(nextInt());
			Facade.getFACADE().deleteMechanic(mechanic);
		} catch (NoSuchDataException e) {
			printMessage(e.getMessage());
		}
	}

}
