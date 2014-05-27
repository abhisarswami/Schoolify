package com.bitsatom.schoolify.service;

import java.util.List;

import com.bitsatom.schoolify.model.Student;

public interface StudentService {

	public abstract Student getStudent(String student_id);

	public abstract List<Student> getStudents();

	public abstract Student createStudent(Student student);

	public abstract void deleteStudent(String student);

}