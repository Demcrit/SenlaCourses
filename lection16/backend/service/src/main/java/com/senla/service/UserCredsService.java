package com.senla.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senla.dao.api.UserCredsDAO;
import com.senla.dao.api.UserDAO;
import com.senla.model.User;
import com.senla.model.UserCreds;

@Service
public class UserCredsService {

	@Autowired
	private UserCredsDAO userCredsDao;
	@Autowired
	private UserDAO userDao;

	@Transactional
	public void addUserCreds(UserCreds userCreds) {
		userCredsDao.add(userCreds);
	}

	@Transactional
	public void updateUserCreds(UserCreds userCreds) {
		userCredsDao.update(userCreds);
	}

	@Transactional
	public UserCreds getUserCreds(Long id) {
		User user = userDao.getById(id);
		UserCreds userCreds = userCredsDao.getUserData(user);
		return userCreds;
	}
}
