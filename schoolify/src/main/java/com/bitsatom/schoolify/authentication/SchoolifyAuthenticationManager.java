package com.bitsatom.schoolify.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.bitsatom.schoolify.model.User;
import com.bitsatom.schoolify.service.UserService;

@Component
public class SchoolifyAuthenticationManager implements AuthenticationManager {

	@Autowired
	UserService userService;

	public SchoolifyAuthenticationManager() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Authentication authenticate(Authentication auth)
			throws AuthenticationException {
		User user = userService.findUserByEmail(auth.getName());
		if (user.getPassword().equals(auth.getCredentials()) && user.getEmail().equals(auth.getName())) {
			return auth;
		}
		throw new BadCredentialsException("Bad Credentials");
	}

}
