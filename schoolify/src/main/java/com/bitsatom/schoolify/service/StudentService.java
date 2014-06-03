package com.bitsatom.schoolify.service;

import com.bitsatom.schoolify.model.Student;

public interface StudentService {

	public abstract Student getStudent(String student_id);

	public abstract Iterable<Student> getStudents();

	public abstract Student createStudent(Student student);

	public abstract void deleteStudent(String student);

}