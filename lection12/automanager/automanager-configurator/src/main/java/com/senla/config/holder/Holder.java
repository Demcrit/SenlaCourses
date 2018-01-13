package com.senla.config.holder;

import java.util.Properties;

public class Holder {

	private static Holder instance;

	private boolean addRemoveWorkplace;
	private boolean removeOrder;
	private boolean delayOrder;
	private String dbPath;
	private String dbCSVPath;
	private String dbDriver;
	private String dbHost;
	private String dbLogin;
	private String dbPassword;

	public static Holder getInstance() {
		if (instance == null) {
			instance = new Holder();
			instance.init();
		}
		return instance;
	}

	public void init() {
		Properties prop = Loader.readFile();
		dbCSVPath = prop.getProperty("dbCSVPath");
		dbPath = prop.getProperty("dbPath");
		addRemoveWorkplace = Boolean.parseBoolean(prop.getProperty("addRemoveWorkplace"));
		removeOrder = Boolean.parseBoolean(prop.getProperty("removeOrder"));
		delayOrder = Boolean.parseBoolean(prop.getProperty("delayOrder"));
		dbDriver = prop.getProperty("dbDriver");
		dbHost = prop.getProperty("dbHost");
		dbLogin = prop.getProperty("dbLogin");
		dbPassword = prop.getProperty("dbPassword");
	}

	public Boolean addRemoveWorkplace() {
		return addRemoveWorkplace;
	}

	public Boolean removeOrder() {
		return removeOrder;
	}

	public Boolean delayOrder() {
		return delayOrder;
	}

	public String getDBPath() {
		return dbPath;
	}

	public String getDBCsvPath() {
		return dbCSVPath;
	}

	public String getDbPath() {
		return dbPath;
	}

	public String getDbDriver() {
		return dbDriver;
	}

	public String getDbHost() {
		return dbHost;
	}

	public String getDbLogin() {
		return dbLogin;
	}

	public String getDbPassword() {
		return dbPassword;
	}
}
