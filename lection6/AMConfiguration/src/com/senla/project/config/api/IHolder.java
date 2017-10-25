package com.senla.project.config.api;

public interface IHolder {

	void init();
	
	Boolean addRemoveWorkplace();
	
	Boolean removeOrder();
	
	Boolean delayOrder();
	
	String getDBPath();
}
