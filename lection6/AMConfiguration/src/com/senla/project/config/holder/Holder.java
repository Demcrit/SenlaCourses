package com.senla.project.config.holder;

import java.util.Properties;

import com.senla.project.config.api.IHolder;

public class Holder implements IHolder {

	private static IHolder instance;

	private boolean addRemoveWorkplace;
	private boolean removeOrder;
	private boolean delayOrder;
	private String dbPath;

	public static IHolder getInstance() {
		if (instance == null) {
			instance = new Holder();
			instance.init();
		}
		return instance;
	}

	@Override
	public void init() {
		Properties prop = Loader.readFile();
		dbPath = prop.getProperty("dbPath");
		addRemoveWorkplace = Boolean.parseBoolean(prop.getProperty("addRemoveWorkplace"));
		removeOrder = Boolean.parseBoolean(prop.getProperty("removeOrder"));
		delayOrder = Boolean.parseBoolean(prop.getProperty("delayOrder"));
	}

	@Override
	public Boolean addRemoveWorkplace() {
		return addRemoveWorkplace;
	}

	@Override
	public Boolean removeOrder() {
		return removeOrder;
	}

	@Override
	public Boolean delayOrder() {
		return delayOrder;
	}

	@Override
	public String getDBPath() {
		return dbPath;
	}

}
