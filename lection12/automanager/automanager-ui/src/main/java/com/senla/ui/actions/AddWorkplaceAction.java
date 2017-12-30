package com.senla.ui.actions;

import static com.senla.utils.PrintUtil.*;
import com.senla.config.holder.Holder;
import com.senla.ui.api.IAction;
public class AddWorkplaceAction implements IAction {

	private static final String NO_PERMISSIONS = "No permission for action";
	private static final String MESSAGE_WORKPLACE = "ID of Workplace to add: ";
	
	public void execute() {
		
		if (Holder.getInstance().addRemoveWorkplace() == true) {
			printMessage(MESSAGE_WORKPLACE);
		} else
		{
			printMessage(NO_PERMISSIONS);
		}
		
	}

}
