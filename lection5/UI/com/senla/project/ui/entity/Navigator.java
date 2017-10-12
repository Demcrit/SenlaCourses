package com.senla.project.ui.entity;

public class Navigator {
	private Menu currentMenu;
	private Boolean exit;

	public Navigator() {
		this.exit = false;
	}

	public Menu getCurrentMenu() {
		return currentMenu;
	}

	public void setCurrentMenu(Menu currentMenu) {
		this.currentMenu = currentMenu;
	}

	public Boolean getExit() {
		return exit;
	}

	public void setExit(Boolean exit) {
		this.exit = exit;
	}

}
