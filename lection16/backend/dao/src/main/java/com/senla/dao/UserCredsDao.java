package com.senla.dao;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.senla.dao.api.UserCredsDAO;
import com.senla.model.User;
import com.senla.model.UserCreds;

@Repository
public class UserCredsDao extends BaseDao<UserCreds> implements UserCredsDAO {

	@Override
	public UserCreds getUserData(User user) {
		UserCreds userCreds = (UserCreds) getSession().createCriteria(UserCreds.class)
				.add(Restrictions.eq("user", user)).uniqueResult();
		return userCreds;
	}

}
