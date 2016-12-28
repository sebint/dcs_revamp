package com.humworks.dcs.service;

import java.util.ArrayList;

import com.humworks.dcs.entities.User;

public interface UserService {
	
	void save(User user);
	
	void update(User user);
    
	void delete(User user);
	
    User findById(Integer id);
     
    User findByUsername(String username);
    
    ArrayList<User> selectAll();
}
