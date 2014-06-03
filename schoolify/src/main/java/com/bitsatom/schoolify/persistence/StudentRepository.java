package com.bitsatom.schoolify.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bitsatom.schoolify.model.Student;

public interface StudentRepository extends CrudRepository<Student, String> {

    public Student findByFirstName(String firstName);
    public List<Student> findByLastName(String lastName);

}
