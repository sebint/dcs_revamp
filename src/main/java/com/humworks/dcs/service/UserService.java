package com.humworks.dcs.service;

import java.util.ArrayList;

import com.humworks.dcs.entities.User;

public interface UserService {
	
	
	void save(User user);
	
	Integer update(User user);
    
	void delete(User user);
	
    User findById(Integer id);
    
    Integer findUid(String username);
    
    User findByUsername(String username);
    
    ArrayList<User> selectAll();
}
