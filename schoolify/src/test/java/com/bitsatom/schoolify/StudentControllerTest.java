package com.bitsatom.schoolify;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.bitsatom.schoolify.controller.StudentController;
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

    
	@Test
	public void shouldCreateStudent() {
		final Student savedStudent = getStudentFromMockService();
		final Student student = new Student();
		//Student returnedStudent = studentController.createStudent(student);
		verify(studentService, times(1)).createStudent(student);
		//assertEquals("",savedStudent,returnedStudent);
	}
	
	private Student getStudentFromMockService(){
		final Student student = new Student();
		when(studentService.createStudent(any(Student.class))).thenReturn(student);
		return student;
	}

}
