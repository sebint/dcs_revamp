package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.User;

public interface UserDao {

	int saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(User user);
    
    User findById(Integer uid);
     
    User findByUsername(String username);
    
    ArrayList<User> selectAll();
}
