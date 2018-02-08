package com.senla.dao.api;

import com.senla.model.User;

public interface UserDAO extends BaseDAO<User> {
	Long checkUser(String login, String password);

	User getCheckedUser(String login, String password);

}
