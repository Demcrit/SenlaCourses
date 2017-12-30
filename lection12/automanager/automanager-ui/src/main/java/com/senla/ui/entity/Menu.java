package com.senla.ui.entity;

import java.util.ArrayList;
import java.util.List;

import com.senla.ui.entity.MenuItem;

public class Menu {

	 private final String LINE_BREAK = "\n";
	    private final String BREAKER = " - ";
	    private final String ZERO = "0";
	    
	    private String title;
	    private List<MenuItem> menuItems;

	    public Menu(String title) {
	        this.menuItems = new ArrayList<MenuItem>();
	        this.title = title;
	    }

	    public String getTitle() {
	        return title;
	    }

	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public List<MenuItem> getMenuItems() {
	        return menuItems;
	    }

	    public void setMenuItems(List<MenuItem> menuItems) {
	        this.menuItems = menuItems;
	    }
	    
	    public void addMenuItem(MenuItem menuItem) {
	        this.menuItems.add(menuItem);
	    }
	    
	    @Override
	    public String toString() {
	        StringBuilder sbuilder = new StringBuilder();
	        sbuilder.append(this.title).append(LINE_BREAK);
	        for (int i = 1; i < this.menuItems.size(); i++) {
	            sbuilder.append(i).append(BREAKER).append(this.menuItems.get(i)).append(LINE_BREAK);
	        }
	        sbuilder.append(ZERO).append(BREAKER).append(this.menuItems.get(0));
	        return sbuilder.toString();
	    }
	
}
