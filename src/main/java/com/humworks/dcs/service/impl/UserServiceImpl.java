package com.humworks.dcs.service.impl;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.dao.UserDao;
import com.humworks.dcs.dao.UserRoleDao;
import com.humworks.dcs.entities.User;
import com.humworks.dcs.entities.UserRole;
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
	private HttpSession session;
	
	@Override
	public void save(User user) {
	       user.setStrPassword(passwordEncoder.encode(environment.getProperty("default_password")));
	       user.setIntCreatedBy((Integer)session.getAttribute("DCSUID"));
	       user.setIntModifiedBy((Integer)session.getAttribute("DCSUID"));
	       System.out.println(session.getAttribute("DCSUID"));
	       Integer uid = userDao.saveUser(user);
	       if(uid!=null){
		       UserRole userRole = new UserRole();
		       userRole.setIntUserId(uid);
		       userRole.setIntRoleId(user.getIntRoleId());
		       userRole.setIntCreatedBy((Integer)session.getAttribute("DCSUID"));
		       userRole.setIntModifiedBy((Integer)session.getAttribute("DCSUID"));
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
		   user.setIntModifiedBy((Integer)session.getAttribute("DCSUID"));
		   if(userDao.updateUser(user)>0){
		       UserRole userRole = new UserRole();
		       userRole.setIntUserId(user.getIntUserId());
		       userRole.setIntRoleId(user.getIntRoleId());
		       userRole.setIntModifiedBy((Integer)session.getAttribute("DCSUID"));
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

}
