package com.senla.ui.entity;

import static com.senla.utils.PrintUtil.*;

public class Navigator {
	private Menu currentMenu;

	public Menu getCurrentMenu() {
		return currentMenu;
	}

	public void setCurrentMenu(Menu currentMenu) {
		this.currentMenu = currentMenu;
	}

	public void printMenu() {

		printMessage(currentMenu.getTitle());
		int i = 1;
		for (MenuItem menuItem : currentMenu.getMenuItems()) {
			printMessage(i + "." + menuItem.getTitle());
			i++;
		}
	}

	public void navigate(Integer index) {
		currentMenu = currentMenu.getMenuItems().get(index).getNextMenu();
	}

}
