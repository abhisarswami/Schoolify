package com.bitsatom.schoolify.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bitsatom.schoolify.dao.ClazzResource;
import com.bitsatom.schoolify.dao.assembler.ClazzResourceAssembler;
import com.bitsatom.schoolify.model.Student;
import com.bitsatom.schoolify.service.ClazzService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/clazz")
@Api(value = "Class API", description = "Student API")
public class ClazzController {

	@Autowired
	private ClazzService clazzService;
	@Autowired
	private ClazzResourceAssembler clazzResourceAssembler;

	@Inject
	public ClazzController(ClazzService clazzService) {
		this.clazzService = clazzService;
	}



	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get classes", notes = "Get the list of class", response = Student.class, responseContainer = "List")
	public List<ClazzResource.ClazzResponse> getStudents() {
		return clazzResourceAssembler.toResources(clazzService.getClassList());
	}


	
	// TODO implementation of Patch
}
