package com.senla.project.ui.entity;
import org.apache.logging.log4j.Logger;
import com.senla.project.ui.api.IMenuController;
import com.senla.project.ui.utils.InputUtil;

import org.apache.logging.log4j.LogManager;

public class MenuController implements IMenuController {
	
	private final Logger log = LogManager.getLogger(MenuController.class);

	private final String WRONG_INDEX = "Wrong menu index!";
    private final String LINE = "--------";

    private Navigator navigator;
    private Builder builder;

    public MenuController() {
        this.navigator = new Navigator();
        this.builder = new Builder(this.navigator);
    }

	@Override
	public void run() {
		this.builder.build();
        Integer index = 0;
        Boolean indexOk;
        System.out.println(LINE);
        do {
            System.out.println(this.navigator.getCurrentMenu());
            System.out.println(LINE);
            indexOk = false;
            do {
                index =InputUtil.inputMenu();
                if (index >= this.navigator.getCurrentMenu().getMenuItems().size()) {
                    System.out.println(WRONG_INDEX);
                } else {
                    indexOk = true;
                }
            } while (!indexOk);
            System.out.println(LINE);
            this.navigator.getCurrentMenu().getMenuItems().get(index).executeAction();
            System.out.println(LINE);
        } while (!this.navigator.getExit());
         InputUtil.closeScanner();
        System.out.println("");
		
		
	}
}
