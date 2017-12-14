package com.senla.project.dbconnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.senla.project.config.holder.*;

public class DBAccess {
	private static final Logger LOG = LogManager.getLogger(DBAccess.class);

	private static DBAccess instance;
	private Connection connection;

	private static String HOST = Holder.getInstance().getDbHost();
	private static String DRIVER = Holder.getInstance().getDbDriver();
	private static String LOGIN = Holder.getInstance().getDbLogin();
	private static String PASS = Holder.getInstance().getDbPassword();

	private DBAccess() {
		createConnection();
	}

	private void createConnection() {

		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(HOST, LOGIN, PASS);
			LOG.info("Connection done");
		} catch (ClassNotFoundException | SQLException e) {
			LOG.error("Connection failed", e);
		}
	}

	public Connection getConnection() {
		if (connection == null) {
			createConnection();
		}

		return connection;
	}

	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();

				LOG.info("Connection closed");
			}
		} catch (SQLException e) {
			LOG.error("Connection is not closed", e);
		}
	}

	public void closeStatement(Statement statement) {
		try {
			statement.close();
		} catch (SQLException e) {
			LOG.error(e.getMessage());
		}
	}

	public static DBAccess getInstance() {
		if (instance == null) {
			instance = new DBAccess();
		}

		return instance;
	}
}
