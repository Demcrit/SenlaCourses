package com.senla.project.ui.entity;

import com.senla.project.ui.actions.EmptyAction;
import com.senla.project.ui.actions.PrintAllMechanicsAction;
import com.senla.project.ui.api.IAction;

public class Builder {
	
	private final String MAIN_MENU = "Main menu";
    private final String EXIT = "Exit";
    private final String BACK = "Back";
    private final String MECHANICS = "Mechanics";
    private final String ORDERS = "Orders";
    private final String WORPLACES = "Workplaces";
    private final String ALL_MECHANICS = "Print all mechanics";
    
    private Menu rootMenu;
    private Navigator navigator;

    public Builder(Navigator navigator) {
        this.navigator = navigator;
    }

    public void build() {
        
    	IAction emptyAction = new EmptyAction();
        IAction printMechanics = new PrintAllMechanicsAction();
        
        Menu mainMenu = new Menu(MAIN_MENU);
        Menu mechanicsMenu = new Menu(MECHANICS);
        
        this.rootMenu = mainMenu;
        
        MenuItem exit = new MenuItem(navigator);
        exit.setTitle(EXIT);
        mainMenu.addMenuItem(exit);
        
        MenuItem mechanics = new MenuItem(navigator);
        mechanics.setTitle(MECHANICS);
        mechanics.setNextMenu(mechanicsMenu);
        mechanics.setAction(emptyAction);
        mainMenu.addMenuItem(mechanics);
        
        this.navigator.setCurrentMenu(rootMenu);
}
}