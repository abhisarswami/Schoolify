package com.bitsatom.schoolify.service;

import javax.inject.Inject;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.bitsatom.schoolify.model.User;
import com.bitsatom.schoolify.persistence.UserRepository;

@Service
@Transactional
public class UserService {
	// private UserDao userDao;

	private UserRepository userRepository;

	@Inject
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User createUser(final User user) {
		return userRepository.save(user);
	}

	public Iterable<User> findAll() {
		// return userDao.findAll();
		return userRepository.findAll();
	}

	/*
	 * public User create(User user) { //return userDao.create(user); return
	 * userRepository.save(user); }
	 */

	public User findUserById(String id) {
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

	public void deleteUser(String id) {
		// TODO change to soft delete
		userRepository.delete(id);
	}

	public User findUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

}
