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
import com.bitsatom.schoolify.dao.assembler.StudentResourceAssembler;
import com.bitsatom.schoolify.exception.SchoolifyException;
import com.bitsatom.schoolify.model.Student;
import com.bitsatom.schoolify.service.StudentService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

@RestController
@EnableAutoConfiguration
@RequestMapping(value = "/students")
@Api(value = "Student API", description = "Student API")
public class StudentController {

	private StudentService studentService;
	
	@Autowired
	private StudentResourceAssembler studentResourceAssembler;

	@Autowired
	public StudentController(StudentService studentService, StudentResourceAssembler studentResourceAssembler) {
		this.studentService = studentService;
		this.studentResourceAssembler = studentResourceAssembler;
	}

	@RequestMapping(value = "/{student_id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get Student", notes = "Get the details of a specific student", response = Student.class)
	public @ResponseBody
	StudentResource.StudentResponse getStudent(@PathVariable int student_id) {
		return studentResourceAssembler.toResource(studentService
				.getStudent(student_id));
	}

	@RequestMapping(method = RequestMethod.GET)
	@ApiOperation(value = "Get Students", notes = "Get the list of students", response = Student.class, responseContainer = "List")
	public List<StudentResource.StudentResponse> getStudents() {
		return studentResourceAssembler.toResources(studentService
				.getStudents());
	}

	@RequestMapping(method = RequestMethod.POST)
	@ApiOperation(value = "Create Student", notes = "Create a student", response = StudentResource.StudentResponse.class)
	public @ResponseBody
	HttpEntity<StudentResource.StudentResponse> createStudent(
			@RequestBody StudentResource.NewStudent student) {
		StudentResource.StudentResponse createdStudentResource = studentResourceAssembler
				.toResource(studentService.createOrUpdateStudent(new Student(student
						.getFirstName(), student.getLastName())));

		return new ResponseEntity<StudentResource.StudentResponse>(
				createdStudentResource, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ApiOperation(value = "Update Student", notes = "Update a student", response = StudentResource.StudentResponse.class)
	public @ResponseBody
	HttpEntity<StudentResource.StudentResponse> updateStudent(
			@RequestBody StudentResource.UpdateStudent student) throws SchoolifyException {
		if (student.getStudent_id().isEmpty()){
			throw new SchoolifyException("Invalid student id");
		}
		StudentResource.StudentResponse updatedStudentResource = studentResourceAssembler
				.toResource(studentService.createOrUpdateStudent(new Student(student
						.getFirstName(), student.getLastName())));

		return new ResponseEntity<StudentResource.StudentResponse>(
				updatedStudentResource, HttpStatus.OK);
	}

	@RequestMapping(value = "/{student_id}", method = RequestMethod.DELETE)
	public @ResponseBody
	void deleteStudent(@PathVariable int student_id) {
		studentService.deleteStudent(student_id);
	}
	
	// TODO implementation of Patch
}
