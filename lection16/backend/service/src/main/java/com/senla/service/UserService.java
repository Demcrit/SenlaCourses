package com.senla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.senla.dao.api.UserDAO;
import com.senla.model.User;

@Service
public class UserService {

	@Autowired
	private UserDAO userDAO;
	
	public UserService() {
	}

	@Transactional
	public void addUser(User user) {
		userDAO.add(user);
	}

	public void updateUser(User user) {
		userDAO.update(user);
	}

	@Transactional
	public Long checkUser(User user) {
			Long userId = userDAO.checkUser(user.getLogin(), user.getPassword());
			return userId;
		}
	}

