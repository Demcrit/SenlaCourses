package com.senla.project.ui.entity;

import com.senla.project.ui.actions.AddMechanicAction;
import com.senla.project.ui.actions.EmptyAction;
import com.senla.project.ui.actions.PrintAllMechanicsAction;
import com.senla.project.ui.api.IAction;

public class Builder {

	private final String MAIN_MENU = "Main menu";
	private final String EXIT = "Exit";
	private final String BACK = "Back";
	private final String MECHANICS = "Mechanics";
	private final String ORDERS = "Orders";
	private final String WORKPLACES = "Workplaces";
	private final String ALL_MECHANICS = "Print all mechanics";
	private final String ADD_MECHANIC = "Add Mechanic";

	private Menu rootMenu;

	public Menu getRootMenu() {
		return rootMenu;
	}

	public void build() {

		IAction emptyAction = new EmptyAction();
		IAction printMechanics = new PrintAllMechanicsAction();
		IAction addMechanic = new AddMechanicAction();

		Menu mainMenu = new Menu(MAIN_MENU);
		Menu mechanicsMenu = new Menu(MECHANICS);
		Menu ordersMenu = new Menu(ORDERS);
		Menu workplaceMenu = new Menu(WORKPLACES);

		this.rootMenu = mainMenu;
		// Main menu
		MenuItem exit = new MenuItem();
		exit.setTitle(EXIT);
		mainMenu.addMenuItem(exit);
		MenuItem mechanics = new MenuItem();
		mechanics.setTitle(MECHANICS);
		mechanics.setNextMenu(mechanicsMenu);
		mechanics.setAction(emptyAction);
		mainMenu.addMenuItem(mechanics);
		MenuItem orders = new MenuItem();
		orders.setTitle(ORDERS);
		orders.setNextMenu(ordersMenu);
		orders.setAction(emptyAction);
		mainMenu.addMenuItem(orders);
		MenuItem workplaces = new MenuItem();
		workplaces.setTitle(WORKPLACES);
		workplaces.setNextMenu(workplaceMenu);
		workplaces.setAction(emptyAction);
		mainMenu.addMenuItem(workplaces);
		// Mechanic Menu
		MenuItem backToMain = new MenuItem();
		backToMain.setTitle(BACK);
		backToMain.setNextMenu(mainMenu);
		backToMain.setAction(emptyAction);
		mechanicsMenu.addMenuItem(backToMain);
		MenuItem addMechanics = new MenuItem();
		addMechanics.setTitle(ADD_MECHANIC);
		addMechanics.setNextMenu(mechanicsMenu);
		addMechanics.setAction(addMechanic);
		mechanicsMenu.addMenuItem(addMechanics);
	}
}