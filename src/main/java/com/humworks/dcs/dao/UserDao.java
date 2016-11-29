package com.humworks.dcs.dao;

import java.util.ArrayList;

import com.humworks.dcs.entities.User;

public interface UserDao {

    void save(User user);
    
    User findById(Integer uid);
     
    User findByUsername(String username);
    
    ArrayList<User> selectAll();
}
