package com.humworks.dcs.service;

import java.util.ArrayList;

import com.humworks.dcs.entities.Login;
import com.humworks.dcs.entities.User;

public interface UserService {
		
	void save(User user);
	
	Integer update(User user);
    
	Long resetPassword(Login reset);
	
	void delete(User user);
	
    User findById(Long id);
    
    Long findUid(String username);
    
    Long updateStatus(String field, Integer value, Long userId);
    
    User findByUsername(String username);
    
    ArrayList<User> findByRoleId(Long roleMasterId);
    
    Boolean checkPassword(Long uid, String password);
    
    ArrayList<User> selectAll();
}
