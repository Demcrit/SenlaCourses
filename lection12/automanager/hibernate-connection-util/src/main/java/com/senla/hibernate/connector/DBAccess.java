package com.senla.hibernate.connector;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DBAccess {

	private static DBAccess instance;

	private SessionFactory sessionFactory;

	private DBAccess() {
		try {
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (HibernateException e) {
		e.printStackTrace();
		}
	};

	public static DBAccess getInstance() {
		if (instance == null) {
			instance = new DBAccess();

		}

		return instance;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
