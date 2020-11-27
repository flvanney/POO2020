package com.webapp.hotel.service;

import com.webapp.hotel.entity.User;
import com.webapp.hotel.userDetails.UserLoggedIn;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImp implements UserDetailsService {

	@Autowired
	private UserService userService;

	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
 
    	try { 
    		com.webapp.hotel.entity.User u = userService.findUserByUsername(username);
    		
    		List grantedAuthorities = new ArrayList();
    		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(u.getRole());
    		grantedAuthorities.add(grantedAuthority);
    	     
    		//UserDetails user = (UserDetails) new User(u.getUsername(), u.getPassword(), grantedAuthorities);
    		
    		
    		UserLoggedIn user = new UserLoggedIn(u.getUsername(), u.getPassword(), grantedAuthorities, u);
    		
    		return user;
    	}	
    	catch(NoSuchElementException e) {
    		throw new UsernameNotFoundException("User no found!");
    	}
   
    }
	
	public User create(User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		return user;
	}
}