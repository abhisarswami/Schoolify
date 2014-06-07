package com.bitsatom.schoolify;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.bitsatom.schoolify.model.Role;
import com.bitsatom.schoolify.model.User;
import com.bitsatom.schoolify.service.UserRoleService;
import com.bitsatom.schoolify.service.UserService;

@Component
public class DBInitializer
{
	private static Logger logger = LoggerFactory.getLogger(DBInitializer.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;

	@Value("${init-db:false}")
	private String initDatabase;

	@PostConstruct
	public void init()
	{
		try {
			logger.info("############## InitDatabase :" + initDatabase + " ########################");
			if (Boolean.parseBoolean(initDatabase)) {
				initDatabase();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void initDatabase()
	{

		logger.info("Initializing Database with sample data");
		
		Role role1 = new Role("ROLE_USER");
		Role role2 = new Role("ROLE_ADMIN");
		User user1 = new User("admin", "admin@gmail.com", "admin",null);
		User user2 = new User("user", "user@gmail.com", "user", null);

		//role1.setUser(user1);
		//role2.setUser(user1);
		user1.addRoles(role1, role2);
		//user2.addRoles(role2);
		
		user1 = userService.createUser(user1);
		user2 = userService.createUser(user2);
		user2.addRoles(role1);
		userService.createUser(user2);
		

		logger.info("############   user details" + userService.findAll());


	}
}
