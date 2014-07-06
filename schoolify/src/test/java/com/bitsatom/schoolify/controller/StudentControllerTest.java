package com.bitsatom.schoolify.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.bitsatom.schoolify.Application;
import com.bitsatom.schoolify.TestInitialization;
import com.bitsatom.schoolify.TestUtil;
import com.bitsatom.schoolify.dao.StudentResource;
import com.bitsatom.schoolify.dao.StudentResource.StudentResponse;
import com.bitsatom.schoolify.dao.assembler.StudentResourceAssembler;
import com.bitsatom.schoolify.exception.SchoolifyException;
import com.bitsatom.schoolify.model.Student;
import com.bitsatom.schoolify.service.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {Application.class})
@WebAppConfiguration
public class StudentControllerTest {

	@Mock
	private StudentService studentService;
	@Autowired
	private StudentResourceAssembler studentResourceAssembler;
	private StudentController studentController;

	private MockMvc mockMvc;
	
	@Autowired
    WebApplicationContext wac;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		// Setup Spring test in webapp-mode (same config as spring-boot)
        //this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		this.mockMvc = MockMvcBuilders.standaloneSetup(new StudentController(studentService, studentResourceAssembler) ).build();
	}

	@Test
	public void createUpdateStudentWithHATEOAS() throws Exception{
		
		when(studentService.createOrUpdateStudent(any(Student.class)))
				.thenReturn(TestInitialization
						.getCreatedStudentEntity());
		this.mockMvc.perform(post("/students")
				.contentType(TestUtil.APPLICATION_JSON_UTF8)
				.content(TestUtil.convertObjectToJsonBytes(TestInitialization.newStudentResource))
				)
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().contentType(TestUtil.APPLICATION_JSON_UTF8))
			.andExpect(jsonPath("$.student_id", is("1")))
			.andExpect(jsonPath("$.firstName", is(TestInitialization.testStudentFirstName)))
			.andExpect(jsonPath("$.lastName", is(TestInitialization.testStudentLastName)))
			.andExpect(jsonPath("$.links", hasSize(1)));
			
		verify(studentService, times(1)).createOrUpdateStudent(any(Student.class));
		verifyNoMoreInteractions(studentService);
	}

	// @Test(dependsOnMethods = { "createUpdateStudentWithHATEOAS" })
	public void updateStudentWithHATEOAS() {
		// mock the service response
		final Student updatedStudent = TestInitialization
				.getUpdatedStudentEntity();
		when(studentService.createOrUpdateStudent(any(Student.class)))
				.thenReturn(updatedStudent);

		// update the student
		try {
			StudentResource.UpdateStudent updatedStudentResource = TestInitialization
					.getToBeUpdatedResponseStudent();
			HttpEntity<StudentResponse> response = studentController
					.updateStudent(updatedStudentResource);

			// verify results
			verify(studentService, times(1)).createOrUpdateStudent(
					updatedStudent);
			assertNotNull(
					"Self reference of the saved object should not be null",
					response.getBody().getLink("self"));
			assertEquals("First Name to the returned object is not same",
					updatedStudent.getLastName(), response.getBody()
							.getLastName());
		} catch (SchoolifyException e) {

		}
	}

}
