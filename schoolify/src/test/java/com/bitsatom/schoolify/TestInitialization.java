package com.bitsatom.schoolify;

import com.bitsatom.schoolify.dao.StudentResource;
import com.bitsatom.schoolify.model.Student;

public class TestInitialization {

	private static final String testStudentFirstName = "firstName";
	private static final String testStudentLastName = "lastName";

	private static final String testUpdatedStudentFirstName = "firstNameUpdated";
	private static final String testUpdatedStudentLastName = "lastNameUpdated";
	
	private static final String studentId = "1";

	public static final StudentResource.NewStudent newStudentResource = new StudentResource.NewStudent(
			testStudentFirstName, testStudentLastName);
	public static StudentResource.StudentResponse createdStudentResource;
	
	private static Student studentCreatedEntity;  
	private static Student studentUpdatedEntity;  

	public static StudentResource.UpdateStudent getToBeUpdatedResponseStudent() {
		return new StudentResource.UpdateStudent(
				createdStudentResource.getStudent_id(), testUpdatedStudentFirstName,
				testUpdatedStudentLastName);
	}
	
	public static Student getUpdatedStudentEntity() {
		studentUpdatedEntity = new Student(testUpdatedStudentFirstName,
				testUpdatedStudentLastName);
		  studentUpdatedEntity.setId(studentId);
		  return studentUpdatedEntity;
	}
	
	public static Student getCreatedStudentEntity() {
		 studentCreatedEntity = new Student(testUpdatedStudentFirstName,
				testUpdatedStudentLastName);
		 studentCreatedEntity.setId(studentId);
		  return studentCreatedEntity;
	}

}
