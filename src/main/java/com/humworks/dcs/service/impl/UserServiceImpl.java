package com.humworks.dcs.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.UserDao;
import com.humworks.dcs.dao.UserRoleDao;
import com.humworks.dcs.entities.Login;
import com.humworks.dcs.entities.User;
import com.humworks.dcs.entities.UserRole;
import com.humworks.dcs.service.SessionService;
import com.humworks.dcs.service.UserService;

@Service("userService")
@Transactional
@PropertySource(value={"classpath:constants.properties"})
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SessionService sessionService;	
	
	@Override
	public void save(User user) {
		   Integer currentUser = sessionService.getActiveUid();
	       user.setStrPassword(passwordEncoder.encode(environment.getProperty("default_password")));	     
	       user.setIntCreatedBy(currentUser);
	       user.setIntModifiedBy(currentUser);
	       Integer uid = userDao.saveUser(user);
	       if(uid!=null){
		       UserRole userRole = new UserRole();
		       userRole.setIntUserId(uid);
		       userRole.setIntRoleId(user.getIntRoleId());
		       userRole.setIntCreatedBy(currentUser);
		       userRole.setIntModifiedBy(currentUser);
		       userRoleDao.saveUserRole(userRole);
	       }	       
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

	@Override
	public Integer update(User user) {
		try{
		   Integer currentUser = sessionService.getActiveUid();
		   user.setIntModifiedBy(currentUser);
		   if(userDao.updateUser(user)>0){
		       UserRole userRole = new UserRole();
		       userRole.setIntUserId(user.getIntUserId());
		       userRole.setIntRoleId(user.getIntRoleId());
		       userRole.setIntModifiedBy(currentUser);
		       if(userRoleDao.updateUserRole(userRole)>0){
		    	   return 1;
		       }
		   }
//		   userDao.transactionRollback();
		   return 0;
		}catch(Exception ex){
			ex.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public void delete(User user) {
		userDao.deleteUser(user);
		
	}

	@Override
	public Integer findUid(String username) {		
		return userDao.findUid(username);
	}

	@Override
	public Integer resetPassword(Login reset) {
		reset.setStrPassword(passwordEncoder.encode(reset.getStrPassword()));
		return userDao.resetPassword(reset);
	}

	@Override
	public Boolean checkPassword(Integer uid, String password) {	
		if(passwordEncoder.matches(password, userDao.checkPassword(uid))){
			return true;
		}
		return false;
	}

	@Override
	public ArrayList<User> findByRoleId(Integer roleMasterId) {		
		return userDao.findByRoleId(userRoleDao.findByRole(roleMasterId));
	}

	@Override
	public Integer updateStatus(String field, Integer value, Integer userId) {
		return userDao.updateStatusField(field, value, userId) ;
	}

}
