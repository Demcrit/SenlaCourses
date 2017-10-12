package com.senla.project.ui.entity;

import com.senla.project.ui.api.IAction;
import com.senla.project.ui.entity.Menu;
import com.senla.project.ui.entity.Navigator;

public class MenuItem {

	private Navigator navigator;
	private String title;
	private IAction action;
	private Menu nextMenu;

	public MenuItem(Navigator navigator) {
		this.navigator = navigator;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public IAction getAction() {
		return action;
	}

	public void setAction(IAction action) {
		this.action = action;
	}

	public Navigator getNavigator() {
		return navigator;
	}

	public void setNavigator(Navigator navigator) {
		this.navigator = navigator;
	}

	public Menu getNextMenu() {
		return nextMenu;
	}

	public void setNextMenu(Menu nextMenu) {
		this.nextMenu = nextMenu;
	}

	public void executeAction() {
		if (this.nextMenu != null) {
			this.action.execute();
			this.navigator.setCurrentMenu(this.nextMenu);
		} else {
			this.navigator.setExit(Boolean.TRUE);
		}
	}

	@Override
	public String toString() {
		return this.title;
	}
}
