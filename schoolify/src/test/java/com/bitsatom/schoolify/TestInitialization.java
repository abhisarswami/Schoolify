package com.bitsatom.schoolify;

import com.bitsatom.schoolify.dao.StudentResource;
import com.bitsatom.schoolify.model.Student;

public class TestInitialization {

	public static final String testStudentFirstName = "firstName";
	public static final String testStudentLastName = "lastName";

	public static final String testUpdatedStudentFirstName = "firstNameUpdated";
	public static final String testUpdatedStudentLastName = "lastNameUpdated";
	
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
		  studentUpdatedEntity.setStudent_id(studentId);
		  return studentUpdatedEntity;
	}
	
	public static Student getCreatedStudentEntity() {
		 studentCreatedEntity = new Student(testStudentFirstName,
				 testStudentLastName);
		 studentCreatedEntity.setStudent_id(studentId);
		  return studentCreatedEntity;
	}

}
