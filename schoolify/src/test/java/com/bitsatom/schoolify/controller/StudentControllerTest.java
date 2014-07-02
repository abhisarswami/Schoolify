package com.bitsatom.schoolify.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.testng.annotations.Test;

import com.bitsatom.schoolify.TestInitialization;
import com.bitsatom.schoolify.dao.StudentResource;
import com.bitsatom.schoolify.dao.StudentResource.StudentResponse;
import com.bitsatom.schoolify.exception.SchoolifyException;
import com.bitsatom.schoolify.model.Student;
import com.bitsatom.schoolify.service.StudentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StudentControllerTest {

	@Mock
	private StudentServiceImpl studentService;

	private StudentController studentController;

	@Before
	public void setUp() {
		studentController = new StudentController(studentService);
	}

	@Test(groups = { "student.create" })
	public void createUpdateStudentWithHATEOAS() {
		// mock the service response
		final Student savedStudent = TestInitialization
				.getCreatedStudentEntity();
		when(studentService.createOrUpdateStudent(any(Student.class)))
				.thenReturn(savedStudent);
		// create a student
		final StudentResource.NewStudent student = TestInitialization.newStudentResource;
		HttpEntity<StudentResponse> response = studentController
				.createStudent(student);
		TestInitialization.createdStudentResource = response.getBody();

		// verify the results
		verify(studentService, times(1)).createOrUpdateStudent(savedStudent);
		assertNotNull("Self reference of the saved object should not be null",
				response.getBody().getLink("self"));
		assertEquals("First Name to the returned object is not same",
				savedStudent.getFirstName(), response.getBody().getLastName());

	}

	@Test(dependsOnMethods = { "createUpdateStudentWithHATEOAS" })
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
