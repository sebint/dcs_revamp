package com.humworks.dcs.service;

import java.util.ArrayList;

import com.humworks.dcs.entities.Login;
import com.humworks.dcs.entities.User;

public interface UserService {
		
	void save(User user);
	
	Integer update(User user);
    
	Integer resetPassword(Login reset);
	
	void delete(User user);
	
    User findById(Integer id);
    
    Integer findUid(String username);
    
    User findByUsername(String username);
    
    Boolean checkPassword(Integer uid, String password);
    
    ArrayList<User> selectAll();
}
