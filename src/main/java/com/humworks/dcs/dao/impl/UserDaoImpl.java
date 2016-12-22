package com.humworks.dcs.dao.impl;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.humworks.dcs.dao.AbstractDao;
import com.humworks.dcs.dao.UserDao;
import com.humworks.dcs.entities.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	@Override
	public int saveUser(User user) {
		 return save(user);
	}

	@Override
	public User findById(Integer uid) {
		return getByKey(uid);
	}

	@Override
	public User findByUsername(String username) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("strUserName", username));
        return (User) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<User> selectAll() {
		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.desc("intUserId"));
		return (ArrayList<User>) criteria.list();
	}
	
}
