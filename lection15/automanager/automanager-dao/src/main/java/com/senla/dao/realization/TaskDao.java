package com.senla.dao.realization;

import com.senla.dao.api.ITaskDao;
import com.senla.model.Task;

public class TaskDao extends AbstractDao<Task> implements ITaskDao {

	public TaskDao() {
		super(Task.class);
		}
		
}
