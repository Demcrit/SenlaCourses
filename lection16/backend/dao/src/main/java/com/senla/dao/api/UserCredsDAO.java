package com.senla.dao.api;

import com.senla.model.User;
import com.senla.model.UserCreds;

public interface UserCredsDAO extends BaseDAO<UserCreds> {
	UserCreds getUserData(User user);

}
