package com.bitsatom.schoolify;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.bitsatom.schoolify.model.Role;
import com.bitsatom.schoolify.model.User;
import com.bitsatom.schoolify.service.UserRoleService;
import com.bitsatom.schoolify.service.UserService;
import com.mangofactory.swagger.plugin.EnableSwagger;

@EnableAutoConfiguration
@ComponentScan
@EnableSwagger
public class Application {
	// @RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
	}

	

}
