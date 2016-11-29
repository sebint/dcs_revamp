package com.humworks.dcs.entities;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

public class SpringUser extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = -4024628574542273425L;

	private final Integer userId;
	private final String firstName;
	private final String lastName;
	private final String email;

	public SpringUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities,
			Integer userId, String firstName, String lastName, String email) {
		
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}
}
