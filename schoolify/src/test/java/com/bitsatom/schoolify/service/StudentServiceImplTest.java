package com.bitsatom.schoolify.service;

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

import com.bitsatom.schoolify.dao.StudentRepository;
import com.bitsatom.schoolify.model.Student;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {

	@Mock
	private StudentRepository studentRepository;
	private StudentService studentService;
	
	@Before
	public void setup(){
		studentService = new StudentServiceImpl(studentRepository);
	}
	
	@Test
	public void saveNewStudent(){
		final Student savedStudent = getSavedStudentFromRepository();
		final Student student = new Student();
		final Student returnedStudent = studentService.createStudent(student);
		verify(studentRepository, times(1)).save(student);
		assertEquals("returned student should come from repository",savedStudent, returnedStudent);
	}

	private Student getSavedStudentFromRepository() {
		Student student = new Student();
		when(studentRepository.save(any(Student.class))).thenReturn(student);
		return student;
	}
}
