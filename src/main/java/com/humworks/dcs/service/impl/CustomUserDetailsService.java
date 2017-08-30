package com.humworks.dcs.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.humworks.dcs.entities.Role;
import com.humworks.dcs.entities.SpringUser;
import com.humworks.dcs.entities.User;
import com.humworks.dcs.service.UserService;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;	

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		User user = userService.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username + "Not Found!");
		}
		return new SpringUser(user.getStrUserName(), user.getStrPassword(),
				user.getStrStatus().equals("ACTIVE"), true, true, true, getGrantedAuthorities(user), user.getIntUserId(),user.getStrFirstName(),user.getStrLastName(),user.getStrEmail());
	}

	/**
	 * @Desc 
	 * @param user
	 * @return ArrayList<GrantedAuthority>
	 */
	private List<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		//BoolPwdChange = 1 - Requires to change password after Login(New Role Assigned 'ROLE_CHANGE_PASSWORD') - Can only access the password change page only.
		//BoolPwdChange = 0 - Continue with the login process
		if(user.getBoolPwdChange()==0){
			for (Role role : user.getRole()) {
				authorities.add(new SimpleGrantedAuthority("ROLE_" + roleStringConvertion(role.getStrRoleName())));
			}
		}else{
			authorities.add(new SimpleGrantedAuthority("ROLE_CHANGE_PASSWORD"));
		}
		return authorities;
	}
	/**
	 * @author Sebin Thomas
	 * @desc Based on the given role returns the application defined role name.["Administator":"ADMIN","Gate Keeper":"GK","Information Manager":"IM","PDO":"PDO"]
	 * 		 Add and modify the method if new Role is added.
	 * @param role
	 * @return String
	 */
	private String roleStringConvertion(String role){
		return ("Administrator".equals(role))?"ADMIN":((("Gate Keeper".equals(role))?"GK":("Information Manager".equals(role)?"IM":("PDO".equals(role)?"PDO":role))));
	}
	

}
