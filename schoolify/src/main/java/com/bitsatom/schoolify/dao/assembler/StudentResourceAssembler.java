/**
 * 
 */
package com.bitsatom.schoolify.dao.assembler;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.bitsatom.schoolify.controller.StudentController;
import com.bitsatom.schoolify.dao.StudentResource;
import com.bitsatom.schoolify.model.Student;

/**
 * @author 30155174
 * 
 */
@Component
public class StudentResourceAssembler extends
		ResourceAssemblerSupport<Student, StudentResource.StudentResponse> {

	public StudentResourceAssembler() {
		super(StudentController.class, StudentResource.StudentResponse.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public StudentResource.StudentResponse toResource(Student student) {
		StudentResource.StudentResponse resource = createResourceWithId(
				student.getStudent_id(), student);
		return resource;
	}

	@Override
	protected StudentResource.StudentResponse instantiateResource(
			Student student) {
		return new StudentResource.StudentResponse(student.getStudent_id(),
				student.getFirstName(), student.getLastName());
	}

}
