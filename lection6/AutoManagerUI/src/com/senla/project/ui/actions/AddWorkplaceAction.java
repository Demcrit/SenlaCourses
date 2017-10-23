package com.senla.project.ui.actions;

import com.senla.project.config.AutoManagerConfigStorage;
import com.senla.project.facade.Facade;
import com.senla.project.ui.api.IAction;
import static com.senla.project.utils.PrintUtil.*;
import static com.senla.project.ui.utils.GeneralScanner.*;
public class AddWorkplaceAction implements IAction {

	private static final String NO_PERMISSIONS = "No permission for action";
	private static final String MESSAGE_WORKPLACE = "ID of Workplace to add: ";
	
	@Override
	public void execute() {
		
		AutoManagerConfigStorage propHolder = new AutoManagerConfigStorage();
		
		if (propHolder.isAddRemoveWorkplace() == true) {
			printMessage(MESSAGE_WORKPLACE);
			int wpId = nextInt();
			//Facade.getInstance().addWorkplace(wokplace);
		} else
		{
			printMessage(NO_PERMISSIONS);
		}
		
	}

}
