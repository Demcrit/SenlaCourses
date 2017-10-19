package com.senla.project.ui.actions;

import com.senla.project.facade.*;
import com.senla.project.model.Mechanic;
import com.senla.project.ui.api.IAction;
import com.senla.project.ui.utils.*;
public class AddMechanicAction implements IAction {

	
	@Override
	public void execute() {
		Mechanic mechanic = InputUtil.inputMechanic();
		Facade.getInstance().addMechanic(mechanic);
		
		
	}
	
}
