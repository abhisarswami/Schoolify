package com.bitsatom.schoolify.persistence;

import org.springframework.data.repository.CrudRepository;

import com.bitsatom.schoolify.model.User;


public interface UserRepository extends CrudRepository<User, String>{

	public abstract User findByEmail(String email);
	public abstract User findByEmailAndPassword(String email, String password);
	public abstract User findUserByEmail(String email);
	
}
