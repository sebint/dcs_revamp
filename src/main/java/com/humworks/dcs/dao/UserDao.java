package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.Login;
import com.humworks.dcs.entities.User;

public interface UserDao {

	Integer saveUser(User user);
	
	Integer updateUser(User user);
	
	Integer resetPassword(Login reset);
	
	void deleteUser(User user);
	
	Integer updateStatusField(String field, Integer value, Integer uid);
    
	Integer findUid(String username);
	
    User findById(Integer uid);
     
    User findByUsername(String username);
    
    ArrayList<User> findByRoleId(ArrayList<Integer> roleMasterId);
    
    ArrayList<User> selectAll();
    
    String checkPassword(Integer uid);
    
    void transactionRollback();
}
