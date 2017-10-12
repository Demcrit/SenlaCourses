package com.senla.project.ui.runner;

import com.senla.project.ui.api.IMenuController;
import com.senla.project.ui.entity.MenuController;

public class Main {

	public static void main(String[] args) {
		IMenuController contr = (IMenuController) new MenuController();
		contr.run();

	}

}
