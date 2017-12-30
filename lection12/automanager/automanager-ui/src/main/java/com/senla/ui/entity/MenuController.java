package com.senla.ui.entity;

import org.apache.log4j.*;

import com.senla.ui.api.IMenuController;

import static com.senla.utils.PrintUtil.*;
import static com.senla.ui.utils.GeneralScanner.*;

public class MenuController implements IMenuController {

	private final Logger LOG = LogManager.getLogger(MenuController.class);
	private final String WRONG_INDEX = "Wrong symbol or number";
	private final String CHECK = "Choise rigth action";
	private Navigator navigator;
	private Builder builder;
	
	public void run() throws ReflectiveOperationException {
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
