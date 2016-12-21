package com.humworks.dcs.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.UserDao;
import com.humworks.dcs.entities.User;
import com.humworks.dcs.service.UserService;

@Service("userService")
@Transactional
@PropertySource(value={"classpath:constants.properties"})
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void save(User user) {
	       user.setStrPassword(passwordEncoder.encode(environment.getProperty("default_password")));
	       user.setIntCreatedBy(1);
	       user.setIntModifiedBy(1);
	       userDao.save(user);
	}

	@Override
	public User findById(Integer id) {
		return userDao.findById(id);
	}

	@Override
	public User findByUsername(String username) {
		 return userDao.findByUsername(username);
	}

	@Override
	public ArrayList<User> selectAll() {	
		return userDao.selectAll();
	}

}
