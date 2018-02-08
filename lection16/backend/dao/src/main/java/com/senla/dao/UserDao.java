package com.senla.dao;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import com.senla.dao.api.UserDAO;
import com.senla.model.User;

@Repository
public class UserDao extends BaseDao<User> implements UserDAO {

	public UserDao() {
		super(User.class);
	}

	@Override
	public Long checkUser(String login, String password) {
		Criteria criteria = getSession().createCriteria(User.class).add(Restrictions.like("login", login))
				.add(Restrictions.like("password", password));
		User checked = (User) criteria.uniqueResult();
		return checked.getId();
	}

	@Override
	public User getCheckedUser(String login, String password) {
		Criteria criteria = getSession().createCriteria(User.class).add(Restrictions.like("login", login))
				.add(Restrictions.like("password", password));
		User user = (User) criteria.uniqueResult();
		return user;
	}

}
