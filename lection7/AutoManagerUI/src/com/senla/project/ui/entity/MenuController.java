package com.senla.project.ui.entity;

import org.apache.logging.log4j.Logger;
import static com.senla.project.utils.PrintUtil.*;
import static com.senla.project.ui.utils.GeneralScanner.*;
import com.senla.project.ui.api.IMenuController;
import org.apache.logging.log4j.LogManager;

public class MenuController implements IMenuController {

	private final Logger LOG = LogManager.getLogger(MenuController.class);
	private final String WRONG_INDEX = "Wrong symbol or number";
	private final String CHECK = "Choise rigth action";
	private Navigator navigator;
	private Builder builder;
	
	@Override
	public void run() {
		builder =  new Builder(); 
		builder.build();
		navigator = new Navigator();
		navigator.setCurrentMenu(builder.getRootMenu());
		navigator.printMenu();
		Integer index;
		while (true) {
			String input = nextLine();
			if ("exit".equals(input))
				break;
			index = -1;
			try {
				index = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				LOG.error(WRONG_INDEX);
			}
			if (index > 0 && 
					index <= navigator.getCurrentMenu().getMenuItems().size()) {
				navigator.getCurrentMenu().getMenuItems().get(index-1).executeAction();
				navigator.navigate(index-1);
				navigator.printMenu();
			} else {
				printMessage(CHECK);
			}
			
		}
		closeScanner();
	}

	}
