package com.bitsatom.schoolify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitsatom.schoolify.model.Student;
import com.bitsatom.schoolify.persistence.StudentRepository;

@Service
@Transactional
public class StudentServiceImpl implements StudentService  {

	@Autowired
	private StudentRepository studentRepository;
	
	/* (non-Javadoc)
	 * @see com.bitsatom.schoolify.service.StudentService#getStudent(java.lang.String)
	 */
	@Override
	public Student getStudent(final int student_id){
		return studentRepository.findOne(student_id);
	}
	
	/* (non-Javadoc)
	 * @see com.bitsatom.schoolify.service.StudentService#getStudents()
	 */
	@Override
	public Iterable<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.bitsatom.schoolify.service.StudentService#createStudent(com.bitsatom.schoolify.model.Student)
	 */
	@Override
	public Student createOrUpdateStudent(final Student student){
		return studentRepository.save(student);
	}
	
	/* (non-Javadoc)
	 * @see com.bitsatom.schoolify.service.StudentService#deleteStudent(java.lang.String)
	 */
	@Override
	public void deleteStudent(final int student){
		studentRepository.delete(student);
	}

}
