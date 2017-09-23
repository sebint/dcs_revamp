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
import com.humworks.dcs.dao.UserStatusDao;
import com.humworks.dcs.entities.Login;
import com.humworks.dcs.entities.User;
import com.humworks.dcs.entities.UserRole;
import com.humworks.dcs.entities.UserStatus;
import com.humworks.dcs.service.SessionService;
import com.humworks.dcs.service.UserService;

@Service("userService")
@PropertySource(value={"classpath:constants.properties"})
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserStatusDao userStatusDao;
	
	@Autowired
	private UserRoleDao userRoleDao;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private SessionService sessionService;	
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void setUserStatusDao(UserStatusDao userStatusDao) {
		this.userStatusDao = userStatusDao;
	}

	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}

	public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	public void setSessionService(SessionService sessionService) {
		this.sessionService = sessionService;
	}

	@Override
	@Transactional
	public void save(User user) {
		   String currentUser = sessionService.getActiveFullName();
	       user.setStrPassword(passwordEncoder.encode(environment.getProperty("default_password")));	     
	       user.setStrCreatedBy(currentUser);
	       user.setStrModifiedBy(currentUser);
	       Long uid = userDao.saveUser(user);
	       if(uid!=null){
	    	   //User Role Info
		       UserRole userRole = new UserRole();
		       userRole.setIntUserId(uid);
		       userRole.setIntRoleId(user.getIntRoleId());
		       userRole.setStrCreatedBy(currentUser);
		       userRole.setStrModifiedBy(currentUser);
		       userRoleDao.saveUserRole(userRole);
		       //User Status Info
		       userStatusDao.saveStatus(new UserStatus(uid, 1, 1, 1, 0, currentUser, currentUser));		   
	       }	       
	}

	@Override
	@Transactional(readOnly = true)
	public User findById(Long id) {
		return userDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		 return userDao.findByUsername(username);
	}

	@Override
	@Transactional(readOnly = true)
	public ArrayList<User> selectAll() {	
		return userDao.selectAll();
	}

	@Override
	@Transactional
	public Integer update(User user) {
		try{
		   String currentUser = sessionService.getActiveFullName();
		   user.setStrModifiedBy(currentUser);
		   if(userDao.updateUser(user)>0){
		       UserRole userRole = new UserRole();
		       userRole.setIntUserId(user.getIntUserId());
		       userRole.setIntRoleId(user.getIntRoleId());
		       userRole.setStrModifiedBy(currentUser);
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
	@Transactional
	public void delete(User user) {
		userDao.deleteUser(user);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Long findUid(String username) {		
		return userDao.findUid(username);
	}

	@Override
	@Transactional
	public Long resetPassword(Login reset) {
		reset.setStrPassword(passwordEncoder.encode(reset.getStrPassword()));
		return userDao.resetPassword(reset);
	}

	@Override
	public Boolean checkPassword(Long uid, String password) {	
		if(passwordEncoder.matches(password, userDao.checkPassword(uid))){
			return true;
		}
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public ArrayList<User> findByRoleId(Long roleMasterId) {		
		return userDao.findByRoleId(userRoleDao.findByRole(roleMasterId));
	}

	@Override
	@Transactional
	public Long updateStatus(String field, Integer value, Long userId) {
		return userDao.updateStatusField(field, value, userId) ;
	}

}
