package com.bitsatom.schoolify.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitsatom.schoolify.dao.StudentResource;
import com.bitsatom.schoolify.dao.UserResource;
import com.bitsatom.schoolify.dao.assembler.UserResourceAssembler;
import com.bitsatom.schoolify.model.Student;
import com.bitsatom.schoolify.model.User;
import com.bitsatom.schoolify.service.UserService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/users")
@Api(value = "User API", description = "User API")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserResourceAssembler userResourceAssembler;

	@Inject
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/{user_id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get user", notes = "Get the details of a specific user", response = Student.class)
	public @ResponseBody
	UserResource.UserResponse getStudent(@PathVariable int user_id) {
		return userResourceAssembler.toResource(userService
				.findUserById(user_id));
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get Users", notes = "Get the list of users", response = Student.class, responseContainer = "List")
	public List<UserResource.UserResponse> getUsers() {
		return userResourceAssembler.toResources(userService.findAll());
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Create User", notes = "Create a user", response = StudentResource.StudentResponse.class)
	public @ResponseBody
	HttpEntity<UserResource.UserResponse> createUser(
			@RequestBody UserResource.NewUser user) {
		UserResource.UserResponse createdStudentResource = userResourceAssembler
				.toResource(userService.createUser(new User(user.getUser()
						.getFirstName(), user.getUser().getLastName(), user
						.getUser().getEmail(), user.getUser().getPassword(),
						user.getUser().getDob())));

		return new ResponseEntity<UserResource.UserResponse>(
				createdStudentResource, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{student_id}", method = RequestMethod.DELETE)
	public @ResponseBody
	void deleteStudent(@PathVariable int user_id) {
		userService.deleteUser(user_id);
	}
}
