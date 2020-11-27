package com.webapp.hotel.userDetails;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserLoggedIn extends User {
	
	private com.webapp.hotel.entity.User user;

	public UserLoggedIn(String username, String password, Collection<? extends GrantedAuthority> authorities, com.webapp.hotel.entity.User user) {
		super(username, password, authorities);
		this.user = user;
	}

	public com.webapp.hotel.entity.User getUser() {
		return user;
	}

	public void setUser(com.webapp.hotel.entity.User user) {
		this.user = user;
	}
}