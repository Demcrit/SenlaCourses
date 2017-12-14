package com.senla.project.services;

import java.util.List;
import com.senla.project.dao.realization.WorkplaceDao;
import com.senla.project.dbconnector.DBAccess;
import com.senla.project.exceptions.NoSuchDataException;
import com.senla.project.interfaces.IWorkplaceService;
import com.senla.project.model.Workplace;

public class WorkplaceService implements IWorkplaceService {

	private WorkplaceDao workplaceDAO = new WorkplaceDao();
	private DBAccess dbAccess;

	@Override
	public void addWorkplace(Workplace workplace) {
		synchronized (workplaceDAO) {
			workplaceDAO.create(dbAccess.getConnection(), workplace);
			;
		}
	}

	@Override
	public void deleteWorkplace(int workplaceId) {
		synchronized (workplaceDAO) {
			workplaceDAO.delete(dbAccess.getConnection(), workplaceId);
		}
	}

	@Override
	public Workplace findFreeWorkPlace() throws NoSuchDataException {
		return workplaceDAO.getFreePlace(dbAccess.getConnection());
	}

	public List<Workplace> getWorkplaces() {
		synchronized (workplaceDAO) {
			return workplaceDAO.getAll(dbAccess.getConnection());
		}
	}

}
