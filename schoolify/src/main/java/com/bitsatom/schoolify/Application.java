package com.bitsatom.schoolify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mangofactory.swagger.plugin.EnableSwagger;

@EnableAutoConfiguration
@ComponentScan
@EnableSwagger
@EnableWebMvc
public class Application {
	// @RequestMapping("/")
	String home() {
		return "Hello World!";
	}

	public static void main(String[] args) throws Exception {
		ApplicationContext context = SpringApplication.run(Application.class, args);
		
	}

	

}
