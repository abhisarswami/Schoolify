package com.bitsatom.schoolify.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitsatom.schoolify.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    public Student findByFirstName(String firstName);
    public List<Student> findByLastName(String lastName);

}
