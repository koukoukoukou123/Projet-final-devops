package com.sogeti.security;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;


import com.sogeti.enums.EnumRoles;
import com.sogeti.model.User;
import com.sogeti.service.UserService;


@Service
@Transactional
public class AuthentificationService implements UserDetailsService{
	@Autowired
	private UserService userservice;

	@Override
	public UserDetails loadUserByUsername(final String username) {
		User user = userservice.findByUsername(username);
		List<GrantedAuthority> rules = this.getUserCredentials(user);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), rules);
		
	}
	
	
	private List<GrantedAuthority> getUserCredentials(User user) {
		 List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		 
		 authorities.add(new SimpleGrantedAuthority(EnumRoles.ROLE_USER.getRole()));
		 if(user.getRole().equals(EnumRoles.ROLE_ADMIN.getRole()))
		 {
			 authorities.add(new SimpleGrantedAuthority(EnumRoles.ROLE_ADMIN.getRole()));
		 }
		 
		return authorities;
	}

}
