package com.senla.project.services;

import java.io.Serializable;
import java.util.List;
import com.senla.project.dao.realization.MechanicDao;
import com.senla.project.dbconnector.DBAccess;
import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.interfaces.IMechanicService;
import com.senla.project.model.Mechanic;

public class MechanicService implements IMechanicService, Serializable {

	private static final long serialVersionUID = 1L;
	private MechanicDao mechanicDAO = new MechanicDao();
	private DBAccess dbAccess;

	@Override
	public void addMechanic(String fullName) {
		synchronized (mechanicDAO) {
			mechanicDAO.create(dbAccess.getConnection(), new Mechanic(fullName));
		}
	}

	@Override
	public void deleteMechanic(int mechanicId) {
		synchronized (mechanicDAO) {
			mechanicDAO.delete(dbAccess.getConnection(), mechanicId);
		}
	}

	@Override
	public Mechanic findFreeMechanic() throws NoSuchDataException {
		return mechanicDAO.findFreeMechanic(dbAccess.getConnection());
	}

	@Override
	public List<Mechanic> sortMechanicsByName() {
		return mechanicDAO.sortMechanicsByFullName(dbAccess.getConnection());
	}

	@Override
	public List<Mechanic> sortMechanicsByWork() {
		return mechanicDAO.sortMechanicsByWork(dbAccess.getConnection());
	}

	public List<Mechanic> getAll() {
		synchronized (mechanicDAO) {
			return mechanicDAO.getAll(dbAccess.getConnection());
		}
	}

	public Mechanic getMechanic(int id) throws NoSuchDataException {
		synchronized (mechanicDAO) {
			return mechanicDAO.getById(dbAccess.getConnection(), id);
		}
	}

	@Override
	public boolean exportAll() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean importAll() throws NoSuchDataException {
		// TODO Auto-generated method stub
		return false;
	}

}
