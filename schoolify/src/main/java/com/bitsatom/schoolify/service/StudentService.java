package com.bitsatom.schoolify.service;

import com.bitsatom.schoolify.model.Student;

public interface StudentService {

	public abstract Student getStudent(int student_id);

	public abstract Iterable<Student> getStudents();

	public abstract Student createOrUpdateStudent(Student student);

	public abstract void deleteStudent(int student);
	
}