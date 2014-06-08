package com.bitsatom.schoolify.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.bitsatom.schoolify.config.SecurityUser;
import com.bitsatom.schoolify.model.User;
import com.bitsatom.schoolify.service.UserService;

@Component
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String emailName)
			throws UsernameNotFoundException {
		User user = userService.findUserByEmail(emailName);
		if(user == null){
			throw new UsernameNotFoundException("User with email "+emailName+" not found");
		}
		return new SecurityUser(user);
	}
}
