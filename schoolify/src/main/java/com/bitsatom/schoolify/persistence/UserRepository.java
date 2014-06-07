package com.bitsatom.schoolify.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bitsatom.schoolify.model.User;

@Transactional(readOnly = true) 
public interface UserRepository extends JpaRepository<User, Integer>{

	public abstract User findByEmail(String email);
	public abstract User findByEmailAndPassword(String email, String password);
	public abstract User findUserByEmail(String email);
	
}
