package com.senla.services;

import org.hibernate.Session;

import com.senla.hibernate.connector.HibernateUtil;

public class SessionAccess {
	protected Session getSession() {
		return HibernateUtil.getInstance().getSession();
	}
}
