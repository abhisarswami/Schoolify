package com.bitsatom.schoolify.service;

import javax.inject.Inject;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitsatom.schoolify.model.Role;
import com.bitsatom.schoolify.model.User;
import com.bitsatom.schoolify.persistence.UserRepository;

@Service
@Transactional(readOnly = true) 
public class UserService {
	// private UserDao userDao;

	private UserRepository userRepository;

	@Inject
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Transactional
	public User createUser(final User user) {
		return userRepository.save(user);
	}

	@Query("SELECT p FROM Person p JOIN FETCH p.roles")
	public Iterable<User> findAll() {
		// return userDao.findAll();
		return userRepository.findAll();
	}

	/*
	 * public User create(User user) { //return userDao.create(user); return
	 * userRepository.save(user); }
	 */
	@Query("SELECT p FROM User p JOIN FETCH p.roles WHERE p.id = (:id)")
	public User findUserById(int id) {
		// return userDao.findUserById(id);
		return userRepository.findOne(id);
	}

	public User login(String email, String password) {
		// return userDao.login(email,password);
		// return userRepository.login(email,password);
		return userRepository.findByEmailAndPassword(email, password);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public void deleteUser(int id) {
		// TODO change to soft delete
		userRepository.delete(id);
	}

	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}
	

}
