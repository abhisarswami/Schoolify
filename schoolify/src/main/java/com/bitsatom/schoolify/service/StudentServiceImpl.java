package com.bitsatom.schoolify.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bitsatom.schoolify.dao.StudentRepository;
import com.bitsatom.schoolify.model.Student;

@Service
public class StudentServiceImpl implements StudentService  {

	
	private StudentRepository studentRepository;
	
	@Inject
	public StudentServiceImpl(StudentRepository repository){
		this.studentRepository = repository;
	}
	
	/* (non-Javadoc)
	 * @see com.bitsatom.schoolify.service.StudentService#getStudent(java.lang.String)
	 */
	@Override
	@Transactional
	public Student getStudent(final String student_id){
		return studentRepository.findOne(student_id);
	}
	
	/* (non-Javadoc)
	 * @see com.bitsatom.schoolify.service.StudentService#getStudents()
	 */
	@Override
	@Transactional
	public List<Student> getStudents(){
		return studentRepository.findAll();
	}
	
	/* (non-Javadoc)
	 * @see com.bitsatom.schoolify.service.StudentService#createStudent(com.bitsatom.schoolify.model.Student)
	 */
	@Override
	@Transactional
	public Student createStudent(final Student student){
		return studentRepository.save(student);
	}
	
	/* (non-Javadoc)
	 * @see com.bitsatom.schoolify.service.StudentService#deleteStudent(java.lang.String)
	 */
	@Override
	@Transactional
	public void deleteStudent(final String student){
		studentRepository.delete(student);
	}
}
