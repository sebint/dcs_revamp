package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.Login;
import com.humworks.dcs.entities.User;

public interface UserDao {

	Long saveUser(User user);
	
	Long updateUser(User user);
	
	Long resetPassword(Login reset);
	
	void deleteUser(User user);
	
	Long updateStatusField(String field, Integer value, Long uid);
    
	Long findUid(String username);
	
    User findById(Long uid);
     
    User findByUsername(String username);
    
    ArrayList<User> findByRoleId(ArrayList<Long> roleMasterId);
    
    ArrayList<User> selectAll();
    
    String checkPassword(Long uid);
    
    void transactionRollback();
}
