package com.senla.project.ui.entity;

import com.senla.project.ui.api.IAction;
import com.senla.project.ui.entity.Menu;

public class MenuItem {

	private String title;
	private IAction action;
	private Menu nextMenu;

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

	public Menu getNextMenu() {
		return nextMenu;
	}

	public void setNextMenu(Menu nextMenu) {
		this.nextMenu = nextMenu;
	}

	public void executeAction() {
		if (this.nextMenu != null) {
			this.action.execute();
		}
	}

	@Override
	public String toString() {
		return this.title;
	}
}
